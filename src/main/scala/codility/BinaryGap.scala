package codility

object BinaryGap extends App {

  def binaryGapIter(number: Int) = {
    val binaryString = number.toBinaryString
    var current = 0;
    var largest = 0;
    binaryString.foreach { c =>
      if(c.equals('1')){
        largest = if(current>largest) current else largest
        current = 0
      } else {
        current = current+1
      }
    }
    largest
  }

  def binaryGapRegex(number: Int) = {
    val binaryString = number.toBinaryString
    val regex = "(1?)(0+)[1]".r
    regex.findAllMatchIn(binaryString)
      .map(_.toString().replaceAll("1","").length)
      .max
  }

  println(s"binaryGapIter(10410) ${binaryGapIter(10410)}")
  println(s"binaryGapRegex(10410) ${binaryGapRegex(10410)}")

}
