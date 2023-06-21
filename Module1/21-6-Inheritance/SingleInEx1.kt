open class A
{
    fun a1()
    {
        println("A Accessed")
    }
}
class B : A()
{
    fun b1()
    {
        println("B Accessed")
    }
}
fun main()
{

    var b = B()

    b.a1()//A
    b.b1()//B
}