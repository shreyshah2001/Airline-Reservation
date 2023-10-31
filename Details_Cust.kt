class Details_Cust {
    var n = Name()
    var a = Address()


    fun details() {
        println("-------Customer Details--------");
        println("\t Personal");
        println("First Name:");
        n.fName = readln();
        println("Middle Name:");
        n.mName = readln();
        println("Last Name:");
        n.lName = readln();
        println("Phone Number:");
        n.phoneNum = readln().toInt();
        println("Email ID: ");
        n.emailID = readln();
        println("\t Address");
        println("Locality: ");
        a.locality = readln();
        println("City: ");
        a.city = readln();
        println("State: ");
        a.state = readln();
        println("PinCode: ");
        a.pinCode = Integer.valueOf(readln());

    }

}