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
    public class PlayersController : ControllerBase
    {
        /// <summary>
        /// <b>GET: api/*PlayersController*</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsPlayer) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of players and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of players,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <returns>IEnumerable(clsPlayer) list of players or null</returns>
        [HttpGet]
        public IEnumerable<clsPlayer> Get()
        {
            List<clsPlayer> oPlayersList = new List<clsPlayer>();
            try{
                oPlayersList = new clsPlayerListBL().getPlayerListBL();
            }catch (Exception)
            {
                throw;
            }
            return oPlayersList;
        }

        /// <summary>
        /// <b>GET: api/*PlayersController*/team/5</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsPlayer) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of players of a team and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of players of a team,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <param name="id">teamId</param>
        /// <returns>IEnumerable(clsPlayer) list of players or null</returns>
        [HttpGet("team/{id}")]
        public IEnumerable<clsPlayer> GetPlayerFromTeam(int id)
        {
            List<clsPlayer> oPlayersList = new List<clsPlayer>();
            try
            {
                oPlayersList = new clsPlayerListBL().getPlayerListFromTeamBL(id);
            }
            catch (Exception)
            {
                throw;
            }
            return oPlayersList;
        }
    }
}
