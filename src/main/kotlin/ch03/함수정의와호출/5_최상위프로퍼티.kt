package ch03.함수정의와호출

/**
 * 학습 목표
 * 최상위 프로퍼티, const에 대해 알아본다.
 *
 * 함수와 마찬가지로 프로퍼티도 파일의 최상위 수준에 놓을 수 있다.
 * 기본적으로 최상위 프로퍼티도 다른 모든 프로퍼티처럼 접근자 메서드를 통해 자바 코드에 노출된다.
 * val의 경우 게터, var의 경우 게터와 세터가 생긴다.
 * 게터를 이용하지 않고 상수처럼 사용하려면 public static final 필드로 컴파일 해야 한다.
 * const 변경자를 추가하면 프로퍼티를 public static final 필드로 컴파일하게 만들 수 있다.
 */

var opCount = 0 // 최상위 프로퍼티

const val UNIX_LINE_SEPARATOR = "\n" // public static final UNIX_LINE_SEPARATOR 와 동등한 바이트코드를 만들어낸다.

fun performOperation() {
    opCount++
}
