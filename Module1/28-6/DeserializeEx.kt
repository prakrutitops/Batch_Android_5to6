import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var in1 = ObjectInputStream(FileInputStream("E://a.txt"))
    var s:Student8 = in1.readObject() as Student8

    println("${s.id} and ${s.name}")


}