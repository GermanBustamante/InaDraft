using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsPlayerGame
    {
        #region propiedades publicas
        public clsPlayer Player{ get; set; }
        public clsGame Game { get; set; }
        #endregion

        #region constructores
        public clsPlayerGame(clsPlayer player, clsGame game)
        {
            Player = player;
            Game = game;
        }

        public clsPlayerGame()
        {
        }
        #endregion
    }
}
