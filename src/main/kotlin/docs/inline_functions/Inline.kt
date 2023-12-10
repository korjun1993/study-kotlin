package docs.inline_functions

fun doSomethingElse(lambda: () -> Unit) {
    lambda()
}

fun doSomething() {
    println("Before lambda")
    doSomethingElse { println("inside lambda") }
    println("After lambda")
}

/**
 * 위 함수는 아래와 같은 java 코드로 컴파일된다.
 * public static final void doSomething() {
 *     System.out.println("Before lambda");
 *     doSomethingElse(new Function() {
 *          public final void invoke() {
 *              System.out.println("inside lambda");
 *          }
 *     })
 *     System.out.println("After lambda");
 * }
 *
 * doSomethingElse()를 호출할 때 마다, 파라미터로 새로운 익명 객체를 생성하여 넘겨준다.
 * 이는 무의미하게 새로운 객체를 매번 생성하는 것으로 보인다.
 */


inline fun doSomethingElseInline(lambda: () -> Unit) {
    lambda()
}

fun doSomethingInline() {
    println("Before lambda")
    doSomethingElseInline { println("inside lambda") }
    println("After lambda")
}

/**
 * 위 함수는 아래와 같은 java 코드로 컴파일된다.
 * public static final void doSomething() {
 *     System.out.println("Before lambda");
 *     System.out.println("Inside lambda");
 *     System.out.println("After lambda");
 * }
 */

fun main() {
    doSomething()
    doSomethingInline()
}
