package coderwars


import models.Node
import org.scalatest.{FlatSpec, Matchers}

/*

   Find if two nodes in a directed graph are connected.
   Based on http://www.codewars.com/kata/53897d3187c26d42ac00040d
   For example:
   a -+-> b -> c -> e
      |
      +-> d
   run(a, a) == true
   run(a, b) == true
   run(a, c) == true
   run(b, d) == false

   case class models.Node(value: Int, edges: List[models.Node] = List.empty)

 */

class GraphNodeSpec extends FlatSpec with Matchers {

  val aNodeEmpty = Node(0)
  val bNode = Node(1)
  val cNode = Node(2)
  val dNode = Node(3)
  val aNodeWithBChild = Node(0,List(bNode))
  val aNodeWithBDChild = Node(0,List(bNode,dNode))

  "The run function" should "return true if the same node supplied twice for both parameters" in {
    GraphNode.run(aNodeEmpty,aNodeEmpty) shouldBe true
  }

  it should "find an edge if one exists" in {
    GraphNode.run(aNodeWithBChild,bNode) shouldBe true
  }

  it should "find an edge if it's not the first child" in {
    GraphNode.run(aNodeWithBDChild,dNode) shouldBe true
  }
}
