class Account
{
    companion object //static //used old memory
    {
        var count =0
    }
    constructor(id:Int,name:String)
    {
        count++
        println("Number of Account is $count")
    }

}
fun main()
{
    var a1 = Account(101,"prakruti")
    var a2 = Account(102,"Vivek")
    var a3 = Account(102,"Vivek")
    var a4 = Account(102,"Vivek")


}