package ch04.위임

/**
 * 데코레이터 패턴
 * 기본 제품에 포장지나 외부 디자인을 변경함으로써 새로운 기능을 부여하는 것과 같이,
 * 객체 지향 프로그래밍에서 원본 객체에 대한 무언가를 장식하여 더 멋진 기능을 가지게 만드는 방법
 * 데코레이터 패턴을 이용하면 필요한 추가 기능의 조합을 런타임에서 동적으로 생성할 수 있다.
 */

/**
 * 원본 객체와 장식된 객체 모두를 묶는 역할
 */
interface IComponent {
    fun operation()
}

/**
 * 장식될 원본 객체
 */
class ConcreteComponent : IComponent {
    override fun operation() {
        //...
    }
}

/**
 * 추상화된 장식자 클래스
 * wrapee: 원본 객체를 composition
 */
abstract class Decorator(val wrapee: IComponent) : IComponent {
    override fun operation() {
        wrapee.operation() // 위임
    }
}

class ComponentDecorator1(component: IComponent) : Decorator(component) {
    override fun operation() {
        super.operation()   // 원본 객체를
        extraOperation()    // 장식 클래스만의 메소드 실행
    }

    private fun extraOperation() {

    }
}

class ComponentDecorator2(component: IComponent) : Decorator(component) {
    override fun operation() {
        super.operation()
        extraOperation()    // 장식 클래스만의 메소드 실행
    }

    private fun extraOperation() {

    }
}

fun main() {
    // 1. 원본 객체 생성
    val obj = ConcreteComponent()

    // 2. 장식 1
    val deco1 = ComponentDecorator1(obj)
    deco1.operation()

    // 3. 장식 2
    val deco2 = ComponentDecorator2(obj)
    deco2.operation()

    // 4. 장식 1 + 2
    val deco3 = ComponentDecorator1(ComponentDecorator2(obj))
    deco3.operation()
}
