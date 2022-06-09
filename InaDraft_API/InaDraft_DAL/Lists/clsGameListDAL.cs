using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_DAL.Lists
{
    public class clsGameListDAL : clsUtilitySelectDAL
    {

        #region constantes
        public const string QUERY_ALL_GAMES_ORDERED_BY_PUNTUATION = "SELECT * FROM Games ORDER BY Score DESC";
        #endregion

        #region metodos publicos
        /// <summary>
        /// <b>Prototype:</b> public List(clsGame) getGameListOrderByPuntuationDAL()<br/>
        /// <b>Commentaries:</b>Returns a list of games from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with games from the Games DB table ordered by puntuation
        /// </summary>
        /// <returns> List(clsGame) representing the list of games from the DB</returns>
        public List<clsGame> getGameListOrderByPuntuationDAL()
        {
            List<clsGame> formationList = new();
            openConection();
            MyReader = executeSelect(QUERY_ALL_GAMES_ORDERED_BY_PUNTUATION);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    formationList.Add(buildGame());
                }
            }
            closeFlow();
            return formationList;
        }
        #endregion

        #region metodos privados 

        /// <summary>
        /// Build a clsGame from MyReader 
        /// </summary>
        /// <returns> clsGame </returns>
        private clsGame buildGame()
        {
            return new clsGame((int)MyReader["Id"],
                                        (string)MyReader["UserNick"],
                                        (int)MyReader["Score"],
                                        (DateTime)MyReader["Date"], 
                                        (int)MyReader["FormationId"]);
        }

        #endregion

    }
}
