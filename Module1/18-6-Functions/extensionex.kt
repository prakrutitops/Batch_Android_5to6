class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}
//extension function
fun MyFirstClass.isScholar(marks: Int):Boolean
{
    return marks>95
}
fun main()
{
    var m = MyFirstClass()
    println(m.hasPassed(96))
    println(m.isScholar(96))
}