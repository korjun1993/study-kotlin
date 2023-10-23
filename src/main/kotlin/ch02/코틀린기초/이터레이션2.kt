package ch02.코틀린기초

import java.util.TreeMap

/**
 * 목표. 맵에 대한 이터레이션을 배워보자
 *
 * 자바의 get, put을 사용하는 대신 map[key]나 map[key] = value를 사용해 값을 가져오고 설정할 수 있다.
 * 코틀린에서는 객체를 풀어서 각 부분을 분리하는 구조 분해 문법을 사용할 수 있다.
 * 아래의 코드처럼 맵을 이터레이션할 때, 원소를 키와 값으로 풀어서 분리할 수 있다.
 */
fun main() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') { // A부터 F까지 문자의 범위를 사용해 이터레이션
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) { // 구조 분해 문법을 사용하여 맵 이터레이션
        println("$letter = $binary")
    }

    // 구조 분해 문법을 사용하여 컬렉션 이터레이션
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
