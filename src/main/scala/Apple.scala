class Apple extends Fruit with OvalShapedFruit {
  override protected var weight: Double = _
  override protected var left: Fruit = _
  override protected var right: Fruit = _
  override def getMyShape(`fruitName`: Option[String]): String = "I am an oval shaped Apple"

  override protected def getTaste: String = "I am sweet Apple"
}
