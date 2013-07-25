//import org.brianmckenna.wartremover.WartRemover

package object scatang /* extends WartRemover */{

  implicit class NumericWrapper[A: Numeric](i: A) {
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

  implicit class AnyWrapper[T <: Any](source: T) {
    def tap(proc: T => Any): T = {
      try {
        proc(source)
      } catch {
        case e: Throwable => Console.err.print(e.getMessage());
      }
      source
    }

    def deliver[R](proc: T => R): R = proc(source)

    def `with`[R](proc: T => R): R = deliver(proc)
  }

  def time[T](fn: => T): (Double,T) = {
    val start = System.nanoTime
    var ret = fn
    val end = System.nanoTime
    val elapsed =  (end - start) / 1000000.0
    println(s"""Elapsed time: $elapsed msecs""")
    (elapsed, ret)
  }
}
