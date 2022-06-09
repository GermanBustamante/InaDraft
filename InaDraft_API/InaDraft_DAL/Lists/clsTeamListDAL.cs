using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System.Collections.Generic;

namespace InaDraft_DAL.Lists
{
    public class clsTeamListDAL : clsUtilitySelectDAL
    {
        #region constantes
        public const string QUERY_ALL_TEAMS = "SELECT * FROM Teams";
        public const string QUERY_TEAM_BY_ID = "SELECT * FROM Teams WHERE id = @id";
        #endregion

        #region metodos publicos
        /// <summary>
        /// <b>Prototype:</b> public List(clsTeam) getTeamListDAL()<br/>
        /// <b>Commentaries:</b>Returns a list of teams from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with teams from the Teams DB table
        /// </summary>
        /// <returns> List(clsTeam) representing the list of teams from the DB</returns>
        public List<clsTeam> getTeamListDAL()
        {
            clsTeam oTeam;
            List<clsTeam> teamList = new();
            openConection();
            MyReader = executeSelect(QUERY_ALL_TEAMS);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    oTeam = new clsTeam((int)MyReader["Id"],
                                        (string)MyReader["Name"],
                                        (string)MyReader["Photo"]);
                    teamList.Add(oTeam);
                }
            }
            return teamList;
        }

        public clsTeam getTeamDAL(int id)
        {
            clsTeam oTeam = new();
            openConection();
            MyReader = executeSelectCondition(QUERY_TEAM_BY_ID, id);
            if (MyReader.HasRows)
            {
                MyReader.Read();
                oTeam = new clsTeam (id,
                                    (string)MyReader["Name"],
                                    (string)MyReader["Photo"]);
            }
            closeFlow();
            return oTeam;
        }
        #endregion
    }
}
