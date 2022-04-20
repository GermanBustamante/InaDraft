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
        // GET: api/<TeamsController>
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

        // GET api/<TeamsController>/5
        [HttpGet("{id}")]
        public clsTeam Get(int id)
        {
            clsTeam oTeam = new();
            try
            {
                oTeam = new clsTeamListBL().getTeamBL(id);
            }
            catch (Exception)
            {
                throw;
            }
            return oTeam;
        }
    }
}
