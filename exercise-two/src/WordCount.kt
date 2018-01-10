object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        var result = HashMap<String, Int>()
        var cleanPhrase = cleanUp(phrase)
        var theWords: List<String> = (cleanPhrase.split(" ").map{it.trim()})
        theWords = cleanUpQuotations(theWords)
        theWords.forEach{x ->
            if (!result.containsKey(x.toString())){
                result.put(x.toString(),1)
            }
            else{
                result.set(x.toString(), result.getValue(x.toString())+1)
            }
        }
        //println("The words:")
        //theWords.forEach{x -> print(x + "/");}
        // result.forEach{x -> println(x)}
        return result
    }

    fun cleanUp(phrase: String): String{
        var cleanPhrase = phrase.replace("\n"," ")
        cleanPhrase =cleanPhrase.replace(","," ")
        cleanPhrase =cleanPhrase.replace(",\n", " ")
        cleanPhrase =cleanPhrase.replace("!"," ")
        cleanPhrase =cleanPhrase.replace("&"," ")
        cleanPhrase =cleanPhrase.replace("@"," ")
        cleanPhrase = cleanPhrase.replace(":"," ")
        cleanPhrase = cleanPhrase.replace(".","")
        cleanPhrase = cleanPhrase.replace("\$","")
        cleanPhrase = cleanPhrase.replace("%","")
        cleanPhrase = cleanPhrase.replace("^","")
        while (cleanPhrase.contains("  ")){
            cleanPhrase = cleanPhrase.replace("  ", " ")
        }
        cleanPhrase = cleanPhrase.removeSuffix(" ")
        cleanPhrase = cleanPhrase.toLowerCase()

        return cleanPhrase
    }
    fun cleanUpQuotations(theWords: List<String>): List<String>{
        var result = mutableListOf<String>()
        theWords.forEach{x ->
            var currentString = x
            currentString = currentString.removePrefix("'")
            currentString = currentString.removeSuffix("'")
            println(currentString)
            result.add(currentString)
        }
        return result;
    }
}