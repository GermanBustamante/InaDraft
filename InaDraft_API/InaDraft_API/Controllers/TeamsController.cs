using InaDraft_BL.Lists;
using InaDraft_Entities;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using HttpGetAttribute = Microsoft.AspNetCore.Mvc.HttpGetAttribute;
using RouteAttribute = Microsoft.AspNetCore.Mvc.RouteAttribute;
// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace InaDraft_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TeamsController : ControllerBase
    {
        /// <summary>
        /// <b>GET: api/*TeamsController*</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsTeam) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of teams and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of teams,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <returns>IEnumerable(clsTeam) list of teams or null</returns>
        [HttpGet]
        public IEnumerable<clsTeam> Get()
        {
            List<clsTeam> oTeamsList = new List<clsTeam>();
            try
            {
                oTeamsList = new clsTeamListBL().getTeamListBL();
            }
            catch (Exception)
            {
                throw;
            }
            return oTeamsList;
        }
    }
}
