using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsFormation
    {
        #region propiedades publicas
        public int Id { get; set; }
        public string Name { get; set; }

        public string Photo{ get; set; }

        #endregion

        #region constructores
        public clsFormation(int id, string name, string photo)
        {
            Id = id;
            Name = name;
            Photo = photo;
        }

        public clsFormation()
        {
        }

        #endregion
    }
}
