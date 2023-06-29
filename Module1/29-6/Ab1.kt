abstract  class MyBank
{
    abstract fun bankdetail()
}

class D : MyBank()
{
    override fun bankdetail() {
        print("bank")
    }

}
fun main()
{
    var d = D()

    d.bankdetail()
}