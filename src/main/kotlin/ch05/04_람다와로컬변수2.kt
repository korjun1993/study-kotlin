package ch05

/**
 * 자바와 똑같이 람다식은 람다식이 정의된 함수의 로컬변수에 접근 가능하다.
 * 자바와 다른 점은 다음과 같다.
 * 1. 파이널 변수가 아닌 변수에만 접근 가능하다.
 * 2. 람다 안에서 바깥의 변수를 변경해도 된다.
 */

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun main() {
    val response = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(response)
}
