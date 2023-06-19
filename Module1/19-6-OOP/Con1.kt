//primary constructor
class Tops(var id:Int,var name:String)
{
    fun display()
    {
        println("Your id is $id , Your Name is $name")
    }
}

fun main()
{
    var t1 = Tops(101,"sahil")
    var t2 = Tops(102,"vandit")

    t1.display()
    t2.display()
}