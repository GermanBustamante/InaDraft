using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsPlayerListBL
    {
        public List<clsPlayer> getPlayerListBL()
        {
            return new clsPlayerListDAL().getPlayerListDAL();
        }

        public clsPlayer getPlayerBL(int id)
        {
            return new clsPlayerListDAL().getPlayerDAL(id);
        }

        public List<clsPlayer> getPlayerListFromTeamBL(int monumentId)
        {
            return new clsPlayerListDAL().getPlayerListFromTeamDAL(monumentId);
        }
    }
}
