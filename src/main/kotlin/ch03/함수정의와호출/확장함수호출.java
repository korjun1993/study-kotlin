package ch03.함수정의와호출;

/**
 * 내부적으로 확장 함수는 수신 객체를 첫 번째 인자로 받는 정적 메서드다.
 * 최상위 함수와 마찬가지로 확장 함수가 들어있는 자바 클래스 이름도 확장 함수가 들어있는 파일 이름에 따라 결정된다.
 */
public class 확장함수호출 {
	public static void main(String[] args) {
		System.out.println(_6_확장함수Kt.lastChar("Kotlin"));
	}
}
