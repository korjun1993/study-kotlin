package ch02.코틀린기초

import java.io.BufferedReader
import kotlin.NumberFormatException

/**
 * 자바와 달리 코틀린의 throw는 식이므로 다른 식에 포함될 수 있다.
 */
fun getPercentage(number: Int) {
    val percentage = if (number in 0..100)
        number
    else
        throw IllegalArgumentException("A Percentage value must be between 0 and 100: $number")
}

/**
 * 자바와 마찬가지로 예외를 처리하려면 try, catch, finally 절을 사용한다.
 * 자바와 다른 점은 함수 선언 뒤에 throws 절이 없다는 것이다.
 * 코틀린은 체크, 언체크 예외를 구별하지 않는다.
 * 코틀린은 try-with-resource 문법을 지원하지 않지만, 라이브러리 함수로 같은 기능을 구현할 수 있다.
 */
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

/**
 * 코틀린의 try 키워드는 if, when, throw와 마찬가지로 식이다.
 * 따라서 try의 값을 변수에 대입할 수 있다.
 * if와 달리 try 본문을 반드시 중괄호 {}로 둘러싸야 한다.
 * 다른 문장과 마찬가지로 try의 본문도 내부에 여러 문장이 있으면 마지막 식의 값이 전체 결과 값이다.
 */
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return // 예외가 발생한 경우 catch 블록 다음의 코드는 실행되지 않는다.
    }
    println(number)
}

fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null // 예외가 발생하면 null 값을 사용한다.
    }
    println(number)
}
