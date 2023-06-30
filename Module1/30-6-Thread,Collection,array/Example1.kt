class P1 : Thread()
{
    override fun run()
    {
        //super.run()
        for(i in 1..10)
        {
            println("Thread P: $i")
        }
    }
}
class Q1 : Thread()
{
    override fun run() {
        //super.run()
        for(i in 1..10)
        {
            println("Thread Q: $i")
        }
    }

}

fun main()
{
    var a = P1()
    var b = Q1()

    a.start()
    b.start()
}