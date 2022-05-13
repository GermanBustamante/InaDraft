using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsPlayer
    {
        #region propiedades publicas
        public int Id { get; set; }
        public string Name { get; set; }
        public int Kick { get; set; }
        public int Body { get; set; }
        public int Control { get; set; }
        public int Guard { get; set; }
        public int Speed { get; set; }
        public int Stamina { get; set; }
        public int Guts { get; set; }
        public string  Photo { get; set; }
        public int TeamId { get; set; }
        public int PositionId { get; set; }
        #region constructores

        #endregion
        public clsPlayer(int id, string name, int kick, int body, int control, int guard, int speed, int stamina, int guts, string photo, int teamId, int positionId)
        {
            Id = id;
            Name = name;
            Kick = kick;
            Body = body;
            Control = control;
            Guard = guard;
            Speed = speed;
            Stamina = stamina;
            Guts = guts;
            Photo = photo;
            TeamId = teamId;
            PositionId = positionId;
        }

        public clsPlayer()
        {
        }
        #endregion
    }
}
