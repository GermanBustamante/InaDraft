using InaDraft_DAL.Utilities;
using InaDraft_Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaDraft_DAL.Handlers
{
    public class clsGameHandlerDAL: clsUtilityDMLDAL
    {
        #region constants
        public const String INSERT_INSTRUCTION_GAME = "INSERT INTO Games VALUES (@Date, @Score, @FormationId, @UserNick)";
        #endregion

        #region public methods
        /// <summary>
        /// <b>Prototype:</b> public int insertGameDAL(clsGame oGame)<br/>
        /// <b>Commentaries:</b>Connects to the DB to add a game in table Games<br/>
        /// <b>Preconditions:</b> game is valid<br/>
        /// <b>Postconditions:</b> Returns int indicating how many rows were changed (added)
        /// </summary>
        /// <param name="oGame">clsGame</param>
        /// <returns>int rowsChanged</returns>
        public int insertGameDAL(clsGame oGame)
        {
            openConection();
            createCommand(oGame);
            int result = executeDMLSentence(INSERT_INSTRUCTION_GAME);
            MyConnection.closeConnection();
            return result;


        }
        #endregion

        #region private methods
        /// <summary>
        /// <b>Prototype:</b> private void createCommand(clsGame game) <br/>
        /// <b>Commentaries:</b>Create a command with clsGame atributes<br/>
        /// <b>Preconditions:</b> game not null<br/>
        /// <b>Postconditions:</b> Add Parameters to MyCommand to add a game successfully
        /// </summary>
        /// <param name="game"></param>
        private void createCommand(clsGame game)
        {
            MyCommand.Parameters.Add("@Date", System.Data.SqlDbType.Date).Value = game.Date;
            MyCommand.Parameters.Add("@Score", System.Data.SqlDbType.Int).Value = game.Score;
            MyCommand.Parameters.Add("@FormationId", System.Data.SqlDbType.Int).Value = game.FormationId;
            MyCommand.Parameters.Add("@UserNick", System.Data.SqlDbType.NVarChar).Value = game.UserNick;
        }
        #endregion


    }
}
