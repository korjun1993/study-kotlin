package ch04.생성자

/**
 * 클래스에 기반 클래스가 있다면 주 생성자에서 기반 클래스의 생성자를 호출해야할 필요가 있다.
 * 기반 클래스를 초기화하려면 기반 클래스 이름 뒤에 괄호를 치고 생성자 인자를 넘긴다.
 */
open class User(val nickname: String)

class TwitterUser(nickname: String) : User(nickname)
