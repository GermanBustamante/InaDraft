using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_DAL.Lists
{
    public class clsPlayerListDAL : clsUtilitySelectDAL
    {
        #region constantes
        public const string QUERY_ALL_PLAYERS = "SELECT * FROM Players";
        public const string QUERY_PLAYER_BY_ID = "SELECT * FROM Players WHERE id = @id";
        public const string QUERY_PLAYERS_BY_TEAMID = "SELECT * FROM Players WHERE idTeam = @id";
        #endregion

        #region metodos publicos
        public List<clsPlayer> getPlayerListDAL()
        {
            clsPlayer oPlayer;
            List<clsPlayer> playerList = new List<clsPlayer>();
            openConection();
            MyReader = executeSelect(QUERY_ALL_PLAYERS);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    oPlayer = rebuildPlayer();
                    playerList.Add(oPlayer);
                }
            }
            closeFlow();
            return playerList;
        }

        public clsPlayer getPlayerDAL(int id)
        {
            clsPlayer oPlayer = new();
            openConection();
            MyReader = executeSelectCondition(QUERY_PLAYER_BY_ID, id);
            if (MyReader.HasRows)
            {
                oPlayer = rebuildPlayer();
            }
            closeFlow();
            return oPlayer;
            #endregion
        }


        public List<clsPlayer> getPlayerListFromTeamDAL(int monumentId)
        {
            clsPlayer oPlayer;
            List<clsPlayer> playerList = new List<clsPlayer>();
            openConection();
            MyReader = executeSelectCondition(QUERY_PLAYERS_BY_TEAMID, monumentId);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    oPlayer = rebuildPlayer();
                    playerList.Add(oPlayer);
                }
            }
            closeFlow();
            return playerList;
        }
        #region metodos privados
        private clsPlayer rebuildPlayer()
        {
            return new clsPlayer((int)MyReader["Id"],
                                         (string)MyReader["Name"],
                                         (string)MyReader["Position"],
                                         (int)MyReader["Kick"],
                                         (int)MyReader["Body"],
                                         (int)MyReader["Control"],
                                         (int)MyReader["Guard"],
                                         (int)MyReader["Speed"],
                                         (int)MyReader["Stamina"],
                                         (int)MyReader["Guts"],
                                         (string)MyReader["Photo"],
                                         (int)MyReader["IdTeam"]);
        }
        #endregion
    }
}
