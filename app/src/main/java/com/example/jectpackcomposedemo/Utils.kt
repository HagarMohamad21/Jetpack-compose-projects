package com.example.jectpackcomposedemo


fun calculateTip(bill:String,tipPercentage:Float):Float{
    if(bill.isNotEmpty()&&bill.toDouble()>1) {
        var billAmount: Float = bill.toFloat()
        return (billAmount*tipPercentage)/100
    }
    else return 0.0f
}


fun calculateTotalPerPerson(bill:String,tip:Float,people:Int):Float{
    if(bill.isNotEmpty()&&bill.toFloat()>1) {
        var billAmount: Float = bill.toFloat()
        return (billAmount+tip)/people
    }
    else return 0.0f

}