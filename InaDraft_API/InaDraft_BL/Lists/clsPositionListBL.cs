using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsPositionListBL
    {

        /// <summary>
        /// <b>Prototype:</b> public List(clsPosition) getPositionListBL()<br/>
        /// <b>Commentaries:</b>Returns a list of positions from the DAL<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with all the positions from the positions table
        /// </summary>
        /// <returns> List(clsPosition) positions representing the list of positions from the DAL</returns>
        public List<clsPosition> getPositionListBL()
        {
            return new clsPositionListDAL().getPositionListDAL();
        }

    }
}
