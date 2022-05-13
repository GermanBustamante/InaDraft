using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_DAL.Lists
{
    public class clsPositionListDAL : clsUtilitySelectDAL
    {
        #region constantes
        public const string QUERY_ALL_POSITIONS = "SELECT * FROM Positions";
        #endregion

        #region metodos publicos
        public List<clsPosition> getPositionListDAL()
        {
            clsPosition oPosition;
            List<clsPosition> positionList = new();
            openConection();
            MyReader = executeSelect(QUERY_ALL_POSITIONS);
            if (MyReader.HasRows)
            {
                while (MyReader.Read())
                {
                    oPosition = rebuildPosition();
                    positionList.Add(oPosition);
                }
            }
            closeFlow();
            return positionList;
        }


        #endregion

        #region metodos privados
        private clsPosition rebuildPosition()
        {
            return new clsPosition((int)MyReader["Id"],
                                         (string)MyReader["Name"]);
        }

        #endregion
    }
}
