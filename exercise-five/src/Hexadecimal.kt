object Hexadecimal {

    fun toDecimal(s: String): Int {
        val baseValue : Int = 16
        val valueTable : HashMap<String, Int> =  hashMapOf(
                "0" to 0,
                "1" to 1, "2" to 2, "3" to 3, "4" to 4, "5" to 5,
                "6" to 6, "7" to 7, "8" to 8, "9" to 9, "a" to 10,
                "b" to 11, "c" to 12, "d" to 13, "e" to 14, "f" to 15)

        var split : List<String> = s.split("")
        var toConvert = mutableListOf<String>()
        split.forEach{x ->
            if (!x.equals("")){toConvert.add(x.toLowerCase())
                if (!valueTable.contains(x.toLowerCase())) {return 0}
            }
        }
        var currentBase = Math.pow(baseValue.toDouble(), toConvert.size.toDouble()-1)
        println(currentBase)

        var decimalTotal : Int = 0

        toConvert.forEach{x ->
            decimalTotal += valueTable.getValue(x)* (currentBase.toInt())
            currentBase/=baseValue
        }

        return decimalTotal
    }
}