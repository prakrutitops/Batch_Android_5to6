class OverloadinEx1
{
    fun cal(a:Int,b:Int):Int
    {
        return a+b
    }
    fun cal(a:Double,b:Double):Double
    {
        return a*b
    }

}

fun main()
{
    var o1 = OverloadinEx1()
    println(o1.cal(5,6))
    println(o1.cal(5.00,6.00))
}