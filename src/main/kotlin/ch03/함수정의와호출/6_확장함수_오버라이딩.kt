package ch03.함수정의와호출

/**
 * 동적 디스패치 vs 정적 디스패치
 * 컴파일 시점에 컴파일러는 객체의 타입을 모르고 참조변수의 타입만 아는 상태이다.
 * 동적 디스패치: 실행 시점에 객체 타입에 따라 호출될 대상 메서드를 결정하는 방식
 * 정적 디스패치: 컴파일 시점에 알려진 변수 타입에 따라 정해진 메서드를 호출하는 방식
 *
 * 학습 목표
 * 확장 함수가 정적으로 디스패치됨을 파악한다.
 * 따라서 확장 함수는 오버라이딩될 수 없음을 이해한다.
 *
 * 노트
 * 어떤 클래스를 확장한 함수와 그 클래스의 멤버 함수의 이름과 시그니처가 같다면 확장 함수가 아니라 멤버 함수가 호출된다.
 * 멤버 함수의 우선순위가 더 높다.
 */
fun main() {
    val view: View = Button() // 확장 함수는 정적으로 결정된다.
    view.click()    // 동적 디스패치: "view" 변수에 저장된 값의 실제 타입(Button)에 따라 호출될 메서드가 결정된다. -> Button clicked
    view.showOff()  // 정적 디스패치: "view" 변수의 타입인 View의 확장 함수를 실행한다. -> I'm a view
}

open class View {
    open fun click() = println("View clicked")
}

fun View.showOff() = println("I'm a view!")

class Button : View() {
    override fun click() = println("Button clicked")
}

fun Button.showOff() = println("I'm a Button!")
