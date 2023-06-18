class MyFirstClass2
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}
//infix function
infix fun MyFirstClass2.isScholar(marks: Int):Boolean
{
    return marks>95
}
fun main()
{
    var m = MyFirstClass2()
    println(m.hasPassed(96))
    println(m.isScholar(96))
}