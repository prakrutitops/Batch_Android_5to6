//with para with return type

fun a1(a:Int,b:Int):Int
{
    return  a+b
}

//with para without return type
fun a2(a:Int,b:Int)
{
    var c=a+b
    println(c)
}

//with return type without para
fun a3():Int
{
    var a=5
    var b=6
    var c=a+b
    return c
}
//without para without return type
fun a4()
{
    var a=5
    var b=6
    var c=a+b
    println(c)
}


fun main()
{

    println(a1(5,6))
    a2(6,6)
    println(a3())
    a4()
}