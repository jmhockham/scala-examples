package coderwars

import models.Node

object GraphNode {

  // see https://stackoverflow.com/questions/40326958/transverse-a-tree-like-object-in-a-tail-recursive-way-in-scala
  // for the tail-rec version
//  @tailrec
  def run(sourceNode: Node, destinationNode: Node, results: Seq[Node] = Seq.empty[Node]): Boolean = {
    val nodesEqual = nodesAreTheSame(sourceNode, destinationNode)
    val hasChildren = sourceNode.edges.nonEmpty
    if (nodesEqual){
      true
    } else if (!nodesEqual && !hasChildren) {
      false
    }
    else {
//      val child = sourceNode.edges.head
//      run(child,destinationNode)
      sourceNode.edges.exists{ child =>
        run(child,destinationNode)
      }
    }
  }

  private def nodesAreTheSame(sourceNode: Node, destinationNode: Node) = {
    sourceNode == destinationNode
  }
}
