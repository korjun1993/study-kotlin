package ch04.내부클래스

/**
 * 자바와 코틀린의 중첩 클래스 차이점에 대해 학습
 * 코틀린 중첩 클래스에 아무런 변경자가 붙지 않으면 자바 static 중첩 클래스와 같다.
 * 이를 내부 클래스로 변경해서 바깥쪽 클래스에 대한 묵시적인 참조를 포함하게 만들고 싶다면 inner 변경자를 붙여야 한다.
 *
 * 중첩 클래스
 * 자바 - static class A
 * 코틀린 - class A
 *
 * 내부 클래스
 * 자바 - class A
 * 코틀린 - inner class A
 */
class ButtonKt : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State
}

/**
 * 코틀린에서 바깥쪽 클래스의 인스턴스를 가리키는 참조를 표기하는 방법도 자바와 다르다.
 * 내부 클래스 Inner 안에서 바깥쪽 클래스 Outer의 참조에 접근하려면 this@Outer 라고 써야 한다.
 */
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
