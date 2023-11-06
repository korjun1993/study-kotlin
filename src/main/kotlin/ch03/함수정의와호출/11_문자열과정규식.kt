package ch03.함수정의와호출

/**
 *
 */

fun main() {
    parsePath("/Users/yole/kotlin-book/chapter.doc")
    parsePathWithRegex("/Users/yole/kotlin-book/chapter.doc")
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

/**
 * 정규식을 이용한 문자열 파싱
 * 3중 따옴표 문자열을 사용해 정규식을 썼다.
 * 3중 따옴표 문자열에서는 역슬래시(\)를 포함한 어떤 문자도 이스케이프할 필요가 없다.
 * 예를 들어 일반 문자열을 사용해 정규식을 작성하는 경우 마침표 기호를 이스케이프하려면 \\. 라고 써야 하지만, 3중 따옴표 문자열에서는 \. 라고 쓰면 된다.
 */
fun parsePathWithRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}
