package `1`

/**
 * 코틀린에는 자바의 for 루프에 해당하는 요소가 없다.
 * 이런 루프의 가장 흔한 용례인 초깃값, 증가 값, 최종 값을 사용한 루프를 대신하기 위해 코틀린에서는 범위(range)를 사용한다.
 * 범위는 기본적으로 두 값으로 이뤄진 구간이다.
 * 보통은 그 두 값은 정수 등의 숫자 타입의 값이며, .. 연산자로 시작 값과 끝 값을 연결해서 범위를 만든다.
 * 코틀린의 범위는 폐구간(양끝을 포함하는 구간)이다.
 */
fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    // 역방향 수열을 만드려면 downTo를 이용한다.
    // 증가 값을 바꾸려면 step을 이용한다.
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    // 끝 값을 포함하지 않는 반만 닫힌 범위를 이터레이션하려면 until 함수를 이용한다.
    for (i in 0 until 100) {
        print(fizzBuzz(i))
    }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}
