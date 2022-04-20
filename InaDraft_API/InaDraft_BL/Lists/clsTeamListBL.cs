using InaDraft_DAL.Lists;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Lists
{
    public class clsTeamListBL
    {
        public List<clsTeam> getTeamListBL()
        {
            return new clsTeamListDAL().getTeamListDAL();
        }

        public clsTeam getTeamBL(int id)
        {
            return new clsTeamListDAL().getTeamDAL(id);
        }
    }
}
