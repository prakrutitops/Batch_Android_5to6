import java.io.FileReader
import java.io.IOException


fun main()
{
    var f1 = FileReader("E:\\file2.txt")

    var ch:String=""
    var data:Int = ch.length
    for(i in 1..data)
    {
        ch = f1.readText()
        println(ch)
    }


    f1.close()

}