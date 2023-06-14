fun main()
{
    println("Enter Your Name")
    var name = readLine()

    println("Enter Your Number")
    var num = readLine()!!.toBigInteger()

    println("Enter Your Email")
    var email = readLine()

    println("Enter Your Password")
    var pass = readLine()


    //num="57834574"
    println("\n Your Name is $name, \n Your Number is $num , \n Your Email is $email")

    if(email.equals("vandit@gmail.com") && pass.equals("1234"))
    {
        println("Logged in succesfully")
    }
    else
    {
        println("Error")
    }

}