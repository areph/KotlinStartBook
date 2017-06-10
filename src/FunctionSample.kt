fun sum(numbers: List<Long>): Long {
    tailrec fun go(numbers: List<Long>, accumulator: Long): Long =
            if (numbers.isEmpty()) accumulator
            else go(numbers.drop(1), accumulator + numbers.first())
    return go(numbers, 0)
}
fun main(args: Array<String>) {
   println(sum((1L..10L).toList()))
}
