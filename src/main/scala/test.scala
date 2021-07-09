
object test {
  def main(args: Array[String]): Unit = {
    var bst : Bst = new Bst()
    var w: Fruit = new Grape()
    w.set_weight(50)
    bst.insert(w)
    var t: Fruit = new Blackberry()
    t.set_weight(60)
    bst.insert(t)

    var x: Fruit = new Grape()
    x.set_weight(30)
    bst.insert(x)

    var q: Fruit = new Grape()
    q.set_weight(40)
    bst.insert(q)

    var c: Fruit = new Grape()
    c.set_weight(10)
    bst.insert(c)

    var s: Fruit = new Berry()
    s.set_weight(70)
    bst.insert(s)

    var m : Fruit = new Strawberry()
    m.set_weight(5)
    bst.insert(m)

    var z: Fruit = new Blackberry()
    z.set_weight(80)
    bst.insert(z)


    var f : Fruit = new Apple()
    f.set_weight(60)
    bst.insert(f)

    var o : Fruit = new Apple()
    o.set_weight(30)
    bst.insert(o)




    bst.traverse(bst.get_root())
    var tree : FruitTree = new FruitTree()
    tree.bst= bst
    tree.iterate()
    var k = bst.getHeaviest(bst.get_root(),null)
    var l = bst.getLightest(bst.get_root(),null)
    println( " heaviest is " + k.get_weight() +k.getClass.getSimpleName)
    println( " Lightest is " + l.get_weight())
    //tree.magnifyByType(classOf[Apple],10)
    tree.bst.delete(x)

    tree.iterate()
    //tree.iterate()
   /*  tree.filterByWeight(12)
    println(tree.filter(classOf[Apple]).foreach(f => println(f.get_weight())))
    println(bst.findSuccessor(f).get_weight())*/

  }
}