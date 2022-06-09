package es.gdebustamante.inadraft.domain

import java.util.Date

data class GameBO(
    val id: Int = 0,
    val score: Int,
    val date: Date,
    val userNick: String,
    val formation: FormationBO,
)