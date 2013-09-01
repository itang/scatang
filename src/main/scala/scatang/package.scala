//import org.brianmckenna.wartremover.WartRemover

import scatang.core.Delay
import scatang.core.IPending

package object scatang /* extends WartRemover */ {

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

  def time[T](fn: => T): (Double, T) = {
    val start = System.nanoTime
    var ret = fn
    val elapsed = (System.nanoTime - start) / 1000000.0

    println(s"""Elapsed time: $elapsed msecs""")
    (elapsed, ret)
  }

  def delay[T](fn: => T): Delay[T] = Delay(() => fn)

  def delay_?(x: AnyRef) = x.isInstanceOf[Delay[_]]

  def force[T](x: AnyRef): T = {
    if (delay_?(x))
      x.asInstanceOf[Delay[T]].deref()
    else
      x.asInstanceOf[T]
  }

  def realized_?(x: IPending) = x.isRealized

  import  Numeric.Implicits._
  def inc[T: Numeric](i: T) = i + implicitly[Numeric[T]].one

  def dec[T: Numeric](i: T) = i - implicitly[Numeric[T]].one
}
