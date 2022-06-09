using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_DAL.Lists
{
    public class clsFormationListDAL : clsUtilitySelectDAL
    {

        #region constantes
        public const string QUERY_ALL_FORMATIONS = "SELECT * FROM Formations";
        #endregion

        #region metodos publicos
        /// <summary>
        /// <b>Prototype:</b> public List(clsFormation) getFormationListDAL()<br/>
        /// <b>Commentaries:</b>Returns a list of formations from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with formations from the Formations DB table
        /// </summary>
        /// <returns> List(clsFormation) representing the list of formations from the DB</returns>
        public List<clsFormation> getFormationListDAL()
        {
            List<clsFormation> formationList= new();
            openConection();
            MyReader = executeSelect(QUERY_ALL_FORMATIONS);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    formationList.Add(buildFormation());
                }
            }
            closeFlow();
            return formationList;
        }
        #endregion

        #region metodos privados 

        /// <summary>
        /// Rebuild a formation from MyReader
        /// </summary>
        /// <returns> clsFormation </returns>
        private clsFormation buildFormation()
        {
            return new clsFormation((int)MyReader["Id"],
                                         (string)MyReader["Name"],
                                         (string)MyReader["Preview"]);
        }

        #endregion
    }
}
