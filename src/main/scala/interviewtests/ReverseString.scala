package interviewtests
import scala.collection.immutable

object ReverseString extends App {
  def reverseOne(s: String) = {
    s.reverse
  }

  def reverseTwo(s: String) = {
    s.toCharArray.reverseMap(c => c).mkString("")
  }

  def reverseThree(s: String) = {
    val reversedChars: immutable.Seq[Char] = {
      for(i <- s.length-1 to 0 by -1)
        yield s.charAt(i)
    }
    reversedChars.mkString("")
  }

  println(reverseOne("abc"))
  println(reverseTwo("abc"))
  println(reverseThree("abc"))
}
