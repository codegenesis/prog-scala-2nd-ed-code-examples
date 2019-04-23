package practisescala

import java.lang

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Random, Success}

/**
  * created by skant
  */
object Practise1 extends App {


  //  override def main(args: Array[String]): Unit = {
  //
  //    val fruits = Seq("Appl", "Ora", "Bana")
  //    println(fruits)
  //
  //    //fruits.map(_.toUpperCase)
  //    println(fruits.map((s: String) => s.toUpperCase))
  //
  //
  //    println(fruits.flatMap((s: String) => s.toUpperCase))
  //  }

  //Example to show the use of Future
  import ExecutionContext.Implicits.global

  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis
  import scala.concurrent.duration._

  println("starting calculation ...")
  val f = Future {
    Thread.sleep(Random.nextInt(500))
    42
  }
  println("before onComplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
  }
  // do the rest of your work
  println("A ..."); Thread.sleep(100)
  println("B ..."); Thread.sleep(100)
  println("C ..."); Thread.sleep(100)
  println("D ..."); Thread.sleep(100)
  println("E ..."); Thread.sleep(100)
  println("F ..."); Thread.sleep(100)
  Thread.sleep(2000)
}
