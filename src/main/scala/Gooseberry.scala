class Gooseberry extends Berry {

  override def getMySize(`fruitName`: Option[String] = None): String = {
    super.getMySize(`fruitName` = Some("Gooseberry"))
  }

  override def getMyShape(`fruitName`: Option[String]): String = super.getMyShape(Some("Gooseberry"))
}
