package es.gdebustamante.inadraft.domain

data class PositionBO(
    val id: Int,
    val name: String,
){

    fun getFullName() = when(name){
        "GK" -> "Portero"
        "DF" -> "Defensa"
        "MF" -> "Mediocentro"
        "FW" -> "Delantero"
        else -> "Undefined"
    }

}