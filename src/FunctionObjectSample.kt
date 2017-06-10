fun square(i: Int): Int = i * i

fun main(args: Array<String>) {
    val functionObject = :: square
    println(functionObject(5))
    println(firstK("BLANK"))
    println(firstUpperCase("upperCase"))
    val counter1 = getCounter()
    val counter2 = getCounter()
    println(counter1())
    println(counter1())
    println(counter2())
    println(counter1())
    println(counter2())
    log { "このメッセージは出力される" }
    log(false) { "このメッセージは出力されない" }
    println(containsDigit("hoge1fuga"))
    println(containsDigit("hoge"))
}

fun firstK(str: String): Int {
    fun isK(c: Char): Boolean = c == 'K'
    return first(str, ::isK)
}

fun firstUpperCase(str: String): Int {
    fun isUpperCase(c: Char): Boolean = c.isUpperCase()
    return first(str, ::isUpperCase)
}

fun first(str: String, predicate: (Char) -> Boolean): Int {
    tailrec fun go(str: String, index: Int): Int =
            when {
                str.isEmpty() -> -1
                predicate(str.first()) -> index
                else -> go(str.drop(1), index + 1)
            }
    return go(str, 0)
}

val square1 = { i: Int ->
    i * i
}
val square2: (Int) -> Int = {
    it * it
}

fun firstWhitespace(str: String): Int {
    return first(str) { it.isWhitespace() }
}

fun getCounter(): ()-> Int {
    var count = 0
    return { count++ }
}

inline fun log(debug: Boolean = true, message: () -> String) {
    if (debug) {
        println(message())
    }
}

inline fun forEach(str: String, f: (Char) -> Unit) {
    for (c in str) {
        f(c)
    }
}

fun containsDigit(str: String): Boolean {
    var result = false
    forEach(str) {
        if (it.isDigit()) {
            result = true
            return@forEach
        }
    }
    return result
}


