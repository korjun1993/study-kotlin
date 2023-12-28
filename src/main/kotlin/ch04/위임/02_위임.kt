package ch04.위임

/**
 * 데코레이터 패턴의 단점
 * 기존 클래스를 데코레이터 내부에 필드로 유지하여
 * 새로 정의해야 하는 기능은 데코레이터의 메서드에 새로 정의하고
 * 기존 기능이 그대로 필요한 부분은 기존 클래스의 메서드에게 요청을 전달한다.
 * 이런 접근 방법의 단점은 준비 코드가 상당히 많이 필요하다.
 * 아래 코드처럼 아무 동작도 변경하지 않는 데코레이터를 만들 때조차도 복잡한 코드를 작성해야 한다.
 */
class DecoratedCollection<T>(private val innerList: List<T>) : Collection<T> {
    override val size: Int
        get() = innerList.size

    override fun isEmpty(): Boolean =
        innerList.isEmpty()

    override fun iterator(): Iterator<T> =
        innerList.iterator()

    override fun containsAll(elements: Collection<T>): Boolean =
        innerList.containsAll(elements)

    override fun contains(element: T): Boolean =
        innerList.contains(element)
}

/**
 * by 키워드
 * by 키워드를 사용하면 복잡한 코드를 없앨 수 있다.
 * 컴파일러가 DecoratedCollection 클래스에 있던 구현과 비슷한 코드를 생성해낸다.
 * 메서드 중 일부의 동작을 변경하고 싶은 경우, 메서드를 오버라이드하면 컴파일러가 생성한 메서드 대신 오버라이드한 메서드가 쓰인다.
 */
class DelegatingCollection<T>(innerList: List<T>) : Collection<T> by innerList
