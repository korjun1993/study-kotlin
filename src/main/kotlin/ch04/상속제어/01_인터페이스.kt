package ch04.상속제어

interface Clickable {
    fun click()

    /**
     * 디폴트 구현을 제공할 수 있다.
     * 자바8과 달리 메서드 앞에 default를 붙이지 않아도 된다.
     */
    fun showOff() = println("I'm clickable!")
}

/**
 * 코틀린에서는 클래스 이름 뒤에 콜론(:)을 붙이고 인터페이스와 클래스 이름을 적는 것으로 클래스 확장과 인터페이스 구현을 모두 처리한다.
 * 자바와 마찬가지로 클래스는 인터페이스를 원하는 만큼 개수 제한 없이 구현할 수 있지만, 클래스는 오직 하나만 확장할 수 있다.
 * 자바의 @Override 어노테이션과 비슷한 override 변경자는 상위 클래스나 상위 인터페이스에 있는 프로퍼티나 메서드를 오버라이드한다는 표시다.
 * 코틀린에서는 반드시 override 변경자를 사용해야 한다.
 */
class Button : Clickable {
    override fun click() {
        println("I was clicked")
    }
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

/**
 * 동일한 메서드를 구현하는 다른 인터페이스 2개를 모두 구현하면 어떻게 될까?
 * 클래스가 구현하는 두 상위 인터페이스에 정의된 showOff 구현을 대체할 오버라이딩 메서드를 직접 제공하지 않으면 컴파일러 오류가 발생한다.
 * 코틀린 컴파일러는 두 메서드를 아우르는 구현을 하위 클래스에 직접 구현하게 강제한다.
 */
class ButtonV2 : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    override fun showOff() {
        super<Clickable>.showOff() // 상위 타입의 이름을 꺾쇠 괄호(<>) 사이에 넣어서 "super"를 지정하면 어떤 상위 타입의 멤버 메서드를 호출할지 지정할 수 있다.
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = ButtonV2()
    button.showOff()
    button.setFocus(true)
    button.click()
}
