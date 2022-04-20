using System;
using System.Data.SqlClient;

namespace InaDraft_DAL.Utilities
{
    /// <summary>
    /// This class will have all the properties and methods that we will be using in a class that executes SELECT instructions
    /// </summary>
    public abstract class clsUtilitySelectDAL : clsUtilityBaseDAL
    {
        //NOTE: The methods in this class don't manage any SqlException as the raises it so the method that calls it handle them 
        #region public properties
        public SqlDataReader MyReader { get; set; }
        #endregion

        #region constants
        public const string ID_PARAMETER = "@id";
        #endregion

        #region public methods
        /// <summary>
        /// <b>Prototype:</b> public SqlDataReader executeSelectCondition(String selectInstruction, int condition)<br/>
        /// <b>Commentaries:</b> Executes a Select instruction with a condition, it will be defined by the PK<br/>
        /// <b>Preconditions:</b> the primary key musst be named by ID on the database<br/>
        /// <b>Postconditions:</b> Given the inherited properties, a Select instruction and a condition, executes a Slect instruction with a condition parameter,
        /// returning the appropiate result
        /// </summary>
        /// <param name="selectInstruction"></param>
        /// <param name="condition"></param>
        /// <returns> SqlDataReader with the result of the instruction</returns>
        public SqlDataReader executeSelectCondition(String selectInstruction, int condition)
        {
            MyCommand.Parameters.Add(ID_PARAMETER, System.Data.SqlDbType.Int).Value = condition;
            MyCommand.Connection = MyConnection.Conexion;
            MyCommand.CommandText = selectInstruction;
            return MyCommand.ExecuteReader();
        }

        /// <summary>
        /// <b>Prototype:</b> public SqlDataReader executeSelectCondition(String selectInstruction, String condition)<br/>
        /// <b>Commentaries:</b> Executes a Select instruction with a condition, usually it will be the PK<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Given the inherited properties, a Select instruction and a condition, executes a Select instruction with a condition parameter,
        /// returning the appropiate result 
        /// </summary>
        /// <param name="selectInstruction"></param>
        /// <param name="condition"></param>
        /// <returns> SqlDataReader with the result of the instruction</returns>
        public SqlDataReader executeSelectCondition(String selectInstruction, String condition)
        {
            MyCommand.Parameters.Add(ID_PARAMETER, System.Data.SqlDbType.VarChar).Value = condition;
            MyCommand.Connection = MyConnection.Conexion;
            MyCommand.CommandText = selectInstruction + ID_PARAMETER;
            return MyCommand.ExecuteReader();
        }

        /// <summary>
        /// <b>Prototype:</b> public SqlDataReader executeSelect(String selectInstruction)<br/>
        /// <b>Commentaries:</b> Executes a Select instructions and returns it<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Given the inherited properties and a Select instruction executes it, then,
        /// returns the appropiate result
        /// </summary>
        /// <param name="selectInstruction"></param>
        /// <returns> SSqlDataReader with the result of the instruction</returns>
        public SqlDataReader executeSelect(String selectInstruction)
        {
            MyCommand.CommandText = selectInstruction;
            MyCommand.Connection = MyConnection.Conexion;
            return MyCommand.ExecuteReader();
        }

        /// <summary>
        /// <b>Prototype:</b> public void closeFlow()<br/>
        /// <b>Commentaries:</b> Closes all the conection flows from this class and the inherited ones<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions: </b> Closes the conection flow from the object type MyConection and the type MyReader
        /// </summary>
        public void closeFlow()
        {
            MyConnection.closeConnection();
            MyReader.Close();
        }
        #endregion
    }
}
