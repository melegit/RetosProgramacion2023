package reto6

/*
 * Crea un programa que calcule quien gana mΓ‘s partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La funciΓ³n recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "πΏ" (piedra), "π" (papel),
 *   "βοΈ" (tijera), "π¦" (lagarto) o "π" (spock).
 * - Ejemplo. Entrada: [("πΏ","βοΈ"), ("βοΈ","πΏ"), ("π","βοΈ")]. Resultado: "Player 2".
 * - Debes buscar informaciΓ³n sobre cΓ³mo se juega con estas 5 posibilidades.
 */

fun main() {
   var counterPlayer1 = 0
   var counterPlayer2 = 0

    val sequence: List<Pair<String, String>> = listOf(
        ("πΏ" to "βοΈ"),
        ("βοΈ" to "πΏ"),
        ("π" to "βοΈ"),
        ("βοΈ" to "π"),
        ("βοΈ" to "π"),
    )

    sequence.forEach {
        whatWinAction(it)?.let { playerWin ->
            when(playerWin) {
                PlayerType.PLAYER1 -> counterPlayer1++
                PlayerType.PLAYER2 -> counterPlayer2++
            }
        }?: run {
            println("Jugada incorrecta")
        }
    }

    when{
        counterPlayer1 == counterPlayer2 -> println("Tie")
        counterPlayer1 > counterPlayer2 -> println(PlayerType.PLAYER1.playerName)
        counterPlayer1 < counterPlayer2 ->  println(PlayerType.PLAYER2.playerName)
    }
}

fun whatWinAction(action: Pair<String,String>) : PlayerType? {
    return when(action){
        "πΏ" to "βοΈ" -> { PlayerType.PLAYER1 }
        "πΏ" to "π" -> { PlayerType.PLAYER2 }
        "πΏ" to "π¦" -> { PlayerType.PLAYER1 }
        "πΏ" to "π" -> { PlayerType.PLAYER2 }

        "βοΈ" to "πΏ" -> { PlayerType.PLAYER2 }
        "βοΈ" to "π" -> { PlayerType.PLAYER1 }
        "βοΈ" to "π¦" -> { PlayerType.PLAYER1 }
        "βοΈ" to "π" -> { PlayerType.PLAYER2 }

        "π" to "βοΈ" -> { PlayerType.PLAYER2 }
        "π" to "πΏ" -> { PlayerType.PLAYER1 }
        "π" to "π¦" -> { PlayerType.PLAYER2 }
        "π" to "π" -> { PlayerType.PLAYER1 }

        "π¦" to "βοΈ" -> { PlayerType.PLAYER2 }
        "π¦" to "π" -> { PlayerType.PLAYER1 }
        "π¦" to "πΏ" -> { PlayerType.PLAYER2 }
        "π¦" to "π" -> { PlayerType.PLAYER1 }

        "π" to "βοΈ" -> { PlayerType.PLAYER1 }
        "π" to "π" -> { PlayerType.PLAYER2 }
        "π" to "π¦" -> { PlayerType.PLAYER2 }
        "π" to "πΏ" -> { PlayerType.PLAYER1 }

        else -> { null }
    }
}

enum class PlayerType(val playerName: String) {
    PLAYER1(playerName = "Player 1"),
    PLAYER2(playerName = "Player 2"),
}