open class A1
{
    fun a1()
    {
        println("A1 Accessed")
    }
}
open class B1 :A1()
{
    fun b1()
    {
        println("B1 Accessed")
    }
}
interface  C1
{
    fun c1()
    {
        println("C1 Accessed")
    }
}
class D1 :B1(),C1
{
    fun D1()
    {
        println("D1 Accessed")
    }
}

fun main()
{

    var d1 = D1()
    d1.a1()
    d1.b1()
    d1.c1()
    d1.D1()

}