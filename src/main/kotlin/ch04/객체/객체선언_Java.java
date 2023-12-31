package ch04.객체;

import java.io.File;

/**
 * 코틀린 객체 선언은 정적인 필드가 있는 자바 클래스로 컴파일된다.
 * 그리고 그 클래스 안에는 INSTANCE 라는 이름으로 유일한 인스턴스를 가리키는 필드가 생긴다.
 * 자바 코드에서 코틀린 싱글턴 객체를 사용하려면 INSTANCE 필드를 통하면 된다.
 */
public class 객체선언_Java {
	public static void main(String[] args) {
		int result = CaseInsensitiveFileComparator.INSTANCE.compare(new File("/z"), new File("/Z"));
		System.out.println("result = " + result);
	}
}
