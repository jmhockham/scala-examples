package interviewtests

// shamelessly stolen from https://www.geeksforgeeks.org/scala-sieve-of-eratosthenes/
// this is a brute-force version of the sieve, not the more elegant/longer version found in PrimeSieve
object EratosthenesSieve extends App {

  def primeSieve(stream: Stream[Int]): Stream[Int] = {
    stream.head #:: primeSieve(
      stream.tail.filter(int => int % stream.head != 0)
    )
  }

  private val intsStream: Stream[Int] = Stream.from(2)

  println(primeSieve(intsStream).take(10).toList.mkString(", "))

}
