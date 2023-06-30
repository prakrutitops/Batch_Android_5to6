class Sender
{
    fun send(msg:String)
    {
        println("Sending $msg")



        println("$msg sent")
    }

}

class Threadsend(var sender: Sender,var msg:String) :Thread()
{
    override fun run()
    {
        //super.run()
        synchronized(sender)
        {
            sender.send(msg) 
        }

    }


}
fun main()
{
    var sender = Sender()

    var t1 = Threadsend(sender,"Hii")
    var t2 = Threadsend(sender,"Byee")

    t1.start()
    t2.start()



}