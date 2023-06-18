fun detail(name:String,surname:String,email:String)
{
    println("Your name is $name , Your Surname is $surname , Your Email is $email")
}

fun main()
{

    detail("xyz","sahil","sahil@gmail.com")
    detail("vandit","xyz","vandit@gmail.com")
    detail(surname = "vyas", email = "prakruti@gmail.com", name = "prakruti")//named function

}