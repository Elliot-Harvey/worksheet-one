object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        var Sum: Int = 0
        var multiplesToAdd = mutableSetOf<Int>()
        factors.forEach{x ->
            var currentMultiple : Int = x
            while (currentMultiple < limit){
                multiplesToAdd.add(currentMultiple)
                currentMultiple+=x
            }
        }

        multiplesToAdd.forEach{x ->
            Sum+=x
        }

        println(Sum)
        return Sum;
    }
}