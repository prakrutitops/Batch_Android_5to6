fun main()
{
    println("Enter Your Number")
    var num = readLine()!!.toInt()



    var i =2
    var flag=0
    while(i<=num/2)
    {
        //println(i)
        if(num%i == 0)
        {
            println("\n Not a PRIME NUMBER");
            flag=1
            break;
        }

        i++
    }
    if(flag==0)
    {
        println("\n PRIME NUMBER");
    }

}