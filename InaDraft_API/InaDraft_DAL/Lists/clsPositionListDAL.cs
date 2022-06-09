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
        /// <summary>
        /// <b>Prototype:</b> public List(clsPosition) getPositionListDAL()<br/>
        /// <b>Commentaries:</b>Returns a list of positions from the DB<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with positions from the Positions DB table
        /// </summary>
        /// <returns> List(clsPosition) representing the list of positions from the DB</returns>
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
        /// <summary>
        /// Build a clsPosition from MyReader and return it
        /// </summary>
        /// <returns></returns>
        private clsPosition rebuildPosition()
        {
            return new clsPosition((int)MyReader["Id"],
                                         (string)MyReader["Name"]);
        }

        #endregion
    }
}
