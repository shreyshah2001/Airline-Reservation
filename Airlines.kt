import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Airlines {
    var objbook = mutableListOf<Details>()
    var retFlightNum: Int = 0
    var numOfPeople = 0f
    var bookingCost = 0f
    var flightNum = 0
    var dateInput = ""
    var bookingID:String = ""
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var timings = arrayListOf<String>("6:00", "14:00")
    val texasFlights = listOf<String>("Air India", "Jet Airways")
    val texasFlightPrice = listOf<Float>(1500f,4800f)

    val parisFlights = listOf<String>("EU Airways", "Jet France", "Fly Paris")
    val parisFlightPrice = listOf<Float>(3000f,1000f,2500f)

    val blrFlights = listOf<String>("Blr Air", "India Airways", "Fly India")
    val blrFlightPrice = listOf<Float>(1000f,5000f,7200f)

    fun displayMenu(dest: String): Float {
        var date: LocalDate

        println("Number of People:")
        numOfPeople = readln().toFloat()
        println("Date (dd-MM-yyyy):")
        dateInput = readln()
        date = LocalDate.parse(dateInput, formatter)


        if (dest == "Tex" ||dest == "tex"){
            println("--------Airlines---------")
            for(i in (texasFlights.indices)) {
                println("$i - Departure: ${timings[i]} ${texasFlights[i]} Price: ${texasFlightPrice[i]} ")
            }
            println("Select your preferred flight: ")
            flightNum = readln().toInt()
            bookingCost = texasFlightPrice[flightNum]
            bookingID = "t${(1012..9032).random()}"
            objbook.add(Details(bookingID, texasFlights[flightNum], timings[flightNum], bookingCost, date, null, numOfPeople, null, null, null))

        }
        else if (dest == "par"){
            println("--------Airlines---------")
            for(i in (parisFlights.indices)) {
                println("$i - Departure: ${timings[i]} ${parisFlights[i]} ${parisFlightPrice[i]}")
            }
            println("Select your preferred flight: ")
            flightNum = readln().toInt()
            bookingCost = parisFlightPrice[flightNum]
            bookingID = "p${(1012..9032).random()}"

            objbook.add(Details(bookingID, parisFlights[flightNum], timings[flightNum], bookingCost, date,null, numOfPeople,  null, null, null))

        }
        else {
            throw ErrorException("Invalid Destination")
        }
        return (bookingCost*numOfPeople);
    }

    fun displayMenuReturn(dest: String): Float {
        var date: LocalDate
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var returnPrice = 0f

        println("Number of People:")
        numOfPeople = readln().toFloat()
        println("Date (dd-MM-yyyy): ")
        dateInput = readln()
        date = LocalDate.parse(dateInput, formatter)
        println("Return Date (dd-MM-yyyy): ")
        var retDateInput = readln()
        var retDate = LocalDate.parse(retDateInput, formatter)

        if (dest == "tex"){
            println("--------Airlines---------")
            for(i in (texasFlights.indices)) {
                println("$i - Departure: ${timings[i]} ${texasFlights[i]} Price: ${texasFlightPrice[i]}")
            }
            println("Select your preferred flight: ")
            flightNum = readln().toInt()
            bookingCost = texasFlightPrice[flightNum]
            retFlightNum = returnFlight()

            bookingID = "t${(1012..9032).random()}"
            objbook.add(Details(bookingID, texasFlights[flightNum], timings[flightNum], (bookingCost+returnPrice), date, retDate, numOfPeople,  blrFlights[retFlightNum], timings[retFlightNum], blrFlightPrice[retFlightNum]))

        }
        else if (dest == "par"){
            println("--------Airlines---------")
            for(i in (parisFlights.indices)) {
                println("$i - Departure: ${timings[i]} ${parisFlights[i]} ${parisFlightPrice[i]}")
            }
            println("Select your preferred flight: ")
            flightNum = readln().toInt()
            bookingCost = parisFlightPrice[flightNum]
            bookingID = "p${(1012..9032).random()}"
            retFlightNum = returnFlight()

            objbook.add(Details(bookingID, parisFlights[flightNum], timings[flightNum], (bookingCost+returnPrice), date,retDate, numOfPeople,  blrFlights[retFlightNum], timings[retFlightNum], blrFlightPrice[retFlightNum]))

        }
        else {
            throw ErrorException("Invalid Destination")
        }
        return (numOfPeople*(bookingCost+returnPrice));
    }

    fun returnFlight(): Int {
        println("--------Return Airlines---------")
        for(i in (blrFlights.indices)) {
            println("$i - Departure: ${timings[i]} ${blrFlights[i]} ${blrFlightPrice[i]}")
        }
        println("Select your preferred flight: ")
        retFlightNum = readln().toInt()
        return retFlightNum
    }

}
