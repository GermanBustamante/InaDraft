using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsFormationListBL
    {
        /// <summary>
        /// <b>Prototype:</b> public List(clsFormation) getFormationListBL()<br/>
        /// <b>Commentaries:</b>Returns a list of formations from the DAL<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Returns a list with all the formations from the Formations table
        /// </summary>
        /// <returns> List(clsFormation) formations representing the list of formations from the DAL</returns>
        public List<clsFormation> getFormationListBL()
        {
            return new clsFormationListDAL().getFormationListDAL();
        }
    }
}
