package ch04.내부클래스

import java.io.Serializable

/**
 * 코틀린의 중첩 클래스는 자바와 다르게 바깥쪽 클래스의 멤버에 대한 접근 권한이 없다.
 *
 */
interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}
