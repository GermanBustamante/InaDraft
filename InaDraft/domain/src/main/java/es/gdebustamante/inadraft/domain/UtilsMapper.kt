package es.gdebustamante.inadraft.domain

fun PlayerBO.combine(team : TeamBO, position : PositionBO) = PlayerBO(
    id,
    name,
    kick,
    body,
    control,
    guard,
    speed,
    stamina,
    guts,
    photo,
    team,
    position
)

fun GameBO.combineWithFormation(formation: FormationBO) = GameBO(
    id,
    score,
    date,
    userNick,
    formation
)