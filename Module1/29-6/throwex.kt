import java.lang.ArithmeticException

class AgeCheck
{

    fun check(age:Int)
    {
        if(age>=18)
        {
            println("Eligible to vote")
        }
        else
        {
            throw Exception("Age is not valid")
        }
    }


}
fun main()
{
    var a = AgeCheck()
    a.check(15)
}