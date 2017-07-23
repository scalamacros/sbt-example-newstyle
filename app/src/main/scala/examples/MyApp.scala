package examples

@main
object MyApp {
  println("Hello new-style macros!")

  case class C(x: Int, y: String)
  def serialize[T: Serialize](x: T): String = implicitly[Serialize[T]].apply(x)
  println(serialize(C(40, "2")))
}
