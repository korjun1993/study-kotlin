package `1`

/**
 * 커스텀 접근자
 */
class 클래스와프로퍼티3(val height: Int, val width: Int) {
    /**
     * 클라이언트가 프로퍼티(isSquare)에 접근할 때 마다 게터(get())가 프로퍼티 값을 매번 다시 계산한다.
     */
    val isSquare: Boolean
        get() { // 프로퍼티 게터 선언
            return height == width;
        }
}

fun main() {
    val clazz = 클래스와프로퍼티3(41, 43)
    println(clazz.isSquare)
}
