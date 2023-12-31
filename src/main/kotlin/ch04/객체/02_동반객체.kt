package ch04.객체

/**
 * 동반 객체
 * 코틀린 언어는 static 키워드를 지원하지 않는다.
 * 그 대신 패키지 수준의 최상위 함수, 객체 선언을 활용한다.
 * 대부분의 경우 최상위 함수를 활용하는 편을 더 권장한다.
 * 하지만 최상위 함수는 클래스의 private 멤버에 접근할 수 없다.
 */

class TopLevelFunctionCannotAccessPrivateMember {
    private fun foo() {
        //...
    }
}

fun topLevelFunction() {
    val sut = TopLevelFunctionCannotAccessPrivateMember()
//    sut.foo() // error
}


/**
 * 클래스의 인스턴스가 없어도 호출이 가능하고,
 * 클래스 내부 정보에 접근해야 하는 함수가 필요할 때는 중첩된 객체선언의 멤버함수로 정의해야 한다.
 */

class InnerObjectOuterClass {
    private fun foo() {
        //...
    }

    object InnerClass {
        fun goo() {
            val sut = InnerObjectOuterClass()
            sut.foo() // private 멤버 접근 가능
        }
    }
}

/**
 * 클래스 안에 정의된 객체에 companion 키워드를 붙이면 그 클래스의 동반 객체로 만들 수 있다.
 * 동반 객체는 이름을 생략할 수 있다.
 * 동반 객체의 프로퍼티나 메서드에 접근하려면 그 동반 객체가 정의된 클래스 이름을 사용하면 된다.
 */

class CompanionObjectOuterClass {
    private fun foo() {
        //...
    }

    companion object {
        fun goo() {
            val sut = CompanionObjectOuterClass()
            sut.foo()
        }
    }
}

fun main() {
    InnerObjectOuterClass.InnerClass.goo()
    CompanionObjectOuterClass.goo() // 동반 객체를 사용하면 자바의 정적 메서드 호출이나 정적 필드 사용 구문과 같아진다.
}
