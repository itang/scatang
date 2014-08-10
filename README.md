# Scatang

An utility library for [Scala][scala]. (*Experimental*)

## Install

    resolvers += "itang's repos" at "http://itang.github.io/maven-repo"
    
    libraryDependencies ++= Seq(
        "me.itang" % "scatang_2.11" % "0.1"
    )

## Usage:

	scala> import scatang._

#### Int#times

    scala> 2.times(print("Hello"))
    HelloHello
    scala> 10 times { i => print(i + 1) }
    234567891011

#### Any#tap

    scala> 1.tap(println).tap(it => 100)
    1
    res2: Int = 1

    scala> "hello".tap(_ + ",world")
    res3: java.lang.String = hello

    scala> "hello".tap(_ + ",world") tap print
    hellores4: java.lang.String = hello

#### Any#|>

    scala> "attitue".tap(println) |> { it => it map { _ - 'a' + 1} sum }
    attitue
    res5: Int = 96

#### time

	scala> time(Range(1,100000).sum)
	Elapsed time: 0.317745 msecs
	res6: (Double, Int) = (0.317745,704982704)

#### delay, delay_?, realized_?, force

    scala> val d = delay({println("do");System.nanoTime()})
    d: scatang.Delay[Long] = <function0>

    scala> delay_?(d)
    res0: Boolean = true

    scala> realized_?(d)
    res1: Boolean = false

    scala> d()
    do
    res2: Long = 44624476336230

    scala> realized_?(d)
    res3: Boolean = true

    scala> d() == d()
    res4: Boolean = true

    scala> force(d) == d()
    res5: Boolean = true

[scala]: http://www.scala-lang.org
