class Blackberry extends Berry {

  override def getMySize(`fruitName`: Option[String] = None): String = super.getMySize(`fruitName` = Some("Blackberry"))

  override def getMyShape(`fruitName`: Option[String]): String = super.getMyShape(Some("Blackberry"))

}

