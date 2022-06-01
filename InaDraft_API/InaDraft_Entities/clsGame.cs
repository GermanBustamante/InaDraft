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

        public string UserNick{ get; set; }
        
        public int Score{ get; set; }
        public DateTime Date { get; set; }
        public int FormationId { get; set; }
        #endregion

        #region constructores
        public clsGame(int id,string userNick, int score, DateTime date, int userId)
        {
            Id = id;
            UserNick = userNick;
            Score = score;
            Date = date;
            FormationId = userId;
        }

        public clsGame()
        {
        }
        #endregion
    }
}
