object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>>{
        if (rows < 0) {throw IllegalArgumentException("Rows can't be negative!")}

        var result : MutableList<List<Int>> = mutableListOf<List<Int>>()
        for (x in 1..rows){
            // create the row, fill it with 1s, and add to structure
            var thisRow : MutableList<Int> = mutableListOf<Int>()
            for (y in 1..x){
                thisRow.add(1)
            }
            // if it's not the first row, iterate through it and alter any values that are not the first or last
            if (x > 1){
                for (z in 1..thisRow.size-2){
                    // find the row above and index to left and index to right
                    var addition1 : Int = result.get(x-2).get(z-1)
                    var addition2 : Int = result.get(x-2).get(z)
                    thisRow.set(z,addition1+addition2)
                }
            }
            result.add(thisRow)
        }
        println(result)

        return result
    }
}