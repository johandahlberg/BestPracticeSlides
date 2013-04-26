object BetterCodeExample extends App {
 
    /**
     * Burrows-Wheeler transform of string
     * 
     * Perform the Burrows-Wheeler transform on a string. See http://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform
     * for a introduction to the algorithm.
     * 
     * This particular implementation is recursive.
     * 
     * @param stringToTransform the string to transform
     * @return the burrows wheeler transform of the input string.
     */
    def burrowsWheelersTransform(stringToTransform: String): String = {
        
        require(!stringToTransform.isEmpty(), "You are trying to transform an empty string!")
 
        // Carries out the transformation on the string.
        def tranformString(string: String): List[String] = {
 
            // The helper functions creates a list of string until it has iterated
            // over the full length of the string.
            def transformStringHelper(string: String, splitIndex: Int): List[String] = {
                
                require(splitIndex >= 0)
                
                if (splitIndex == 0)
                    Nil
                else {
                    val (firstString, secondString) = string.splitAt(splitIndex)
                    val newString = secondString + firstString
                    newString :: transformStringHelper(string, splitIndex - 1)
                }
            }
 
            transformStringHelper(string, string.length)
        }
 
        // Create a list of the transformed strings
        // Each string can be views as a row in a table.
        val list: List[String] = tranformString(stringToTransform);
        
        // Sort them the rows alphabetically
        val sortedList = list.sortWith((x, y) => { x <= y })
        
        // Get the last column of the table. 
        val lastColumn = sortedList.map(row => row.last).mkString        
        lastColumn
    }
 
    println(burrowsWheelersTransform("^BANANA|"))
}