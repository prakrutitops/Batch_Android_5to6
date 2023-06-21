//parent
open class Bank
{
    fun bank()
    {
        println("banking")
    }
}
//child -1

class Current :Bank()
{
    fun current()
    {
        println("current")
    }
}
//child -2
class Save :Bank()
{
    fun save()
    {
        println("saving")
    }
}

fun main()
{
    var c1 = Current()
    var s1 = Save()

    c1.current()
    s1.save()
    c1.bank()


}