class Berry extends Fruit with TinySizedFruit with OvalShapedFruit {
  override protected var weight: Double = _
  override protected var left: Fruit = _
  override protected var right: Fruit = _

  override def getMySize(`fruitName`: Option[String]): String = {
    val matchResult = `fruitName` match {
      case Some(fruitName) => "I am a tiny sized " + fruitName
      case _ => "I am a tiny sized berry"
    }
    matchResult
  }

  override def getMyShape(`fruitName`: Option[String]): String = {
    val matchResult = `fruitName` match {
      case Some(fruitName) => "I am an Oval shaped " + fruitName
      case _ => "I am an Oval shaped berry"
    }
    matchResult
  }

  override protected def getTaste: String = "I am sour berry"
}