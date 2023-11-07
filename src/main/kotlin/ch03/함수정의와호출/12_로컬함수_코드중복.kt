package ch03.함수정의와호출

/**
 * 코드 중복을 보여주는 예제
 */
class UserV1(val id: Int, val name: String, val address: String)

fun saveV1(userV1: UserV1) {
    if (userV1.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${userV1.id}: empty Name"
        )
    }

    if (userV1.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${userV1.id}: empty Address"
        )
    }

    // user를 데이터베이스에 저장한다.
}

fun main() {
    saveV1(UserV1(1, "", ""))
}
