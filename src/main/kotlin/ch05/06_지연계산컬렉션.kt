package ch05

/**
 * 지연 컬렉션 연산에 대해 알아보자.
 * map, filter 같은 컬렉션 함수는 결과 컬렉션을 즉시 생성한다.
 * 이는 컬렉션 함수를 연쇄하면 매 단계마다 계산 중간 결과를 새로운 컬렉션에 임시로 담는다는 말이다.
 * "시퀀스"를 사용하면 중간 임시 컬렉션을 사용하지 않고도 컬렉션 연산을 연쇄할 수 있다.
 *
 * 코틀린 시퀀스 vs 자바 스트림
 * 자바8 스트림과 시퀀스는 같은 개념이다.
 * 자바8은 스트림 연산을 여러 CPU에서 병렬적으로 실행할 수 있는 기능을 제공한다.
 */
fun main() {
    // 컬렉션 함수의 동작 방법에 대해 알아보자.
    // 코틀린 표준 라이브러리 문서에는 filter, map 연산이 리스트를 반환한다고 써 있다.
    // 이는 이 연쇄 호출이 리스트를 2개 만든다는 뜻이다.
    // 한 리스트는 filter의 결과를 담고, 다른 하나는 map의 결과를 담는다.
    // 원소가 수백만 개가 되면 효율이 떨어진다.
    // 이를 효율적으로 만들기 위해서는 시퀀스를 샤용하게 만들어야 한다.
    listOf(Person("호준", 30), Person("타조", 30))
        .map { it.name }
        .filter { it.startsWith("A") }

    // 시퀀스의 동작 방법에 대해 알아보자.
    // 코틀린 지연 계산 시퀀스는 Sequence 인터페이스에서 시작한다.
    // 이 인터페이스는 단지 iterator 라는 메서드를 제공하여 시퀀스로부터 원소값을 얻을 수 있도록 해준다.
    // 시퀀스를 사용하면 중간 처리 결과를 저장하지 않고도 연산을 연쇄적으로 적용해서 효율적으로 계산할 수 있다.
    // 시퀀스는 최종 연산(toList, sum 등)을 수행하기 전까지는 계산되지 않는다.
    // map(1)
    // filter(1)
    // map(2)
    // filter(4)
    // map(3)
    // filter(9)
    // map(4)
    // filter(16)
    listOf(1, 2, 3, 4).asSequence()
        .map { println("map($it)"); it * it }
        .filter { println("filter($it)"); it % 2 == 0 }
        .toList()

    // 시퀀스를 만들어 사용해보자.
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numberTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numberTo100.sum())
}
