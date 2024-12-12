package org.example.day1

import org.example.AdventOfCode
import java.io.File

class DayOne : AdventOfCode {
    var listLeft = mutableListOf<Int>()
    var listRight = mutableListOf<Int>()

    override fun executeBoth() {
        readData()
        print("1:")
        executeOne()
        print("2:")
        executeTwo()
    }

    override fun executeOne() {
        var total = 0
        listLeft.sort()
        listRight.sort()

        if (listLeft.size != listRight.size) {
            throw Error("Lists not same size")
        }

        listLeft.forEachIndexed { index, elementLeft ->
           var elementRight = listRight.get(index)

           if (elementRight > elementLeft) {
               total += elementRight - elementLeft
           } else if (elementRight < elementLeft) {
                total += elementLeft - elementRight
           }
        }

        println(total)
    }

    override fun executeTwo() {
        var total = 0
        listLeft.forEachIndexed{ index, elementLeft ->
            val count = listRight.count{ it == elementLeft}

           total += count * elementLeft
        }

        println(total)
    }

    private fun readData() {
        File("C:/Personal_code/Advent-of-code-2024/advent-of-code-2024/src/main/kotlin/day1/data.txt")
            .forEachLine {
                val numbers: List<String> = it.trim().split("\\s+".toRegex())
                listLeft.add(numbers[0].toInt())
                listRight.add(numbers[1].toInt())
            }
    }
}