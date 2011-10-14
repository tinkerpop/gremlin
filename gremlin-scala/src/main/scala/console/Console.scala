package com.tinkerpop.gremlin.scala.console

import scala.tools.nsc.Settings
import scala.tools.nsc.reporters.ConsoleReporter
import scala.tools.nsc.interpreter.{IMain, ILoop, ReplReporter, Naming}
import com.tinkerpop.gremlin.Imports

import scala.collection.JavaConversions._

/** http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/compiler/scala/tools/nsc/interpreter/package.html */
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
  val welcome = "\n" +
    "         \\,,,/\n" +
    "         (o o)\n" +
    "-----oOOo-(_)-oOOo-----"

  override def printWelcome() {
    echo(welcome)

    //printWelcome() is the only decent place to init the intp while process() is setting things up...
    intp beQuietDuring {
      Imports.getImports("*", "_").foreach {
        intp.addImports(_)
      };
      intp.addImports("com.tinkerpop.gremlin.scala._");
    }
  }

  override def prompt = "gremlin> "
      
  var gremlinIntp: GremlinInterpreter = _
  override def createInterpreter() {
    if (addedClasspath != "")
      settings.classpath append addedClasspath
	     
    gremlinIntp = new GremlinInterpreter
    intp = gremlinIntp
  }
  
  //A lot of the stuff that follows is attempting to customize the Print step of REPL
  //But this bug is thwarting our efforts: https://issues.scala-lang.org/browse/SI-4899
  
  override def command(line: String): Result = {
    val r = super.command(line)
    for (req <- gremlinIntp.lastRequest) {
      //println("definedNames = " + req.definedNames)
      //println("values = " + req.definedNames.map(n => gremlinIntp.valueOfTerm(n.toString)))
      //println("termNames = " + req.termNames)
      //println("fullPaths = " + req.definedNames.map(n => req.fullPath(n.toString)))
      //println("fullFlatNames = " + req.definedNames.map(n => req.fullFlatName(n.toString)))
      
      /*val name = "dontUseThis"
      gremlinIntp.interpret("val %s = %s".format(name, req.definedNames.head.toString))
      println(name + " = " + gremlinIntp.valueOfTerm(name))*/
    }
    r
  }
  
  class GremlinInterpreter extends this.ILoopInterpreter { //also descends from IMain, the core interpreter class
    override lazy val reporter: ConsoleReporter = new GremlinReporter(this)
    
    //this was taken from a newer version of IMain, post 2.9.1
    /*def mostRecentLine = prevRequestList match {
      case Nil      => ""
      case req :: _ => req.originalLine
    }*/
    def mostRecentLine = prevRequestList.lastOption map { _.originalLine } getOrElse ""
    def lastRequest: Option[Request] = prevRequestList.lastOption
    
    /*override def recordRequest(req: Request) {
      super.recordRequest(req)
      println("recorded " + req.originalLine)
      println("eval = " + req.getEval)
      println("evalCaught = " + req.lineRep.evalCaught)
      println("current line.get() = " + lineManager.current.map(_.get()).getOrElse("no current line"))
      //try { println("print = " + req.lineRep.call(naming.sessionNames.eval)) } catch { case t: Throwable => println("caught") }
      println("definedNames = " + req.definedNames)
      println("values = " + req.definedNames.map(n => valueOfTerm(n.toString)))
    }*/
  }
  
  class GremlinReporter(intp: GremlinInterpreter) extends ReplReporter(intp) {
    override def printMessage(msg: String) {
      val line = intp.mostRecentLine
      //println("mostRecentLine = " + line)
      super.printMessage(msg)
    }
  }
}

