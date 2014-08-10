package scatang_spec

import scatang._

import scala.language.reflectiveCalls

import org.scalatest.Matchers
import org.scalatest.FunSpec

//导入scatang core implicits
//import scatang._

class CoreSpec extends FunSpec with Matchers {
  describe("Core 库") {
    describe("Int 增强") {
      describe("times 方法") {
        it("byname parameter方式") {
          var count = 0
          10.times {
            count += 1
          }
          count should be(10)

          count = 0
          10.0 times {
            count += 1
          }

          count should be(10)
        }
        it("带当前次数方式") {
          var index = 1
          10.times { it =>
            it should be(index)
            index += 1
          }
        }
      }
    }

    describe("tap") {
      1.tap(println).tap(it => 100) should be(1)
      "hello".tap(_ + ",world") should be("hello")
    }

    describe("deliver") {
      "hello".deliver(_ + ",world") should be("hello,world")
      1.`with`(_ + 1).`with`(_ + 1) should be(3)
    }

    describe("|>") {
      "hello" |> (_ + ",world") should be("hello,world")
      1 |> (_ + 1) |> (_ + 1) should be(3)
    }

    describe("time") {
      import java.io.{ ByteArrayOutputStream, PrintStream }
      val baos = new ByteArrayOutputStream
      Console.withOut(new PrintStream(baos)) {
        val (elapsed, ret) = time(Range(1, 1000).sum)
        baos.toString should startWith("Elapsed time: " + elapsed + " msecs")
        ret should be(Range(1, 1000).sum)
      }
    }

    describe("delay delay_? realized_? force") {
      val d = delay({ println("delay"); System.nanoTime() })
      delay_?(d) should be(true)
      realized_?(d) should be(false)

      val v = d()
      realized_?(d) should be(true)

      v should be(d())
      v should be(d())

      force[Long](d) should be(v)
    }

    describe("inc dec") {
      val i = 10
      inc(i) should be(11)

      dec(i) should be(9)

      inc(10.0) should equal(11.0)
    }

    describe("odd_? even_?") {
      odd_?(1) should be(true)
      odd_?(2) should be(false)
      odd_?(-1) should be(true)
      odd_?(-2) should be(false)

      even_?(1) should be(false)
      even_?(2) should be(true)
      even_?(-1) should be(false)
      even_?(-2) should be(true)
    }
  }
}
