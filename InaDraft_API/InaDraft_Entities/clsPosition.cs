using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsPosition
    {
        #region propiedades publicas
        public int Id{ get; set; }
        public string Name { get; set; }
        #endregion

        #region constructores
        public clsPosition(int id, string name)
        {
            Id = id;
            Name = name;
        }

        public clsPosition() { }
        #endregion
    }
}
