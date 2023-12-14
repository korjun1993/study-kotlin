package ch04.생성자

/**
 * 부 생성자
 * 이 클래스는 주 생성자를 선언하지 않고(클래스 이름 뒤에 괄호가 없다)
 * 부 생성자만 2가지 선언한다.
 * 부 생성자는 constructor 키워드로 시작한다.
 * 필요에 따라 얼마든지 부 생성자를 많이 선언해도 된다.
 */
open class View {
    private val ctx: String

    constructor(ctx: String) {
        this.ctx = ctx
    }

    constructor(ctx: String, attr: String) {
        this.ctx = ctx
    }
}

/**
 * 클래스를 확장했을 때, 클래스에 주 생성자가 없다면 모든 부 생성자는 반드시 super 생성자를 호출해야 한다.
 * 아래의 두 부 생성자는 super() 키워드를 통해 자신에 대응하는 상위 클래스 생성자를 호출한다.
 */
class MyButton : View {
    constructor(ctx: String) : super(ctx) { // 상위 클래스의 생성자 호출!
        //...
    }

    constructor(ctx: String, attr: String) : super(ctx, attr) { // 상위 클래스의 생성자 호출!
        //...
    }

    constructor(ctx: String, size: Int) : this(ctx) // 같은 클래스 내의 다른 생성자에게 위임
}
