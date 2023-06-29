class MyFirstClass1
{
    fun addTwoNum(a: Int , b : Int,tops:(Int) -> Unit)
    {
        val sum = a+b
        tops(sum)
    }
}

fun main()
{
    var m = MyFirstClass1()

    //lambda expression
    val myLambda : (Int) -> Unit={a : Int ->println(a)}

    m.addTwoNum(6,5,myLambda)
}