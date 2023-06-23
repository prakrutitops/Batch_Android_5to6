import java.io.FileOutputStream

//FileOutputStream - write
//FileInputStream - read
fun main()
{
   println("Enter Name:")
   var name = readLine().toString()

    println("Enter Surname:")
    var surname = readLine().toString()

    println("Enter email:")
    var email = readLine().toString()

    var file = FileOutputStream("E://data.txt")

    var name1="\n Your Name is:"
    var surname1="\n Your Surname is:"
    var email1="\n Your Email is:"

    file.write(name1.toByteArray())
    file.write(name.toByteArray())
    file.write(surname1.toByteArray())
    file.write(surname.toByteArray())
    file.write(email1.toByteArray())
    file.write(email.toByteArray())

    println("Success")
}