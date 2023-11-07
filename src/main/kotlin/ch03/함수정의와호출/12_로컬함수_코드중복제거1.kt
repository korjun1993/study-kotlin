package ch03.함수정의와호출

/**
 * 로컬 함수를 사용해 코드 중복 줄이기
 */
class UserV2(val id: Int, val name: String, val address: String)

fun saveUserV2(user: UserV2) {
    fun validate(user: UserV2, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // user를 데이터베이스에 저장한다.
}

fun main() {
    saveUserV2(UserV2(1, "", ""))
}
