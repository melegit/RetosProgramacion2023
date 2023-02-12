package reto6

/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */

fun main() {
   var counterPlayer1 = 0
   var counterPlayer2 = 0

    val sequence: List<Pair<String, String>> = listOf(
        ("🗿" to "✂️"),
        ("✂️" to "🗿"),
        ("📄" to "✂️"),
        ("✂️" to "📄"),
        ("✂️" to "📄"),
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
        "🗿" to "✂️" -> { PlayerType.PLAYER1 }
        "🗿" to "📄" -> { PlayerType.PLAYER2 }
        "🗿" to "🦎" -> { PlayerType.PLAYER1 }
        "🗿" to "🖖" -> { PlayerType.PLAYER2 }

        "✂️" to "🗿" -> { PlayerType.PLAYER2 }
        "✂️" to "📄" -> { PlayerType.PLAYER1 }
        "✂️" to "🦎" -> { PlayerType.PLAYER1 }
        "✂️" to "🖖" -> { PlayerType.PLAYER2 }

        "📄" to "✂️" -> { PlayerType.PLAYER2 }
        "📄" to "🗿" -> { PlayerType.PLAYER1 }
        "📄" to "🦎" -> { PlayerType.PLAYER2 }
        "📄" to "🖖" -> { PlayerType.PLAYER1 }

        "🦎" to "✂️" -> { PlayerType.PLAYER2 }
        "🦎" to "📄" -> { PlayerType.PLAYER1 }
        "🦎" to "🗿" -> { PlayerType.PLAYER2 }
        "🦎" to "🖖" -> { PlayerType.PLAYER1 }

        "🖖" to "✂️" -> { PlayerType.PLAYER1 }
        "🖖" to "📄" -> { PlayerType.PLAYER2 }
        "🖖" to "🦎" -> { PlayerType.PLAYER2 }
        "🖖" to "🗿" -> { PlayerType.PLAYER1 }

        else -> { null }
    }
}

enum class PlayerType(val playerName: String) {
    PLAYER1(playerName = "Player 1"),
    PLAYER2(playerName = "Player 2"),
}