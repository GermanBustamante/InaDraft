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
        // GET: api/<FormationsController>
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
