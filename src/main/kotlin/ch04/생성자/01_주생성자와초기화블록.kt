package ch04.생성자

/**
 * 주 생성자
 * constructor 키워드는 주 생성자나 부 생성자 정의를 시작할 때 사용한다.
 * 주 생성자의 파라미터는 프로퍼티를 초기화하는 식(26L)이나 초기화 블록(17L) 안에서만 참조할 수 있다.
 */
class UserV1 constructor(_nickname: String) {
    val nickname: String

    /**
     * 초기화 블록
     * 클래스의 객체가 만들어질 때 실행될 초기화 코드
     * 주 생성자는 별도의 코드를 포함할 수 없으므로 초기화 블록이 필요하다.
     * 초기화 블록 안에서 주 생성자의 파라미터를 참조할 수 있다.
     */
    init {
        nickname = _nickname
    }
}

/**
 * 주 생성자 앞에 별다른 애노테이션이나 가시성 변경자가 없다면 constructor 키워드를 생략해도 된다.
 */
class UserV2(_nickname: String) {
    val nickname = _nickname // 프로퍼티를 초기화하는 식에서 주 생성자의 파라미터를 참조할 수 있다.
}

/**
 * 주 생성자의 파라미터로 프로퍼티를 초기화한다면,
 * 그 주 생성자 파라미터 이름 앞에 val을 추가하는 방식으로 프로퍼티 정의와 초기화를 간략히 쓸 수 있다.
 */
class UserV3(val nickname: String)

/**
 * 함수 파라미터와 마찬가지로 생성자 파라미터에도 디폴트 값을 정의할 수 있다.
 */
class UserV4(val nickname: String, val isSubscribed: Boolean = true)
