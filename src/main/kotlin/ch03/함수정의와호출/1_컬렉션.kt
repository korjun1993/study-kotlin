package ch03.함수정의와호출

/**
 * 코틀린은 자체 컬렉션을 제공하지 않고 표준 자바 컬렉션을 활용한다.
 * 코틀린 컬렉션은 자바 컬렉션과 똑같은 클래스이지만, 자바보다 더 많은 기능을 제공한다.
 * 예를 들어 리스트의 마지막 원소를 가져오거나 수로 이뤄진 컬렉션에서 최댓값을 찾을 수 있다.
 */
fun main() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)  // class java.util.HashSet
    println(list.javaClass) // class java.util.ArrayList
    println(map.javaClass)  // class java.util.HashMap

    // 마지막 원소 조회
    println(list.last())

    // 최댓값 조회
    println(list.max())
}
