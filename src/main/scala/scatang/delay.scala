package scatang

trait IDeref[T] {
  def deref(): T
}

trait IPending {
  def isRealized(): Boolean
}

object Delay {
  def apply[T](fn: () => T) = new Delay[T](fn)
}

class Delay[T](var fn: () => T) extends Function0[T] with IDeref[T] with IPending {

  var value: T = _

  override def apply(): T = deref()

  override def deref(): T = synchronized {
    if (fn != null) {
      value = fn()
      fn = null
    }
    value
  }

  override def isRealized: Boolean = synchronized {
    fn == null
  }
}
