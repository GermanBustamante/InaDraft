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
/*
        public clsFormation getPlayerDAL(int id)
        {
            clsFormation oFormation = new();
            openConection();
            MyReader = executeSelectCondition(QUERY_FORMATION_BY_ID, id);
            if (MyReader.HasRows)
            {
                oFormation = buildFormation();
            }
            closeFlow();
            return oFormation;
        }
*/
        #endregion

        #region metodos privados 

        private clsFormation buildFormation()
        {
            return new clsFormation((int)MyReader["Id"],
                                         (string)MyReader["Name"],
                                         (string)MyReader["Preview"]);
        }

        #endregion
    }
}
