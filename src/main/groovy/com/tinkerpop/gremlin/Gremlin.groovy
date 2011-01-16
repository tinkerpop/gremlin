package com.tinkerpop.gremlin;


import com.tinkerpop.gremlin.pipes.ClosureFilterPipe
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import org.codehaus.groovy.runtime.metaclass.ClosureMetaMethod
import com.tinkerpop.gremlin.loaders.*

class Gremlin {

  public static void load() {
    ObjectLoader.load()
    GraphLoader.load();
    IndexLoader.load();
    ElementLoader.load();
    PipeLoader.load();
  }

  public static Filter mapFilter(final t) {
    if (t == t.eq)
      return Filter.NOT_EQUAL else if (t == t.neq)
      return Filter.EQUAL else if (t == t.lt)
        return Filter.GREATER_THAN_EQUAL else if (t == t.lte)
          return Filter.GREATER_THAN else if (t == t.gt)
            return Filter.LESS_THAN_EQUAL else
            return Filter.LESS_THAN
  }

  public static GremlinPipeline compose(final Object start) {
    return compose(start, null, null);
  }

  public static GremlinPipeline compose(final Object start, final Pipe pipe) {
    return compose(start, pipe, null);
  }

  public static GremlinPipeline compose(final Object start, final Pipe pipe, final Closure closure) {
    GremlinPipeline pipeline;
    if (start instanceof GremlinPipeline) {
      pipeline = start;
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else if (start instanceof Pipe) {
      pipeline = new GremlinPipeline();
      pipeline.addPipe(start);
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else {
      pipeline = new GremlinPipeline();
      if (null != pipe)
        pipeline.addPipe(pipe);
      pipeline.setStarts((Iterator) start.iterator());
    }
    if (closure) {
      pipeline.addPipe(new ClosureFilterPipe(closure));
    }
    return pipeline;
  }

  public static Pipe compile(final String gremlin) {
    final String IMPORT = "import "
    final String NEWLINE = "\n"
    final GroovyShell groovy = GroovyShell.newInstance()
    final StringBuilder sb = new StringBuilder()
    for (final String importItem: Imports.getImports())
      sb.append(IMPORT).append(importItem).append(NEWLINE);
    sb.append(gremlin);
    return (Pipe) groovy.evaluate(sb.toString())
  }

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
