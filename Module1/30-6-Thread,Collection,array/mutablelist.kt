fun main()
{
    var l1 = mutableListOf(1,2,"a","b")
    /*var l1 = mutablelistOf<String>(1,2,"a","b")*/
    println(l1)

    l1.add("3")
    l1.add(2,"4")

    println(l1)

}