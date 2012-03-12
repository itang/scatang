package object scatang {

  implicit def numeric2Powerable[A : Numeric](i: A) = new {

    def times(proc: Int => Unit) {
      var index = 1
      val size = implicitly[Numeric[A]].toInt(i)
      while (index <= size) {
        proc(index)
        index += 1
      }
    }

    def times(block: => Unit) {
      times(index => block)
    }
  }

  implicit def any2Powerable[T <: Any](source: T) = new {

    def tap(proc: T => Any): T = {
      try {
        proc(source)
      } catch {
        case e => Console.err.print(e.getMessage());
      }
      source
    }

    def deliver[R](proc: T => R): R = proc(source)

    def `with`[R](proc: T => R) = deliver(proc)
  }
}
