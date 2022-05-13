package es.gdebustamante.inadraft.domain

data class PlayerBO(
    val id: Int,
    val name: String,
    val kick: Int,
    val body: Int,
    val control: Int,
    val guard: Int,
    val speed: Int,
    val stamina: Int, // Este valor como no voy a simular partidas no lo necesito realmente, pero el juego lo tiene, lo dejo para futuras actualizaciones
    val guts: Int,
    val photo: String,
    val teamId: Int,
    val positionId: Int
) {
    fun getMedia(): Int = (kick + body + control + speed + guts) / 6
}