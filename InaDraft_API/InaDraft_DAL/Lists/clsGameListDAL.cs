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
        public const string QUERY_ALL_GAMES = "SELECT * FROM Games";
        #endregion

        #region metodos publicos
        public List<clsGame> getGameListDAL()
        {
            List<clsGame> formationList = new();
            openConection();
            MyReader = executeSelect(QUERY_ALL_GAMES);
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
