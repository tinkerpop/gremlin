package com.tinkerpop.gremlin

import org.codehaus.groovy.runtime.metaclass.ClosureMetaMethod

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinHelper {

  public static Set getMissingMethods(Class clazz) {
    def tokens = [] as Set
    while (clazz) {
      tokens.addAll(clazz.getMetaClass().getMethods().findAll {it instanceof ClosureMetaMethod}.collect {it.name})
      clazz.getInterfaces().each {tokens.addAll(getMissingMethods(it))}
      clazz = clazz.getSuperclass()
    }
    return tokens;
  }
}
