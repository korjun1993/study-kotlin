package `1`

fun main() {
    println(getMnemonic(Color.BLUE))
}

/**
 * 자바의 switch에 해당하는 코틀린 구성 요소는 when이다.
 * 자바와 달리 각 분기의 끝에 break를 넣지 않아도 된다.
 */
fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

/**
 * 한 분기 안에서 여러 값을 매치 패턴으로 사용할 수도 있다.
 * 그럴 경우 값 사이를 콤마(,)로 분리한다.
 */
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

/**
 * 분기 조건에 상수만을 사용할 수 있는 자바 switch와 달리 코틀린 when의 분기 조건은 임의의 객체를 허용한다.
 * when 식은 인자 값과 매치하는 조건 값을 찾을 때까지 각 분기를 검사한다.
 * 여기서는 setOf(c1,c2)와 분기 조건에 있는 객체 사이를 매치할 때 동등성(equality)을 사용한다.
 */
fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}

enum class Color(val r: Int, val g: Int, val b: Int) {

    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}
