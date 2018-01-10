class Anagram(private val word: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        var result = mutableSetOf<String>()
        anagrams.forEach{x ->
            var shouldBeDiscounted : Boolean = false
            if (word.toLowerCase() == x.toLowerCase()) {shouldBeDiscounted = true}

            var theChars  = word.toLowerCase().split("").map{it.trim()}.toMutableList()
            var testedChars = x.toLowerCase().split("").map{it.trim()}.toMutableList()
            var failedToRemove : Boolean = false
            theChars.forEach{y ->
                if (!testedChars.contains(y)) {failedToRemove = true}
                testedChars.remove(y)
            }
            if (testedChars.isEmpty() && !failedToRemove &&
                    !shouldBeDiscounted){result.add(x)}
        }
        result.forEach{x -> println(x)}
        return result
    }
}