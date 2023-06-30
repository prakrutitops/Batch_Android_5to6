fun main()
{

    var a = ArrayList<String>()

    a.add("a")
    a.add("b")

    var a2 = ArrayList<String>()

    a2.add("c")
    a2.add("d")
    a2.add("a")

 /*   a.addAll(a2)
    a.remove("c")
    //a.removeAt()
    a.removeAll(a2)*/
    a.retainAll(a2)

    println(a)

    var i:Iterator<String> = a.iterator()

    while (i.hasNext())
    {
        println(i.next())
    }

}