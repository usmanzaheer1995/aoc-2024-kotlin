package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.math.abs

fun main() {
    var safeReports = 0
    Path("src/main/resources/day2_input.txt").forEachLine {
        val row = it.trim().split("\\s+".toRegex()).map(String::toInt)
        if (isSafe(row)) {
            safeReports++
        }
    }
    println("safeReports = $safeReports")
}

fun isSafe(list: List<Int>): Boolean {
    // if difference greater than 3, not safe report
    if (abs(list[0] - list[1]) > 3) return false

    var increasing = false
    var decreasing = false

    if (list[0] < list[1]) increasing = true else decreasing = true

    for (i in 1 until list.size - 1) {
        if (list[i] > list[i + 1] && increasing == true) return false

        if (list[i] < list[i + 1] && decreasing == true) return false

        if (abs(list[i] - list[i + 1]) < 1 || abs(list[i] - list[i + 1]) > 3) return false
    }
    return true
}

fun isValid(line: List<Int>): Boolean {
    val isIncreasing = line.zipWithNext().all { (left, right) -> left < right && abs(left - right) <= 3 }
    val isDecreasing = line.zipWithNext().all { (left, right) -> left > right && abs(left - right) <= 3 }

    return isIncreasing || isDecreasing
}

fun step1(): Int {
    var safeReports = 0
    Path("src/main/resources/day2_input.txt").forEachLine {
        val row = it.trim().split("\\s+".toRegex()).map(String::toInt)
        if (isValid(row)) {
            safeReports++
        }
    }
    return safeReports
}
