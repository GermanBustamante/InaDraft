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
        public string Position { get; set; }
        public int Kick { get; set; }
        public int Body { get; set; }
        public int Control { get; set; }
        public int Guard { get; set; }
        public int Speed { get; set; }
        public int Stamina { get; set; }
        public int Guts { get; set; }
        public string  Photo { get; set; }
        public int IdTeam { get; set; }
        #endregion
        #region constructores
        public clsPlayer(int id, string name, string position, int kick, int body, int control, int guard, int speed, int stamina, int guts, string photo, int idTeam)
        {
            Id = id;
            Name = name;
            Position = position;
            Kick = kick;
            Body = body;
            Control = control;
            Guard = guard;
            Speed = speed;
            Stamina = stamina;
            Guts = guts;
            Photo = photo;
            IdTeam = idTeam;
        }

        public clsPlayer()
        {
        }
        #endregion
    }
}
