package mazerunner

import kotlin.random.Random

const val ROWS : Int = 10
const val COLS : Int = 10

fun checkBlock( maze2D : Array<Array<Int>> ) : Array<Array<Int>> {
    for (i in 2..<ROWS - 2) {
        for (j in 2..<COLS - 2) {
            if (Random.nextInt(1, 9) == 5) {
                maze2D[i][j] = 1
            }
        }
    }
    return maze2D
}

fun createMaze() : Array<Array<Int>> {
    val maze2D : Array<Array<Int>>  = Array(ROWS) { Array(10) {1} }
    for (i in 0..<ROWS) {
        if (i == 0 || i == ROWS - 1) {
            continue
        } else {
            for (j in 0..<COLS) {
                if (j == 0 || j == COLS - 1)
                    continue
                else
                    maze2D[i][j] = 0
            }
        }
    }
    // Add entry and exit
    maze2D[3][0] = 0
    maze2D[8][COLS - 1] = 0
    return checkBlock(maze2D)
}

fun displayMaze( maze2D : Array<Array<Int>>) {
    for (i in 0..<ROWS) {
        for (j in 0..<COLS) {
            when (maze2D[i][j]) {
                1 -> print("\u2588\u2588")
                else -> print("  ")
            }
        }
        print("\n")
    }
}

fun main() {
    displayMaze(createMaze())
}
