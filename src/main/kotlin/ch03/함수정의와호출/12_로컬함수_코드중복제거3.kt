package ch03.함수정의와호출

/**
 * 검증 로직을 확장 함수로 추출하기
 * 검증 로직은 User를 사용하는 다른 곳에서는 쓰이지 않는 기능이기 때문에 User에 포함시키고 싶지 않다. → 확장함수
 * 객체의 private 데이터를 다룰 필요가 없는 함수는 확장 함수로 만들면 객체.멤버처럼 수신 객체를 지정하지 않고도 공개된 멤버 프로퍼티나 메서드에 접근할 수 있다.
 */
class UserV4(val id: Int, val name: String, val address: String)

fun UserV4.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${id}: empty $fieldName" // User의 프로퍼티를 직접 사용할 수 있다.
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUserV4(user: UserV4) {
    user.validateBeforeSave()
    // user를 데이터베이스에 저장한다.
}

fun main() {
    saveUserV4(UserV4(1, "", ""))
}
