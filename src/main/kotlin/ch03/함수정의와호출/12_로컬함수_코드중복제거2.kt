package ch03.함수정의와호출

/**
 * 로컬 함수에서 바깥 함수의 파라미터 접근하기
 */
class UserV3(val id: Int, val name: String, val address: String)

fun saveUserV3(user: UserV3) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName" // 바깥 함수의 파라미터에 직접 접근 ok
            )
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    // user를 데이터베이스에 저장한다.
}

fun main() {
    saveUserV3(UserV3(1, "", ""))
}
