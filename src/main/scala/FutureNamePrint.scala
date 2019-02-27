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

  fTomName.onComplete{
    case Success(name) => println("completed: "+name)
    case Failure(t) => println("error when getting name:"+t.getLocalizedMessage)
  }
  fDickName.onComplete{
    case Success(name) => println("completed: "+name)
    case Failure(t) => println("error when getting name:"+t.getLocalizedMessage)
  }
  fHarryName.onComplete{
    case Success(name) => println("completed: "+name)
    case Failure(t) => println("error when getting name:"+t.getLocalizedMessage)
  }

  fTomName foreach {
    name => println(s"for loop: $name")
  }

  private val eventualString: Future[String] = for {
    t <- fTomName
  } yield t
  eventualString

}
