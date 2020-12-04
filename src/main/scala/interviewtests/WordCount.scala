package interviewtests

object WordCount extends App {

  def countWords(file: String) = {
    file.split("\\W+").length
  }

  println(countWords("Hello world! My name is Jon!"))

}
