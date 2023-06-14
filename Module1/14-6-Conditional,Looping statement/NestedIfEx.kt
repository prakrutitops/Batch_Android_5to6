fun main()
{

    var age = 16

    if(age>=18)
    {
        println("Eligible to vote")

        //nested if
        if(age>=50)
        {
            println("senior citizen category")
        }
        else
        {
            println("young age")
        }
    }
    else
    {
        println("Not Eligible to vote")
    }

}