using System;

namespace InaDraft_Entities
{
    public class clsTeam
    {
        #region propiedades publicas
        public int Id { get; set; } 
        public string Name { get; set; }
        public string Photo { get; set; }
        #endregion

        #region constructores 
        public clsTeam()
        {
        }

        public clsTeam(int id, string name, string photo)
        {
            Id = id;
            Name = name;
            Photo = photo;
        }
        #endregion
    }
}
