import java.io.FileOutputStream

//FileOutputStream - write
//FileInputStream - read
fun main()
{
    var data = "Welcome to Tops"
    var fout = FileOutputStream("E://sahil.txt")
    fout.write(data.toByteArray())
    println("Success")

}