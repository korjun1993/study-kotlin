package ch05

/**
 * with, apply 그리고 수신 객체 지정 람다에 대해 알아본다.
 * 수신 객체 지정 람다란 자바의 람다에는 없는 코틀린 람다의 독특한 기능이다.
 * 람다의 본문 안에서 다른 객체의 메서드를 호출할 수 있게 한다.
 */

/**
 * 리팩토링을 통해 with의 유용성을 알아보자.
 * 이 예제에서는 result를 반복해서 사용한다.
 */
fun alphabet1(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

/**
 * with문을 사용해 alphabet1()을 리팩터링해보자.
 * with문은 언어가 제공하는 특별한 구문처럼 보이지만, 실제로는 파라미터가 2개 있는 함수다.
 * 첫 번째 파라미터는 stringBuilder이고, 두 번째 파라미터는 람다다.
 * with 함수는 첫 번째 인자로 받은 객체를 두 번째 인자로 받은 람다의 수신 객체로 만든다.
 * 인자로 받은 람다 본문에서는 this를 사용해 그 수신 객체에 접근할 수 있다.
 * 일반적인 this와 마찬가지로 this와 점(.)을 사용하지 않고 프로퍼티나 메서드 이름만 사용해도 수신 객체의 맴버에 접근할 수 있다.
 */
fun alphabet2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter) // this를 통한 수신객체 접근
        }
        append("\nNow I know the alphabet!") // this를 생략한 수신객체 접근
        this.toString()
    }
}

/**
 * apply 함수에 대해 알아보자.
 * apply 함수는 with와 거의 같다. 유일한 차이란 apply는 자신에게 전달된 객체를 반환한다는 점뿐이다.
 * apply는 확장 함수로 정의돼 있다.
 * apply의 수신 객체가 전달받은 람다의 수신 객체가 된다. (확장 함수의 수신객체 = 람다의 수신객체)
 * 람다를 실행하고 나면 apply는 람다에 의해 초기화된 StringBuilder 인스턴스를 반환한다.
 */
fun alphabet3(): String =
    StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }.toString()

fun main() {
    alphabet1()
    alphabet2()
    alphabet3()
}
