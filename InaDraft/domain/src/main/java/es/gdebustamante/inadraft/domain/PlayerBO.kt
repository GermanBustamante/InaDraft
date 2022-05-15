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
    fun getMedia(): Int {
        return (when (positionId) {
            1 -> kick * 0.22 + (guts + speed + control) * 0.18 + stamina * 0.14 + (body + guard) * 0.10
            2 -> control * 0.22 + (body + stamina + guts + kick + speed) * 0.14 + kick * 0.08
            3 -> guard * 0.22 + body * 0.2 + (control + stamina) * 0.14 + speed * 0.12 + guts * 0.1 + kick * 0.8
            4 -> guard * 0.22 + (control + guts + body) * 0.16 + (kick + speed + stamina) * 0.1
            else -> 0.0
        }).toInt()
    }
}

/*
Sistema de puntuaje Total 100
Delantero ---> Kick 22% - Guts, Speed ,Control 18% - Stamina 14% - Body, Guard 10%
Mediocentro ---> Control 22% - Body, Stamina, Guts, Kick, Speed 14 - Kick 8%
Defensa ---> Guard 22% - Body 20% - Control, Stamina 14% - Speed 12% - Guts 10% - Kick 8%
Portero ---> Guard 22% - Control, Guts, Body 16% - Kick, Speed, Stamina 10%

 */