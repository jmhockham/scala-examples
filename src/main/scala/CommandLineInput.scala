object CommandLineInput extends App {
//  private val input: String = scala.io.StdIn.readLine()
//  println(s"you entered $input")

  abcTerminates()

  @scala.annotation.tailrec
  def abcTerminates(): Unit = {
    println("enter abc to terminate:")
    val input: String = scala.io.StdIn.readLine()
    if(input!="abc"){
      println(s"you entered $input")
      abcTerminates()
    }
    else{
      println("terminating")
    }
  }
}
