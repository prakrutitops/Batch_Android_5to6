import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{
    var s1 = Student8(101,"tops")
    var fout = FileOutputStream("E://a.txt")
    var out = ObjectOutputStream(fout)
    out.writeObject(s1)

    println("success")
}