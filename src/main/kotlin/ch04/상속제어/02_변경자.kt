package ch04.상속제어

/**
 * 자바의 클래스와 메서드는 기본적으로 상속에 열려있지만, 코틀린의 클래스와 메서드는 기본적으로 final이다.
 * 어떤 클래스의 상속을 허용하려면 클래스 앞에 open 변경자를 붙여야 한다.
 * 그와 더불어 오버라이드를 허용하고 싶은 메서드나 프로퍼티의 앞에도 open 변경자를 붙여야 한다.
 */
open class RichButton : Clickable { // 이 클래스는 열려있다. 다른 클래스가 상속할 수 있다.
    fun disable() {} // 이 함수는 파이널이다. 하위 클래스가 이 메서드를 오버라이드 할 수 없다.
    open fun animate() {} // 이 함수는 열려있다. 하위 클래스에서 이 메서드를 오버라이드해도 된다.
    override fun click() {} // 오버라이드한 메서드는 기본적으로 열려있다.
}
