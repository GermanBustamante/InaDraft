package es.gdebustamante.inadraft.domain

import java.time.LocalDate

data class GameBO(
    val id: Int,
    val score: Int,
    val date: LocalDate,
    val userNick: String,
    val formation: FormationBO,
)