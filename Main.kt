import Airlines.objbook

fun main() {
    var b = Booking()
    var c = Cancellation()
    var flag = true
    var i: Int = -1
    do{
        Booking.welcome()
        println("Menu: \n1. Book tickets \n2. Status of tickets \n3. Cancel Tickets \n4. Done")
        var opt = readln().toInt()
        when(opt) {
            1 -> b.enterSelection()
            2-> println(objbook[i])
            3-> {
                Cancellation.tnc()
                c.cancelOption()
            }
            4-> flag = false
        }
        i++
    }while (flag)


}