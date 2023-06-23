open class Bank1
{
    open fun rate():Int
    {
        return 0
    }
}
class Sbi :Bank1()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici:Bank1()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis:Bank1()
{
    override fun rate():Int
    {
        return 9
    }
}
fun main()
{

    var b = Bank1()

    b = Sbi()
    println(b.rate())

    b = Icici()
    println(b.rate())

    b = Axis()
    println(b.rate())

}