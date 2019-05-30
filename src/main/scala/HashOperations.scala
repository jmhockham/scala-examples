import scala.collection.mutable

object HashOperations extends App{
  val hm = new mutable.HashMap[Int,String]()
  hm.put(1,"test")
  hm.put(1,"test2")
  println(hm.mkString(";"))
  println(hm.values.mkString(";"))
  println(hm.keys.mkString(";"))

  val key = 1.hashCode()
}
