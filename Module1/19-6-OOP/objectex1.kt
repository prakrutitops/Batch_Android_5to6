class Student
{
    var id=0
    var name =""
}


fun main()
{
    //var objname = classname()

    //object 1
    var s1 = Student()
    //object 2
    var s2 = Student()


    s1.id = 101
    s1.name="sahil"

    s2.id=102
    s2.name="vandit"

    println("${s1.id} and ${s1.name}")
    println("${s2.id} and ${s2.name}")



}