class Tops2
{
    //secondary constructor
    constructor(id:Int)
    {
        println("Your id is $id")
    }
    constructor(id:Int,name:String)
    {
        println("Your id is $id")
        println("Your name is $name")
    }
    constructor(id:Int,name:String,email:String)
    {
        println("Your id is $id")
        println("Your name is $name")
        println("Your Email is $email")
    }


}
fun main()
{
    var t1 = Tops2(101)
    var t2 = Tops2(101,"prakruti","prakruti@gmail.com")

}