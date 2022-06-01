﻿using InaDraft_DAL.Utilities;
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
