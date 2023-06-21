interface Print
{
    fun print()
    {
        println("printing")
    }
}
interface   Show
{
    fun show()
    {
        println("showing")
    }
}

class Op : Print,Show
{

}
fun main()
{
    var op1 = Op()
    op1.print()
    op1.show()
}