package ch04.가시성

import ch04.상속제어.Focusable

/**
 * 클래스 멤버
 * public - 모든 곳에서 볼 수 있다.
 * internal - 같은 모듈 안에서만 볼 수 있다. 모듈...? 한 번에 컴파일되는 코틀린 파일들
 * protected - 하위 클래스 안에서만 볼 수 있다.
 * private 같은 클래스 안에서만 볼 수 있다.
 *
 * 최상위 선언
 * public - 모든 곳에서 볼 수 있다.
 * internal - 같은 모듈 안에서만 볼 수 있다.
 * protected - 지원 X
 * private - 같은 파일 내에서만 볼 수 있다.
 *
 * check point!
 * 확장 함수는 수신 클래스의 private, protected 멤버에 접근할 수 없다.
 *
 */
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech() { // 오류! public 함수가 그보다 가시성이 더 낮은 internal 타입인 TalkativeButton을 노출함
//    yell() // 오류! yell은 TalkativeButton의 private 멤버임
//    whisper() // 오류! whisper은 TalkativeButton의 protected 멤버임. 자바에서는 같은 패키지 안에서 protected 멤버에 접근할 수 있지만, 코틀린에서는 그렇지 않다.
//}

internal class PushButton : TalkativeButton() {
    fun push() {
        whisper() // OK! TalkativeButton의 하위 클래스이므로, protected 멤버 사용 가능
    }
}

internal fun TalkativeButton.listenSpeech() {
//    whisper() // 오류! 확장 함수는 수신 클래스의 protected 멤버를 사용할 수 없다. protected 멤버는 하위 클래스에서만 사용 가능하다.
}
