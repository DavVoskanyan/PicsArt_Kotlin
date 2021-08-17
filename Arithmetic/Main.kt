//P31-P41
fun main() {
    printGoldbachListLimited(2..3000, 50)
}


//P31
fun Int.isPrime(): Boolean {
    var i = 2
    while(i < this) {
        if(this % i == 0) return false
        i++
    }
    return true
}
//P32
fun gcd(num1: Int, num2: Int): Int {
    if(num1 == num2) return num1
    var num: Int;
    var dif: Int;
    var saver: Int;
    num = if(num1 - num2 < 0)  num1   else num2
    dif = Math.abs(num2 - num1)
    while(dif != num) {
        saver = dif
        dif = num - dif
        num = dif
    }
    return dif
}
//P33
fun Int.coPrime(num: Int): Boolean {
    val small = if(this > num) num  else  this
    var i = 2;
    while(i <= small) {
        if(this % i == 0 && num % i == 0) return false
        i++
    }
    return true
}
//P34
fun Int.totient(): Int {
    var counter = 0
    var i = 2;
    while(i <= this) {
        if(this.coPrime(i)) counter++
        i++
    }
    return counter
}
//P35
fun Int.primeFactors(): MutableList<Int> {
    var num = this
    var list: MutableList<Int> = mutableListOf<Int>()
    var i: Int = 2
    while(num != 1) {
        while(i <= num) {
            if(i.isPrime() && num % i == 0) {
                list.add(i)
                num /= i;
            }
            if(num % i != 0) {
                i++
            }
        }
        i = 0
    }
    return list
}
//P36
fun Int.primeFactorMultiplicity(): List<Pair<Int, Int>> =
    this.primeFactors()
    .groupBy { it }
    .map { Pair(it.key, it.value.size) }
//P39
fun listPrimesInRange(nums: IntRange): MutableList<Int> {
    var list: MutableList<Int> = mutableListOf()
    for(i: Int in nums) {
        if(i.isPrime()) list.add(i)
    }
    return list
}
//P40
fun Int.goldbach(): Pair<Int, Int>{
    var i: Int = 2;
    if(this % 2 == 0) {
        while(i < this) {
            if(i.isPrime() && (this - i).isPrime()) break
            i++
        }
    }
    else return Pair(0, 0)
    return Pair(i, this - i)
}
//P41
fun printGoldbachList(nums: IntRange): Unit {
    var gbPair: Pair<Int, Int>
    for(num: Int in nums) {
        if(num % 2 == 0) {
            gbPair = num.goldbach()
            println("$num = ${gbPair.first} + ${gbPair.second}")
        }
    }
}
fun printGoldbachListLimited(nums: IntRange, minVal: Int): Unit {
    var gbPair: Pair<Int, Int>
    for(num: Int in nums) {
        if(num % 2 == 0) {
            gbPair = num.goldbach()
            if(gbPair.first >= minVal && gbPair.second >= minVal) println("$num = ${gbPair.first} + ${gbPair.second}")
        }
    }
}