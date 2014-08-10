package scatang

package scatang_spec

import org.scalatest.FunSpec
import org.scalatest.Matchers

import scatang.string._

class CoreSpec extends FunSpec with Matchers {
  describe("string 库") {
    describe("nullToEmpty") {
      val s: String = null
      s.nullToEmpty should be("")
      "a".nullToEmpty should be("a")
    }

    describe("pad") {
      val s: String = null;
      s.pad(10, "*", true) should be("*" * 10)
      s.pad(10, "*", false) should be("*" * 10)

      s.pad(0, "*", true) should be("")
      s.pad(1, "*", true) should be("*")

      val s1 = ""
      s1.pad(10, "*", true) should be("*" * 10)
      s1.pad(10, "*", false) should be("*" * 10)
    }

    describe("padRight") {
      val ret = "abc".padRight(10)
      ret should have length (10)
      ret.substring("abc".length()) should be(" " * 7)

      "abc".padRight(3) should be("abc")
      "abc".padRight(2) should be("abc")
    }

    describe("padLeft") {
      val ret = "abc".padLeft(10)
      ret should have length (10)
      ret.substring(0, ret.length() - "abc".length()) should be(" " * 7)

      "abc".padLeft(3) should be("abc")
      "abc".padLeft(2) should be("abc")
    }

    describe("center") {
      case class Case(input: String, length: Int, expected: String)
      val cases = List(
        Case(null, 10, " " * 10),
        Case("", 10, " " * 10),
        Case("a", -1, "a"),
        Case("a", 0, "a"),
        Case("a", 1, "a"),
        Case("a", 2, "a "),
        Case("a", 3, " a "),
        Case("a", 4, " a  "),
        Case("a", 10, "    a     "))

      for (Case(input, len, expected) <- cases) {
        input.center(len) should be(expected)
      }

      "a".center(10, "*") should be("****a*****")
    }
  }
}
