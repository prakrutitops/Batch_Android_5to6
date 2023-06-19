import Students.Companion.change

class Students(var id:Int, var name:String)
{
    //secondary constuctor will access all parameters as a val
   /* constructor(val)
    {

    }*/
    companion object
    {
        var college:String="Marwadi"

        fun change()
        {
            college="Atmiya"
        }
    }

    fun display()
    {
        println("Your id is $id , Your Name is $name , Your College name is $college")
    }



}

fun main()
{
    //var a1 = O1()
    change()
    var s1 = Students(101,"sahil")
    var s2= Students(102,"Vandit")

    s1.display()
    s2.display()
}