object UglyCodeExample extends App {
    def m(stringToTransform: String): String = {
        def t(string: String): List[String] = {
        def th(string: String, si: Int): List[String] = {
        if (si == 0) Nil
        else {
        val (firstString, secondString) = string.splitAt(si); val newString = secondString + firstString
        newString :: th(string, si - 1)}}
        th(string, string.length)
        }
        val list: List[String] = t(stringToTransform); val sortedList = list.sortWith((x, y) => { x <= y }); val lastColumn = sortedList.map(row => row.last).mkString
        lastColumn
    }
    println(m("^BANANA|"))
}