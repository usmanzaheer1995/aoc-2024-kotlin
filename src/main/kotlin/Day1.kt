package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.math.abs

fun main() {
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    Path("src/main/resources/day1_input.txt").forEachLine {
        val (one, two) = it.trim().split("\\s+".toRegex())
        leftList.add(one.toInt())
        rightList.add(two.toInt())
    }

    val distance = partOne(leftList, rightList)
    val similarityScore = partTwo(leftList, rightList)

    println("distance: $distance, similarity score: $similarityScore")
}

fun partOne(leftList: List<Int>, rightList: List<Int>) = totalDistance(leftList, rightList)
fun partTwo(leftList: List<Int>, rightList: List<Int>) = similarityScore(leftList, rightList)

fun totalDistance(leftList: List<Int>, rightList: List<Int>): Int {
    val leftCopy = leftList.toMutableList()
    val rightCopy = rightList.toMutableList()
    val distanceList = mutableListOf<Int>()

    while (leftCopy.isNotEmpty() && rightCopy.isNotEmpty()) {
        // get min from leftList and remove it
        val leftMin = leftCopy.min()
        leftCopy.remove(leftMin)

        // get min from rightList and remove it
        val rightMin = rightCopy.min()
        rightCopy.remove(rightMin)

        val distance = abs(leftMin - rightMin)

        distanceList.add(distance)
    }

    return distanceList.sum()
}

fun similarityScore(leftList: List<Int>, rightList: List<Int>): Int {
    val similarityList = mutableListOf<Int>()
    leftList.forEach { item ->
        val count = rightList.count { item == it }
        similarityList.add(item * count)
    }

    return similarityList.sum()
}
