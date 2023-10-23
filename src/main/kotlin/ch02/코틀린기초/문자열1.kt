package ch02.코틀린기초

/**
 * 문자열 템플릿
 * 변수를 문자열 안에 사용할 수 있다.
 * 문자열 리터럴의 필요한 곳에 변수를 넣되 변수 앞에 $를 추가해야 한다.
 * 컴파일러는 각 식을 컴파일 시점에 검사하기 때문에 존재하지 않는 변수를 문자열 템플릿 안에서 사용하며 컴파일 오류가 발생한다.
 */
fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")

    /**
     * $ 문자를 문자열에 넣고 싶으면 \를 사용해 $를 이스케이프시켜야 한다.
     */
    println("\$x")

    /**
     * 복잡한 식도 중괄호로 둘러싸서 문자열 템플릿 안에 넣을 수 있다.
     */
    println("Hello, ${args[0]}!")
}
