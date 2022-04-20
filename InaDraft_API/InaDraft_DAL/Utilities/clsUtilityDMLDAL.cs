using System;

namespace InaDraft_DAL.Utilities
{
    /// <summary>
    /// Contains all the attributes and methos that are ALWAYS used in the classes that execute DML sentences, Insert, Update, Delete...
    /// </summary>
    public abstract class clsUtilityDMLDAL : clsUtilityBaseDAL
    {
        //NOT: This class methods don't catch any SqlException as they raise it so the method that calls it handle them

        #region public methods
        /// <summary>
        /// <b>Prototype:</b> public int executeDMLSentence(String dmlSentence)<br/>
        /// <b>Comments:</b> Executes a DML sentence<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Through the inherited properties and a DML sentence, executes said sentence, returning
        /// the number of affected rows
        /// </summary>
        /// <param name="dmlSentence"></param>
        /// <returns> int depicting the number of affected rows by said DML sentence</returns>
        public int executeDMLSentence(String dmlSentence)
        {
            MyCommand.CommandText = dmlSentence;
            MyCommand.Connection = MyConnection.Conexion;
            return MyCommand.ExecuteNonQuery();
        }

        /// <summary>
        /// <b>Prototype:</b> public int executeDMLSentenceCondition(String dmlSentence, int condition)<br/>
        /// <b>Comments:</b> Executes a DML sentence with a condition, being usually a PK<br/>
        /// <b>Preconditions:</b> none<br/>
        /// <b>Postconditions:</b> Through the inherited properties and a DML sentence sql with a condition,
        /// adds said parameter and executes said complete DML,finally, returns the number of affected rows
        /// </summary>
        /// <param name="dmlSentence"></param>
        /// <param name="condition"></param>
        /// <returns> int depicting the number of affected rows by said DML sentence</returns>
        public int executeDMLSentenceCondition(String dmlSentence, int condition)
        {
            MyCommand.Parameters.Add("@param", System.Data.SqlDbType.Int).Value = condition;
            MyCommand.CommandText = dmlSentence;
            MyCommand.Connection = MyConnection.Conexion;
            return MyCommand.ExecuteNonQuery();
        }

        /// /// <summary>
        /// <b>Prototype:</b> public int executeStoredProcedure(String procedure)<br/>
        /// <b>Comments:</b> Executes a stored procedure<br/>
        /// <b>Preconditions:</b> if the SP has variabñes, those must ahad to be already  instanced in MyCommand<br/>
        /// <b>Postconditions:</b> Through the inherited properties and a DML sentence and a procedure passed as parameter
        /// executes said SP, finally, returns the number of affected rows
        /// </summary>
        /// <param name="procedure"></param>
        /// <returns> int depicting the number of affected rows by said DML sentence</returns>
        public int executeStoredProcedure(String procedure)
        {
            MyCommand.CommandType = System.Data.CommandType.StoredProcedure;
            MyCommand.CommandText = procedure;
            MyCommand.Connection = MyConnection.Conexion;
            return MyCommand.ExecuteNonQuery();

        }
        #endregion
    }
}
