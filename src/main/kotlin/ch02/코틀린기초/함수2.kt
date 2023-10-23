package ch02.코틀린기초

/**
 * 코틀린에서 if는 식이지 문(statement)이 아니다.
 * 식은 값을 만들어 내며 다른 식의 하위 요소로 계산에 참여할 수 있다.
 * 블록이 본문인 함수(block body): 본문이 중괄호로 둘러싸인 함수
 */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b;
}

/**
 * 식이 본문인 함수(expression body): 등호와 식으로 이뤄진 함수
 */
fun max2(a: Int, b: Int): Int = if (a > b) a else b

/**
 * 반환 타입을 생략한 식이 본문인 함수
 * 식이 본문인 함수의 경우 굳이 사용자가 반환 타입을 적지 않아도 컴파일러가 함수 본문 식을 분석해서 식의 결과 타입을 함수 반환 타입으로 정해준다.
 * 컴파일러가 타입을 분석해 주는 기능을 타입 추론(type inference)이라 부른다.
 */
fun max3(a: Int, b: Int) = if (a > b) a else b
