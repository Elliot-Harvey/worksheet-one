object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        var result = mutableListOf<Int>()
        var factor : Int = 2
        var currentVal : Int = int
        while (currentVal != 1){
            if (currentVal % factor != 0){
                factor++
                currentVal = int
            }
            else {
                currentVal/=factor
                if (checkIfPrime(factor)){
                    result.add(factor)
                }

            }
        }

        return result
    }

    fun primeFactors(long: Long): List<Long> {
        var result = mutableListOf<Long>()
        var factor : Long = 2
        var currentVal : Long = long
        while (currentVal != 1L){
            if (currentVal % factor != 0L){
                factor++
                currentVal = long
            }
            else {
                currentVal/=factor
                if (checkIfPrime(factor.toInt())){
                    result.add(factor)
                }

            }
        }

        return result
    }

    fun checkIfPrime(value: Int): Boolean{
        for (x in 2..value/2){
            if (value % x == 0) {return false}
        }

        return true;
    }
}
