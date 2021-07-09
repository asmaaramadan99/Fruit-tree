class FruitTree {
  var bst: Bst = new Bst()

  def iterate() = {
    bst.elements.clear()
    bst.traverse((bst.get_root()))
    val elements: List[Fruit] = bst.elements.toList
    elements.map(printFormatter)
  }

  def setBst(bst: Bst)=
    {
      this.bst=bst
    }


  def findHeaviest(): Fruit = {
    bst.getHeaviest(bst.get_root(), null)
  }

  def findLightest(): Fruit = {
    bst.getLightest(bst.get_root(), null)
  }

  def filterByWeight(weight: Double) = {
    bst.elements.toList.filter(_.get_weight() > weight).map(printFormatter)
  }
  def filter[T](t:Class[T]) : List[Fruit]=
  {
    bst.elements.toList.filter(f => checkType(t,f))


  }
  def magnifyByType[T](t: Class[T],weight : Double)={
    var elements: List[Fruit] = bst.elements.toList
    val w: Fruit = new Grape()
    w.set_weight(55)

    setBst(new Bst())

    elements.map(fruit => if (checkType(t,fruit)) {fruit.set_weight(fruit.get_weight()+weight); bst.insert(fruit)} else bst.insert(fruit))
    bst.traverse(bst.get_root())


  }

  def printFormatter (fruit : Fruit) ={
    println("My name is " + fruit.getClass.getSimpleName + " and my weight is " + fruit.get_weight() )
  }
  def checkType [T](t:Class[T],fruit: Fruit): Boolean={
    t.isAssignableFrom(fruit.getClass)
  }


}
