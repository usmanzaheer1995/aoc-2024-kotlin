package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.math.abs

fun main() {
    var safeReports = 0
    Path("src/main/resources/day2_input.txt").forEachLine {
        val row = it.trim().split("\\s+".toRegex()).map(String::toInt)
        if (isSafe(row)) {
            println(row)
            safeReports++
        }
    }
    println("safeReports = $safeReports")
}

fun isSafe(list: List<Int>): Boolean {
    // if difference greater than 3, not safe report
    if (list[0] == list[1] || abs(list[0] - list[1]) > 3) return false

    var increasing = false
    var decreasing = false

    if (list[0] < list[1]) increasing = true else decreasing = true

    for (i in 1 until list.size - 1) {
        if (list[i] > list[i + 1] && increasing) return false

        if (list[i] < list[i + 1] && decreasing) return false

        if (abs(list[i] - list[i + 1]) < 1 || abs(list[i] - list[i + 1]) > 3) return false
    }
    return true
}
