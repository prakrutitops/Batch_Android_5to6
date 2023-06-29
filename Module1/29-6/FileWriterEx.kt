import java.io.DataInputStream
import java.io.FileWriter

fun main()
{

    //user input
    var dis: DataInputStream = DataInputStream(System.`in`)

    //var data = readLine()
    var fw: FileWriter = FileWriter("E:\\file2.txt")
    var ch: Char
    println("Enter String($ to end) : ")
    do
    {
        ch=dis.read().toChar()

        if(ch=='$')
        {
            break
        }

        fw.write(ch.toInt())
    }

    while (true)
    fw.close()
}