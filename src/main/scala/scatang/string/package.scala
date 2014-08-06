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
      val to = if (s == null) "" else s
      val len = if (s == null) 0 else s.length()
      len match {
        case _ if len >= length => to
        case _ => {
          val pl = length - len
          if (right_?) to + p * pl else p * pl + to
        }
      }
    }
  }
}
