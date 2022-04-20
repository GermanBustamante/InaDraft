using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsGame
    {
        #region propiedades publicas
        public int Id{ get; set; }
        public Double Score{ get; set; }
        public DateTime Date { get; set; }
        public int UserId { get; set; }
        #endregion

        #region constructores
        public clsGame(int id, double score, DateTime date, int userId)
        {
            Id = id;
            Score = score;
            Date = date;
            UserId = userId;
        }

        public clsGame()
        {
        }
        #endregion
    }
}
