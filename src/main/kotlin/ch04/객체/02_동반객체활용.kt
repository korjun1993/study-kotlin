package ch04.객체

fun getFacebookName(facebookAccountId: Int): String = "call api"

class User1 {
    private val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

/**
 * 팩토리 클래스로 변경해보자.
 * 동반 객체는 자신을 둘러싼 클래스의 모든 private 멤버에 접근할 수 있다.
 * 따라서 동반 객체는 팩토리 패턴을 구현하기 가장 적합한 방법이다.
 */
class User2 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User2(email.substringBefore('@'))

        fun newFacebookUser(facebookAccountId: Int) =
            User2(getFacebookName(facebookAccountId))
    }
}

fun main() {
    val user1 = User2.newSubscribingUser("bob@gmail.com")
    val user2 = User2.newFacebookUser(4)
    println(user1.nickname)
    println(user2.nickname)
}
