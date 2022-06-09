using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsGameListBL
    {

        /// <summary>
        /// <b>Prototype:</b> public List(clsGame) getGameListOrderByPuntuationBL()<br/>
        /// <b>Commentaries:</b>Returns a list of games from the DAL<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with all the games from the games table
        /// </summary>
        /// <returns> List(clsGame) games representing the list of games from the DAL</returns>
        public List<clsGame> getGameListOrderByPuntuationBL()
        {
            return new clsGameListDAL().getGameListOrderByPuntuationDAL();
        }

    }
}
