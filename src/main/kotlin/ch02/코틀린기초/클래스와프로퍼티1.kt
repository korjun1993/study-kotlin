package ch02.코틀린기초

/**
 * 코틀린의 클래스 기본 접근 제어자는 public 이다.
 */
class 클래스와프로퍼티1(val name: String) {
}

/**
 * 위 코드는 다음 Java 코드와 동일하다.
 *
 * public class 클래스와프로퍼티1 {
 *  private final String name;
 *
 *  public 클래스와프로퍼티1(String name) {
 *      this.name = name;
 *  }
 *
 *  public String getName() {
 *      return name;
 *  }
 * }
 */
