package ch04.객체

import java.io.File

/**
 * 객체 선언(object)
 * 객체 선언은 클래스를 정의하고 그 클래스의 인스턴스를 만들어서 변수에 저장하는 모든 작업을 단 한 문장으로 처리한다.
 * 생성자는(주 생성자와 부 생성자 모두) 객체 선언에 쓸 수 없다.
 * 객체 선언도 클래스나 인터페이스를 상속할 수 있다.
 * 어떤 클래스에 속한 객체를 비교할 때 사용하는 Comparator는 보통 클래스마다 단 하나씩만 있으면 된다.
 * 따라서 Comparator 인스턴스를 만드는 방법으로는 객체 선언이 가장 좋은 방법이다.
 */

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

fun main() {
    val result = CaseInsensitiveFileComparator.compare(File("/User"), File("/user"))
    println(result)


    // Comparator를 인자로 받는 함수에게 인자로 넘길 수 있다.
    val files = listOf(File("/Z"), File("/z"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}
