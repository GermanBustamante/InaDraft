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
        public const string QUERY_PLAYERS_BY_TEAMID = "SELECT * FROM Players WHERE Teamid = @id";
        #endregion

        #region metodos publicos
        /// <summary>
        /// <b>Prototype:</b> public List(clsPlayer) getPlayerListDAL()<br/>
        /// <b>Commentaries:</b>Returns a list of players from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with players from the Players DB table
        /// </summary>
        /// <returns> List(clsPlayer) representing the list of players from the DB</returns>
        public List<clsPlayer> getPlayerListDAL()
        {
            clsPlayer oPlayer;
            List<clsPlayer> playerList = new();
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

        /// <summary>
        /// <b>Prototype:</b> public List(clsPlayer) getPlayerListFromTeamDAL(int teamId)<br/>
        /// <b>Commentaries:</b>Returns a list of players by a team from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with players from the Players DB table by a specific team
        /// </summary>
        /// <param name="teamId"></param>
        /// <returns> List(clsPlayer) representing the list of players from the DB</returns>
        public List<clsPlayer> getPlayerListFromTeamDAL(int teamId)
        {
            clsPlayer oPlayer;
            List<clsPlayer> playerList = new();
            openConection();
            MyReader = executeSelectCondition(QUERY_PLAYERS_BY_TEAMID, teamId);
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
        
        #endregion

        #region metodos privados
        /// <summary>
        /// Build a clsPlayer from MyReader and return it
        /// </summary>
        /// <returns></returns>
        private clsPlayer rebuildPlayer()
        {
            return new clsPlayer((int)MyReader["Id"],
                                         (string)MyReader["Name"],
                                         (int)MyReader["Kick"],
                                         (int)MyReader["Body"],
                                         (int)MyReader["Control"],
                                         (int)MyReader["Guard"],
                                         (int)MyReader["Speed"],
                                         (int)MyReader["Stamina"],
                                         (int)MyReader["Guts"],
                                         (string)MyReader["Photo"],
                                         (int)MyReader["TeamId"],
                                         (int)MyReader["PositionId"]);
        }
        #endregion
    }
}
