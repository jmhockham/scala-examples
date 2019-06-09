object CaseClassExamples extends App {

  case class Person (
    name: String,
    age: Double,
    employed: Boolean,
    alias: Option[String] = None
  )

  val people = Seq(
    Person("Tom",21,true),
    Person("Richard",25,false,Some("Dick")),
    Person("Harry",30,true)
  )

  def getEmployedPeople = {
    people.filter(_.employed).map(_.name)
  }

  def getPreferredNamesCollect = {
    people collect {
      case Person(_,_,_,Some(alias)) => alias
      case p:Person => p.name
    }
  }

  def getPreferredNamesGOE = {
    people map(p => p.alias.getOrElse(p.name))
  }

  def getAliases = {
    people.filter(_.alias.nonEmpty).map(_.alias.get)
  }

  println(s"getEmployedPeople: ${getEmployedPeople.mkString(",")}")
  println(s"getPreferredNamesCollect: ${getPreferredNamesCollect.mkString(",")}")
  println(s"getPreferredNamesGOE: ${getPreferredNamesGOE.mkString(",")}")
  println(s"getAliases: ${getAliases.mkString(",")}")

}


