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
        /// <summary>
        /// <b>GET: api/*GamesController*</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsGame) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of games and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of games order by puntuation,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <returns>IEnumerable(clsGame) list of games or null</returns>
        [HttpGet]
        public List<clsGame> Get()
        {
            List<clsGame> oGames = new();
            try
            {
                oGames = new clsGameListBL().getGameListOrderByPuntuationBL();
            }
            catch (Exception)
            {
                throw;
            }
            return oGames;
        }

        // POST api/<GamesController>
        /// <summary>
        /// <b>POST api/*GamesController*</b><br/>
        /// <b>Prototype:</b> public IActionResult Post([FromBody] clsGame oGame)<br/>
        /// <b>Commentaries:</b> Execute an API call with the POST verb, inserting an game in the DB and returning the StatusCode
        /// of the result of said insertion<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to insert a game in the DB, 
        /// if no error has occurred and the number of rows affected is not 0, it will return a StatusCode 200 Ok(), if no error has 
        /// occurred but the number of rows affected is 0, it will return a 404 NotFound(), and if an exception has occurred, it will 
        /// return a 400 BadRequest()
        /// </summary>
        /// <param name="oGame"></param>
        /// <returns>IActionResult depending on the result of the call</returns>
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
