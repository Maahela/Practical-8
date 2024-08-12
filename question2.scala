object NumberCategorizer {

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Please provide a single integer as input.")
    } else {
      val input = args(0).toInt


      val isMultipleOfThree = (n: Int) => n % 3 == 0
      val isMultipleOfFive = (n: Int) => n % 5 == 0

      val result = (isMultipleOfThree(input), isMultipleOfFive(input)) match {
        case (true, true) => "Multiple of Both Three and Five"
        case (true, false) => "Multiple of Three"
        case (false, true) => "Multiple of Five"
        case (false, false) => "Not a Multiple of Three or Five"
      }


      println(result)
    }
  }
}
