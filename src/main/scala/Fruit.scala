abstract case class Fruit() extends Ordered[Fruit] {
  protected var weight: Double
  protected var left: Fruit
  protected var right: Fruit
  protected def getTaste: String

  override def compare(that: Fruit): Int =
    java.lang.Double.compare(weight, that.weight)

  def set_weight(x: Double) {
    weight = x
  }

  def get_weight(): Double = {
    weight
  }

  def set_left(x: Fruit) {
    left = x
  }

  def set_right(x: Fruit) {
    right = x
  }

  def get_left(): Fruit = {
    left
  }

  def get_right(): Fruit = {
    right
  }

}
