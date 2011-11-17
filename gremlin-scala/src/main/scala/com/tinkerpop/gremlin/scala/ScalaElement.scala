package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.Element
import java.util.{Map => JMap}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

abstract class ScalaElement(val element: Element) {

  def as[T](key: String): Option[T] = Option(element.getProperty(key)).map(_.asInstanceOf[T])

  def id: Any = element.getId

  def apply(key: String): Object = element.getProperty(key)
}
