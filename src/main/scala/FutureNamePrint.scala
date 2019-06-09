import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureNamePrint extends App {

  import scala.concurrent.ExecutionContext.Implicits.global
  //  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(3))


  val fTomName: Future[String] = Future {
    "Thomas"
  }
  val fDickName: Future[String] = Future {
    "Richard"
  }
  val fHarryName: Future[String] = Future {
    "Harrold"
  }

  val fPrintNumbers: Future[Unit] = Future {
    (1 to 10).foreach(println)
  }

  def printNumbers: Range.Inclusive = 10 to 20

  fTomName.onComplete {
    case Success(name) => println("completed: " + name)
    case Failure(t) => println("error when getting name:" + t.getLocalizedMessage)
  }
  fDickName.onComplete {
    case Success(name) => println("completed: " + name)
    case Failure(t) => println("error when getting name:" + t.getLocalizedMessage)
  }
  fHarryName.onComplete {
    case Success(name) => println("completed: " + name)
    case Failure(t) => println("error when getting name:" + t.getLocalizedMessage)
  }

  fTomName foreach {
    name => println(s"for loop: $name")
  }

  //we don't need the yield keyword after a for loop block (although keeping it probably makes things more readable)
  for (
    n <- printNumbers
  ) println(n)

  for {
    _ <- fPrintNumbers
    _ <- fTomName
    _ <- fDickName
    _ <- fHarryName
  } ()

}
