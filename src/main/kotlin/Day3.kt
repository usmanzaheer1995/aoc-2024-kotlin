package org.usmanzaheer1995

import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val regex = Regex("""mul\(([1-9]\d{0,2}),([1-9]\d{0,2})\)""")
    val input = Path("src/main/resources/day3_input.txt").readText()

    val result = regex.findAll(input).map {
        val (a, b) = it.destructured
        a.toInt() * b.toInt()
    }.sum()

    println(result)
}
