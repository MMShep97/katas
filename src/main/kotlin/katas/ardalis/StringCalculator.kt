package katas.ardalis

// Stopped just before 7, because it was getting out of hand!!!
object StringCalculator {
    fun add(nums: String): Int {
        // 1. iii
        if (nums.isEmpty()) return 0

        // 4.
        val splitNums = if (nums.startsWith("//")) {
            nums.split(",", "\n", nums[2].toString()).drop(1)
        } else {
            nums.split(",", "\n")
        }.map { it.toInt() }.filter { it < 1000 } // 6.

        // 5.
        val negativeNums = splitNums.filter { it < 0 }
        if (negativeNums.isNotEmpty()) throw Exception("Negatives not allowed: ${negativeNums.joinToString(",")}")


        // 1. iv
        // require (splitNums.size <= 2) { "Can't be more than 2 nums in the input string" }

        return splitNums.sumOf { it } // 1. v
    }
}