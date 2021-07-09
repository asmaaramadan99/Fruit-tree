import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.break

class Bst(implicit ord: Ordering[Fruit]) {
  private var root: Option[Fruit] = None
 var elements: ListBuffer[Fruit] = new ListBuffer[Fruit]
  var flag : Boolean = false



  def insert(node: Fruit): Unit = root match {
    case None => {
      println("root is null");
      root = Some(node)
    }
    case Some(null) => println("error")
    case Some(_) => {
      var currentNode: Fruit = root.get
      var prev: Fruit = null
      while (currentNode != null) {

        node.compare(currentNode).sign match {

          case -1 => {
            {
              prev = currentNode;
              currentNode = currentNode.get_left()
            }
          }
          case 1 => {
            {
              prev = currentNode;
              currentNode = currentNode.get_right()
            }
          }

          case 0 =>

            flag= true
            currentNode=null


        }

      }

      if (flag== true && currentNode==null) return
      if (prev.compare(node) < 0) {
        prev.set_right(node)
      }
      else if (prev.compare(node) > 0) {
        prev.set_left(node)
      }
    }

  }

  def get_root(): Option[Fruit] = {
    root
  }
  def getHeaviest(fruit: Option[Fruit],fruitPrev: Option[Fruit]): Fruit = fruit match {
    case Some(null) => fruitPrev.get
    case _ => {
      getHeaviest(Some(fruit.get.get_right()), Some(fruit.get))
    }
  }
  def getLightest(fruit: Option[Fruit],fruitPrev: Option[Fruit]): Fruit = fruit match {
    case Some(null) => fruitPrev.get
    case _ => {
      getLightest(Some(fruit.get.get_left()), Some(fruit.get))
    }
  }

  def findSuccessor(fruit: Fruit) : Fruit ={
    val leftNode: Option[Fruit] = Some(fruit.get_right())
    if( leftNode.get==null) return null
     getLightest(leftNode,null)

  }
  def delete(node : Fruit):Unit={
    var current : Option[Fruit] = root
    var prev : Option[Fruit] = null
    if(current == null){
      return
    }
    while(current != null && node.compare(current.get)!=0){
      prev = current
      node.compare(current.get).sign match{
        case -1 => current = Some(current.get.get_left())
        case 1 => current = Some(current.get.get_right())
      }
    }
    if(current==null){
      return
    }
    if(current.get.get_left() ==null && current.get.get_right()==null){
      if(prev==null){
        root = null
        return
      }
      if(prev.get.get_left()==current){
        var f: Fruit = prev.get.get_left()
        f= null
      }
    }else if(current.get.get_left() == null || current.get.get_right()==null){
      var newCurrent : Option[Fruit] = null
      if(current.get.get_left() == null){
        newCurrent = Some(current.get.get_right())
      }else{
        newCurrent = Some(current.get.get_left())
      }
      if(prev==null){
        root = newCurrent
        return
      }
      if(prev.get.get_left() == current){
        var f: Fruit = prev.get.get_left()
        f= current.get
      }else{
        var f: Fruit = prev.get.get_right()
        f= current.get
      }
    }else{
      var successor : Option[Fruit] = Some(findSuccessor(current.get))
      delete(successor.get)
      if(prev==null){
        root = successor
      }else{
        if(prev.get.get_right() == current){
          var f: Fruit = prev.get.get_right()
          f= successor.get
        }else{
          var f: Fruit = prev.get.get_left()
          f= successor.get
        }
      }
      var f : Fruit = successor.get.get_left()
      var t : Fruit= current.get.get_left()
      f=t
      if(current.get.get_right()!=successor){
        var f : Fruit = successor.get.get_right()
        var t : Fruit= current.get.get_right()
        f=t
      }
    }
    var f : Fruit= current.get.get_right()
    var t : Fruit= current.get.get_left()
    if(prev.get.get_left().get_weight().compare(node.get_weight())==0)
      {
        prev.get.set_left(null)
      }
    else {
      prev.get.set_right(null)
    }
    f = null
    t= null
  }



  def traverse(fruit: Option[Fruit]): Unit = fruit match {
    case Some(null) =>  return;
    case _ => {
      traverse(Some(fruit.get.get_left()))
      elements+=fruit.get
      traverse(Some(fruit.get.get_right()))
    }
  }


}