package com.tinkerpop.gremlin.scala.console

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop
import com.tinkerpop.gremlin.Imports

import scala.collection.JavaConversions._

/**http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/compiler/scala/tools/nsc/interpreter/package.html */
object Console {

  def main(args: Array[String]) {
    val settings = new Settings()
    settings.usejavacp.value = true
    settings.deprecation.value = true

    val iloop = new ILoop() {
      val welcome = "\n" +
        "         \\,,,/\n" +
        "         (o o)\n" +
        "-----oOOo-(_)-oOOo-----"

      override def printWelcome() {
        echo(welcome)

        //printWelcome() is the only decent place to init the intp while process() below is setting things up...
        intp beQuietDuring {
          Imports.getImports("*", "_").foreach{intp.addImports(_)};
          intp.addImports("com.tinkerpop.gremlin.scala._");
        }
      }

      override def prompt = "gremlin> "
    }
    iloop.process(settings)
  }
}
