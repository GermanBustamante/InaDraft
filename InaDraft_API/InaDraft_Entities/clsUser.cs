using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_Entities
{
    public class clsUser
    {
        #region propiedades publicas
        public int Id{ get; set; }
        public int Nick { get; set; }
        public int Name { get; set; }
        public int Surname { get; set; }
        public int Email { get; set; }
        public int Password { get; set; }
        #endregion

        #region constructores
        public clsUser()
        {
        }

        public clsUser(int id, int nick, int name, int surname, int email, int password)
        {
            Id = id;
            Nick = nick;
            Name = name;
            Surname = surname;
            Email = email;
            Password = password;
        }
        #endregion
    }
}
