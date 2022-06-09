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

        /// <summary>
        /// <b>Prototype:</b> public int insertGameBL(clsGame game)<br/>
        /// <b>Commentaries:</b>Applies the business logic to add an game calling DAL method<br/>
        /// <b>Preconditions:</b> game is valid<br/>
        /// <b>Postconditions:</b> Calls the corresponding method of the DAL layer and returns the number of affected rows
        /// </summary>
        /// <param name="oGame">clsGame</param>
        /// <returns>int rowsChanged indicating how many rows were changed (added)</returns>
        public int insertGameBL(clsGame oGame)
        {
            return new clsGameHandlerDAL().insertGameDAL(oGame);
        }

    }
}
