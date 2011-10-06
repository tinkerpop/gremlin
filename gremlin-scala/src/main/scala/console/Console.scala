package com.tinkerpop.gremlin.scala.console

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop
//import com.tinkerpop.gremlin.Imports
import scala.collection.JavaConversions._

/** http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/compiler/scala/tools/nsc/interpreter/package.html */
object Console {
  val imports = List(
    // gremlin
    "com.tinkerpop.gremlin._",
    //"com.tinkerpop.gremlin.GremlinTokens.T", <============ This is in gremlin-groovy, not gremlin-core
    // blueprints
    "com.tinkerpop.blueprints.pgm._",
    "com.tinkerpop.blueprints.pgm.impls._",
    "com.tinkerpop.blueprints.pgm.impls.tg._",
    "com.tinkerpop.blueprints.pgm.impls.neo4j._",
    "com.tinkerpop.blueprints.pgm.impls.orientdb._",
    "com.tinkerpop.blueprints.pgm.impls.dex._",
    "com.tinkerpop.blueprints.pgm.impls.rexster._",
    //"com.tinkerpop.blueprints.pgm.impls.neo4jbatch._", <================ TODO shows an error on repl startup
    "com.tinkerpop.blueprints.pgm.impls.event._",
    "com.tinkerpop.blueprints.pgm.impls.readonly._",
    "com.tinkerpop.blueprints.pgm.impls.sail._",
    "com.tinkerpop.blueprints.pgm.impls.sail.impls._",
    "com.tinkerpop.blueprints.pgm.util._",
    "com.tinkerpop.blueprints.pgm.util.graphml._",
    "com.tinkerpop.blueprints.pgm.oupls.sail._",
    "com.tinkerpop.blueprints.pgm.oupls.jung._",
    "com.tinkerpop.blueprints.pgm.oupls.jung.util._",
    // pipes
    "com.tinkerpop.pipes._",
    "com.tinkerpop.pipes.branch._",
    "com.tinkerpop.pipes.filter._",
    "com.tinkerpop.pipes.sideeffect._",
    "com.tinkerpop.pipes.transform._",
    "com.tinkerpop.pipes.util._",
    // gremlin-scala
    "com.tinkerpop.gremlin.scala._")

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
          intp.addImports(imports: _*)
        }
      }
      override def prompt = "gremlin> "
    }
    iloop.process(settings)
  }
}
