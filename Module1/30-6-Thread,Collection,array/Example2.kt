class P11 : Runnable
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
class Q11 : Runnable
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
  var t1 = Thread(P11())
  var t2 = Thread(Q11())

    t1.start()
    t2.start()


}