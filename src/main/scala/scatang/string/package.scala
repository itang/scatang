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
}