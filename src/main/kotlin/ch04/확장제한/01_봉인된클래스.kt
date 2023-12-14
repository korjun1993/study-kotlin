package ch04.확장제한

interface MyExpr
class MyNum(val value: Int) : MyExpr
class MySum(val left: MyExpr, val right: MyExpr) : MyExpr

/**
 * 코틀린 컴파일러는 MyExpr을 확장한 모든 클래스를 전부 알지 못한다.
 * 따라서 when을 사용해 MyExpr 타입의 값을 검사할 때 꼭 디폴트 분기인 else 분기를 덧붙이게 강제한다.
 * 디폴트 분기가 있으면 문제가 생기는 경우가 있다.
 * 예를 들어, MyExpr을 확장하는 새로운 하위 클래스를 추가했을 때,
 * 실수로 새로운 클래스 처리를 잊어버렸더라도 when식의 디폴트 분기가 선택되기 때문에 심각한 버그가 발생할 수 있다.
 */
fun eval1(e: MyExpr): Int =
    when (e) {
        is MyNum -> e.value
        is MySum -> eval1(e.right) + eval1(e.left)
        else -> throw IllegalArgumentException() // 반드시 추가해야함!
    }

/**
 * sealed 클래스를 통해 문제를 해결해보자.
 * 클래스 계층 정의 시 계층 확장 제한하기
 * 1. 기반 클래스를 sealed로 봉인한다.
 * 2. 기반 클래스의 모든 하위 클래스를 중첩 클래스로 나열한다.
 * 이제 컴파일러는 Expr 하위 클래스가 Num, Sum이 전부라는 것을 안다.
 */

sealed class Expr { // sealed class -> 자동으로 open class 이므로 open 변경자를 붙일 필요가 없다.
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}


/**
 * 따라서 when 식에 디폴트 분기를 사용하지 않아도 된다.
 * 나중에 sealed 클래스의 상속 계층에 새로운 하위 클래스를 추가되면 when 식에서 컴파일 에러가 발생하게 된다.
 * 컴파일 에러는 새로운 하위 클래스를 처리하는 로직을 when 식에 추가하도록 강제하여 실수를 방지해준다.
 */
fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
//        else -> throw IllegalArgumentException() // when 식에서 sealed 클래스의 모든 하위 클래스를 처리한다면 디폴트 분기가 필요 없다.
    }
