package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.math.abs

fun main() {
    var safeReports = 0
    Path("src/main/resources/day2_input.txt").forEachLine {
        val row = it.trim().split("\\s+".toRegex()).map(String::toInt)
        if (isSafeStep1(row)) {
            safeReports++
        }
    }
    println("safeReports = $safeReports")
}

fun isSafeStep1(list: List<Int>): Boolean {
    val isIncreasing = list.zipWithNext().all { (left, right) -> left < right && abs(left - right) <= 3 }
    val isDecreasing = list.zipWithNext().all { (left, right) -> left > right && abs(left - right) <= 3 }

    return isIncreasing || isDecreasing
}
