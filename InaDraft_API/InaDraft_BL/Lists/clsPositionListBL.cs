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
        
        public List<clsPosition> getPositionListBL()
        {
            return new clsPositionListDAL().getPositionListDAL();
        }

    }
}
