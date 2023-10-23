/**
 * 코틀린 최상위 함수가 포함되는 클래스의 이름을 바꾸고 싶다면 파일에 @JvmName 애노테이션을 추가하면 된다.
 * 이 애노테이션은 파일의 맨 앞, 패키지 이름 선언 이전에 위치해야 한다.
 */
@file:JvmName("MyUtils")

package ch03.함수정의와호출

fun goo() {
    /**
     * 이 소스코드를 컴파일하면 아래의 Java 코드처럼 바뀐다.
     * public class MyUtils {
     *  public static void goo(...) {...}
     * }
     */
}
