package ch03.함수정의와호출

/**
 * 자바의 문제점
 * 자바에서는 모든 코드를 클래스의 메서드로 작성해야 한다.
 * 그 결과 다양한 정적 메서드를 모아두는 역할만 담당하며, 특별한 상태나 인스턴스 메서드는 없는 유틸리티 클래스가 생겨난다.
 * 코틀린에서는 이런 무의미한 클래스가 필요 없다.
 * 대신 함수를 직접 소스 파일의 최상위 수준에 위치시키면 된다.
 *
 * 학습 목표
 * 최상위 함수의 동작원리를 알아본다.
 */
fun foo() {
    /**
     * 코틀린 컴파일러는 최상위 함수가 들어있던 코틀린 소스 파일의 이름과 동일한 이름의 클래스를 생성한다.
     * public class _4_최상위함수 {
     *  public static void foo(...) {...}
     * }
     * 따라서 자바에서 foo()를 호출할 수 있다.
     * 호출 방법은 최상위함수호출.java 참고
     */
}
