# Scatang

An utility library for [Scala][scala]. (*Experimental*)

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

#### Any#`with`  

    scala> "attitue".tap(println) `with` { it => it map { _ - 'a' + 1} sum }  
    attitue  
    res5: Int = 96  

#### time
	
	scala> time(Range(1,100000).sum)
	Elapsed time: 0.317745 msecs
	res6: (Double, Int) = (0.317745,704982704)

[scala]: http://www.scala-lang.org

