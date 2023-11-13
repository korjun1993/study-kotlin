package ch05

fun main() {
    /**
     * 람다식의 문법에 대해 알아보자.
     * 1. 람다식은 항상 중괄호로 둘러싸여 있다.
     * 2. 화살표가 인자 목록과 람다 본문을 구분해준다.
     * 3. 람다식을 변수에 저장할 수 있다.
     * 4. 본문이 여러 줄로 이뤄진 경우 본문의 맨 마지막에 있는 식이 람다의 결과 값이 된다.
     */
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    /**
     * 아래의 코드를 점진적으로 개선해보자.
     */
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val oldest1 = people.maxBy({ p: Person -> p.age })

    // 1. 코틀린에서는 함수 호출 시 맨뒤에 있는 인자가 람다식이라면 그 람다를 괄호 밖으로 빼낼 수 있다.
    // 둘 이상의 람다를 인자로 받는 함수라면 맨 마지막 람다만 밖으로 뺄 수 있다.
    val oldest2 = people.maxBy() { p: Person -> p.age }

    // 2. 람다가 어떤 함수의 유일한 인자이고 괄호 뒤에 람다를 썼다면 빈 괄호를 없애도 된다.
    val oldest3 = people.maxBy { p: Person -> p.age }

    // 3. 컴파일러가 문맥으로부터 유추할 수 있는 타입을 굳이 적을 필요는 없다.
    // 로컬 변수처럼 컴파일러는 람다 파라미터의 타입도 추론할 수 있다.
    // maxBy 함수의 경우 파라미터 타입은 항상 컬렉션 원소 타입과 같다.
    val oldest4 = people.maxBy { p -> p.age }

    // 4. 인자가 단 하나뿐인 경우 굳이 인자에 이름을 붙이지 않아도 된다.
    // 람다의 인자가 하나뿐이고 그 타입을 컴파일러가 추론할 수 있는 경우 it를 쓸 수 있다.
    val oldest5 = people.maxBy { it.age }

    /**
     * 참고사항
     */
    // 람다를 변수에 저장할 때는 파라미터의 타입을 추론할 문맥이 존재하지 않는다.
    // 따라서 파라미터 타입을 명시해야 한다.
    val getAge = { p: Person -> p.age }
}
