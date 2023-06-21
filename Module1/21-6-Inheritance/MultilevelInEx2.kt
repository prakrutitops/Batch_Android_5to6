open class P
{
    fun p1()
    {
        println("P1 Accessed")
    }
}
open class Q : P()
{
    fun q1()
    {
        println("Q1 Accessed")
    }
}
class R :Q()
{
    fun r1()
    {
        println("R1 Accessed")
    }
}

fun main()
{
    var r = R()

    r.p1()
    r.q1()
    r.r1()

}