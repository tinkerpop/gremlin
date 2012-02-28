package com.tinkerpop.gremlin.scala.console

import scala.tools.nsc.Settings
import scala.tools.nsc.reporters.ConsoleReporter
import scala.tools.nsc.interpreter.{ILoop, ReplReporter}
import com.tinkerpop.gremlin.Imports

import scala.collection.JavaConversions._

/**http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/compiler/scala/tools/nsc/interpreter/package.html */
object Console {
  def main(args: Array[String]) {
    val settings = new Settings()
    settings.usejavacp.value = true
    settings.deprecation.value = true

    val iloop = new GremlinILoop()
    iloop.process(settings)
  }
}

class GremlinILoop extends ILoop {
  val inputPrompt = "gremlin> "
  val resultPrompt = "==>"

  override def prompt = inputPrompt

  val welcome = "\n" +
    "         \\,,,/\n" +
    "         (o o)\n" +
    "-----oOOo-(_)-oOOo-----"

  override def printWelcome() {
    echo(welcome)

    //printWelcome() is the only decent place to init the intp while process() is setting things up...
    intp beQuietDuring {
      //calling addImports separately for each import is really slow, so only call it once
      val imports = Imports.getImports("*", "_") :+ "com.tinkerpop.gremlin.scala._"
      intp.addImports(imports: _*)
    }
  }

  var gremlinIntp: GremlinInterpreter = _

  override def createInterpreter() {
    if (addedClasspath != "")
      settings.classpath append addedClasspath
    gremlinIntp = new GremlinInterpreter
    intp = gremlinIntp
  }

  /**Overriden to print out the value evaluated from the specified line. */
  override def command(line: String): Result = {
    val r = super.command(line)

    //TODO handle compiler error
    //TODO handle exception
    //TODO handle something like class on multilines
    if (r.keepRunning && r.lineToRecord.isDefined) {
      printLastValue()
    }

    r
  }

  /**Prints the last value by expanding its elements if it's iterator-like or collection-like. */
  def printLastValue() = gremlinIntp.lastValue match {
    case Right(value) => for (v <- toIterator(value)) out.println(resultPrompt + v)
    case Left(throwable) => throwable.printStackTrace(out)
  }

  /**Coerces the specified value into an iterator. */
  def toIterator(value: Any): Iterator[Any] = {
    import scala.collection.JavaConverters._
    value match {
      case t: Traversable[Any] => t.toIterator
      case a: Array[_] => a.toIterator
      case i: java.lang.Iterable[Any] => i.asScala.toIterator
      case i: java.util.Iterator[Any] => i.asScala
      case m: java.util.Map[Any, Any] => m.asScala.toIterator
      case _ => Iterator.single(value)
    }
  }

  class GremlinInterpreter extends this.ILoopInterpreter {
    //also descends from IMain, the core interpreter class
    override lazy val reporter: ConsoleReporter = new GremlinReporter(this)

    /**Returns the last request executed by this interpreter. */
    def lastRequest: Option[Request] = prevRequestList.lastOption

    /**Returns the last value evaluated by this interpreter. See https://issues.scala-lang.org/browse/SI-4899 for details. */
    def lastValue: Either[Throwable, AnyRef] = lastRequest.getOrElse(throw new NullPointerException()).lineRep.callEither("$result")
  }

  /**Stop ReplReporter from printing to console. Instead we print in GremlinILoop.command. */
  class GremlinReporter(intp: GremlinInterpreter) extends ReplReporter(intp) {
    override def printMessage(msg: String) {}

    //println("***" + msg)
  }

}

