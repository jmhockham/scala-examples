import OptionExamples.diffOptn

object OptionExamples extends App {

  val optionStr = Some("test")

  // if/else, returning nothing
  optionStr.map( s => {
    println(s"have a value: $s; length: ${s.length}")
  }).orElse({
    println("don't have a value")
    None
  })

  // if/else, returning something
  val diffOptn: Option[String] = optionStr.map( s => {
    val len = s.length
    println(s"have a value: $s; length: $len")
    "primary value"
  }).orElse({
    println("don't have a value")
    Some("backup thing")
  })

  diffOptn.foreach(println(_))

  optionStr match {
    case Some(_) => println(s"options has value: ${_}")
    case _ => println("nothing")
  }

}
