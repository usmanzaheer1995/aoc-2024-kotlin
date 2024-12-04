package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.math.abs

fun main() {
    var safeReportsInStep1 = 0
    var safeReportsInStep2 = 0
    Path("src/main/resources/day2_input.txt").forEachLine {
        val row = it.trim().split("\\s+".toRegex()).map(String::toInt)
        if (isSafeStep1(row)) {
            safeReportsInStep1++
        }
        if (isSafeStep2(row)) {
            safeReportsInStep2++
        }
    }
    println("safeReportsInStep1 = $safeReportsInStep1")
    println("safeReportsInStep2 = $safeReportsInStep2")
}

fun isSafeStep1(list: List<Int>): Boolean {
    val isIncreasing = list.zipWithNext().all { (left, right) -> left < right && abs(left - right) <= 3 }
    val isDecreasing = list.zipWithNext().all { (left, right) -> left > right && abs(left - right) <= 3 }

    return isIncreasing || isDecreasing
}

fun isSafeStep2(list: List<Int>): Boolean {
    if (isSafeStep1(list)) return true

    for (i in list.indices) {
        val newList = list.toMutableList()
        newList.removeAt(i)
        if (isSafeStep1(newList)) return true
    }

    return false
}
