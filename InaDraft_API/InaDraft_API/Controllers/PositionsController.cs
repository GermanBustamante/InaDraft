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
        // GET: api/<PositionsController>
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
