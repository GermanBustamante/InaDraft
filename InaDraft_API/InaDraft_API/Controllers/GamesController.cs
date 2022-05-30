using InaDraft_BL.Handerls;
using InaDraft_BL.Lists;
using InaDraft_Entities;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace InaDraft_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GamesController : ControllerBase
    {
        // GET: api/<GamesController>
        [HttpGet]
        public List<clsGame> Get()
        {
            List<clsGame> oGames = new();
            try
            {
                oGames = new clsGameListBL().getGameListBL();
            }
            catch (Exception)
            {
                throw;
            }
            return oGames;
        }

        // POST api/<GamesController>
        [HttpPost]
        public IActionResult Post([FromBody] clsGame oGame)
        {
            int rowsAffected = 0;
            IActionResult result;
            try
            {
                rowsAffected = new clsGameHandlerBL().insertGameBL(oGame);
                if (rowsAffected == 0)
                {
                    result = NotFound("NotFound");
                }
                else
                {
                    result = Ok(rowsAffected);
                }
            }
            catch (Exception)
            {
                result = BadRequest("BadRequest");
            }
            return result;
        }
    }
}
