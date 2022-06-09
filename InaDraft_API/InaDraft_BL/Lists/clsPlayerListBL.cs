using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsPlayerListBL
    {
        /// <summary>
        /// <b>Prototype:</b> public List(clsPlayer) getPlayerListBL()<br/>
        /// <b>Commentaries:</b>Returns a list of players from the DAL<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with all the players from the Players table
        /// </summary>
        /// <returns> List(clsPlayer) players representing the list of players from the DAL</returns>
        public List<clsPlayer> getPlayerListBL()
        {
            return new clsPlayerListDAL().getPlayerListDAL();
        }

        /// <summary>
        /// <b>Prototype:</b> public List(clsPlayer) getPlayerListFromTeamBL()<br/>
        /// <b>Commentaries:</b>Returns a list of players of a team from the DAL<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with all the players of a team from the Players table
        /// </summary>
        /// <param name="teamId"></param>
        /// <returns> List(clsPlayer) players representing the list of players of a team from the DAL</returns>
        public List<clsPlayer> getPlayerListFromTeamBL(int teamId)
        {
            return new clsPlayerListDAL().getPlayerListFromTeamDAL(teamId);
        }
    }
}
