data class User (var name : String, var id : Int)
{

}
fun main()
{
    var user1 = User("kot",10)
    var user2 =User("kot",10)

    println(user1)
    println(user2.toString())

    if(user1 == user2)
    {
        println("Equal")
    }
    else
    {
        println("not equal")
//this will executes If we not write data keyword coz we compares object.
//So we can use data key word to compare values not object.
    }

    var user3 = user1.copy()
    println(user3)
}