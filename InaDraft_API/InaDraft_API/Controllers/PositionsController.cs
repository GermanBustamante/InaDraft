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
    public class PositionsController : ControllerBase
    {
        /// <summary>
        /// <b>GET: api/*PositionsController*</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsPosition) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of positions and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of positions,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <returns>IEnumerable(clsPosition) list of positions or null</returns>
        [HttpGet]
        public List<clsPosition> Get()
        {
            List<clsPosition> oPositions = new();
            try
            {
                oPositions = new clsPositionListBL().getPositionListBL();
            }
            catch (Exception)
            {
                throw;
            }
            return oPositions;
        }
    }
}
