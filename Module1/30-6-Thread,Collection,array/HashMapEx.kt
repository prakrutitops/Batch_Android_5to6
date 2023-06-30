fun main()
{
    var m = HashMap<String,Int>()

    m.put("a",1)
    m.put("b",2)


    for(i in m.entries)
    {
        print(i)
    }
}