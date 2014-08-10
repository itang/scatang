package scatang

import java.util.Random

package object string {
  private lazy val random = new Random

  type RandomSample = Array[Char]
  lazy val RandomSampleNumbers: RandomSample = (0 to 9).mkString.toArray
  lazy val RandomSampleChars: RandomSample = ('_' :: ('a' to 'z').toList ::: ('A' to 'Z').toList).toArray
  lazy val RandomSampleMixed: RandomSample = RandomSampleNumbers ++ RandomSampleChars

  def randomString(length: Int = 8, sample: RandomSample = RandomSampleMixed): String = {
    assert(length > 0)
    assert(sample.length > 0, "sample data can't be empty!")

    (0 until length).foldLeft(new StringBuilder) { (sb, _) =>
      sb append sample(random.nextInt(sample.length))
    }.toString
  }

  implicit class StringWrapper( /*@Nullable*/ s: String) {
    def padRight(length: Int, p: String = " "): String = pad(length, p, true)

    def padLeft(length: Int, p: String = " "): String = pad(length, p, false)

    def pad(length: Int, p: String = " ", right_? : Boolean = true): String = {
      val to = s.nullToEmpty
      val len = to.length()
      len match {
        case _ if len >= length => to
        case _ => {
          val pl = length - len
          if (right_?) to + p * pl else p * pl + to
        }
      }
    }

    def center(numberOfChars: Int, p: String = " "): String = {
      val to = s.nullToEmpty
      if (to.isEmpty()) {
        return p * numberOfChars
      }

      val len = to.length()
      if (numberOfChars <= len) {
        return to
      }

      val (lplen, rplen) = {
        val plen = numberOfChars - len
        val hplen = plen / 2
        if (plen % 2 == 0) (hplen, hplen) else (hplen, hplen + 1)
      }
      return p * lplen + to + p * rplen
    }

    def nullToEmpty(): String = if (s == null) "" else s

    private def lengthOrNullZero(): Int = if (s == null) 0 else s.length()

  }
}
