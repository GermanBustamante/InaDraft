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
        // GET: api/<PlayersController>
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

        // GET api/<PlayersController>/5
        [HttpGet("{id}")]
        public clsPlayer Get(int id)
        {
            clsPlayer oPlayer = new clsPlayer();
            try
            {
                oPlayer = new clsPlayerListBL().getPlayerBL(id);
            }catch (Exception)
            {
                throw;
            }
            return oPlayer;
        }
    }
}
