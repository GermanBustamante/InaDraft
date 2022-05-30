using InaDraft_DAL.Handlers;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_BL.Handerls
{
    public class clsGameHandlerBL
    {

        public int insertGameBL(clsGame oGame)
        {
            return new clsGameHandlerDAL().insertGameDAL(oGame);
        }

    }
}
