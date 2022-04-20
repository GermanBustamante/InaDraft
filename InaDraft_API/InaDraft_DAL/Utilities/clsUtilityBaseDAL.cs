using InaDraft_DAL.Connection;
using System.Data.SqlClient;

namespace InaDraft_DAL.Utilities
{
    /// <summary>
    /// Has all the attributes and methods that are used when we are working with data from the DAL layer,
    /// like the conection, the command and opening that conection
    /// </summary>
    public abstract class clsUtilityBaseDAL
    {
        #region public properties
        public clsMyConnection MyConnection { get; set; }
        public SqlCommand MyCommand { get; set; }
        #endregion
        #region public methods
        /// <summary>
        /// <b>Prototype:</b> public void openConection()<br/>
        /// <b>Commentaries:</b> Method for opening a conection to a DB<br/>
        /// <b>Preconditions:</b> None<br/>
        /// <b>Postconditions:</b> The attributes from MyConnection and MyCommand are instantiated, then, it opens a connection to the DB saved in the attributes
        /// from the object MyConnection
        /// </summary>
        public void openConection()
        {
            MyConnection = new clsMyConnection();
            MyCommand = new SqlCommand();
            MyConnection.getConnection();
        }
        #endregion
    }
}
