sealed class Animal
{
    fun eat()
    {
        println("eating")
    }

    data class dog(val n: Int) : Animal()
    {
        fun bark()
        {
            println("barking")
        }
    }
    data class cat(val n1 : Int , val n2 :Int) :Animal()
    {
        fun meow()
        {
            println("meow")
        }
    }
}
fun main()
{
    var n =Animal.dog(10)
    n.eat()

    Animal.dog(10).bark()
    Animal.cat(10,20).meow()
}