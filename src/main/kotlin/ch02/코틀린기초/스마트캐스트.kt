package ch02.코틀린기초

/**
 * 코틀린에서는 is를 사용해 변수 타입을 검사한다.
 * 어떤 변수가 원하는 타입인지 is로 검사하고 나면 굳이 변수를 원하는 타입으로 캐스팅하지 않아도 된다.
 * 컴파일러가 캐스팅을 대신 수행해준다. 이를 스마트 캐스트라고 부른다.
 */
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // 여기서 Num으로 타입을 변환하는데, 이는 불필요한 중복이다.
        return n.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right) // 변수 e에 대해 스마트 캐스트를 사용한다.
    }
    throw IllegalArgumentException("Unknown expression")
}

/**
 * 코틀린에서는 if, when은 값을 만들어내는 식(statement)이다.
 * 각 분기 블록의 맨 마지막 식이 결과 값이 된다.
 * 단, 위 규칙은 블록이 본문인 함수에 대해서는 성립하지 않는다.
 * 블록이 본문인 함수는 내부에 return문이 반드시 있어야 한다.
 *
 * if 대신 when을 사용하면 좋을 때가 언제일까?
 * when 식은 동등성 검사, 값의 타입 검사할 때 사용한다.
 * 동등성 검사 -> when으로enum다루기.kt 참고
 */
fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }

        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }

        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr
