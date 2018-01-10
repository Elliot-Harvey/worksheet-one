object Accumulate {
    fun <T, R> accumulate(collection: List<T>, function: (T) -> R): List<R> {
        var result =  mutableListOf<R>()
        for (x in collection)
            result.add(function(x))

        return result
    }
}