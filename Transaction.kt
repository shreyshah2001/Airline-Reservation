import java.io.File

class Transaction {

    fun displayOptions(file: File): Float {
        var opt = 0
        var miles = 0f
        println("Razor Pay")
        println("0. Credit Card")
        println("1. Debit Card")
        opt = readln().toInt()
        when (opt) {
            0 -> miles = cardDetails(file)
            1-> miles = cardDetails(file)
            else -> println("Error")
        }
        return miles
    }
    fun cardDetails(file: File): Float {
        var accID = 0
        var cardID = 0
        println("-------Credit Card Payment--------")
        file.appendText("\n-------Credit Card Payment--------")

        println("Enter account ID: ")
        accID = readln().toInt()

        println("Enter card ID: ")
        cardID = readln().toInt()
        println("Transaction Successful!")
        file.appendText("\nPayment received from Account ID: ${accID}")

        return 0.4f
    }


}