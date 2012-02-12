package com.tinkerpop.gremlin.scala

import com.tinkerpop.gremlin.Tokens

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
object Gremlin {

  def version(): String = {
    Tokens.VERSION;
  }

  def language(): String = {
    "gremlin-scala";
  }

}