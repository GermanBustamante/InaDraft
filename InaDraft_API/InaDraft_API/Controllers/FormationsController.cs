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
    public class FormationsController : ControllerBase
    {
        
        /// <summary>
        /// <b>GET: api/*FormationsController*</b><br/>
        /// <b>Prototype:</b> public IEnumerable(clsFormation) Get()<br/>
        /// <b>Commentaries:</b> Execute an API call with the GET verb, asking for a list of formations and 
        /// returning it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> It makes a call to its corresponding method in the DB to collect a list of formations,
        /// if an error occurs during the execution, it throws a Exception and the return null
        /// </summary>
        /// <returns>IEnumerable(clsFormation) list of formations or null</returns>
        [HttpGet]
        public List<clsFormation> Get()
        {
            List<clsFormation> oPlayers = new();
            try
            {
                oPlayers = new clsFormationListBL().getFormationListBL();
            }
            catch (Exception)
            {
                throw;
            }
            return oPlayers;
        }
    }
}
