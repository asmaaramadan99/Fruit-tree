class Strawberry extends Fruit with TinySizedFruit {
  override protected var weight: Double = _
  override protected var left: Fruit = _
  override protected var right: Fruit = _

  override protected def getTaste: String = "I am sweet"

  override def getMySize(`fruitName`: Option[String]): String = "I am Tiny sized strawberry"
}
