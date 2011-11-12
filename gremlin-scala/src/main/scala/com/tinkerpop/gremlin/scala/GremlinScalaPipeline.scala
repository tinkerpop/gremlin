package com.tinkerpop.gremlin.scala

import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.pipes.filter._
import java.util.{List => JList}
import java.util.{Map => JMap, List => JList, Iterator => JIterator}
import com.tinkerpop.blueprints.pgm._
import com.tinkerpop.pipes.{PipeFunction, Pipe}
import com.tinkerpop.pipes.branch.util.LoopBundle

/**Adds convenience methods to [[com.tinkerpop.gremline.pipes.GremlinPipeline]]. */
class GremlinScalaPipeline[S, E](s: S) extends GremlinPipeline[S, E](s) /*with Iterator[E]*/ {
  /*def hasNext: Boolean = pipeline.hasNext

  def next(): E = pipeline.next()*/

  def out: GremlinScalaPipeline[S, Vertex] =
    super.out().asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  def in: GremlinScalaPipeline[S, Vertex] =
    super.in().asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  def paths: GremlinScalaPipeline[S, JList[_]] =
    super.path().asInstanceOf[GremlinScalaPipeline[S, JList[_]]]

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Copied from GremlinPipeline

  def idFilter[F <: Element](id: Any, filter: FilterPipe.Filter): GremlinScalaPipeline[S, F] =
    super.idFilter(id, filter).asInstanceOf[GremlinScalaPipeline[S, F]]

  override def labelFilter(label: String, filter: FilterPipe.Filter): GremlinScalaPipeline[S, Edge] =
    super.labelFilter(label, filter).asInstanceOf[GremlinScalaPipeline[S, Edge]]

  def propertyFilter[F <: Element, T](key: String, filter: FilterPipe.Filter, value: T): GremlinScalaPipeline[S, F] =
    super.propertyFilter(key, filter, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  def propertyFilter[F <: Element, T](key: String, t: Tokens.T, value: T): GremlinScalaPipeline[S, F] =
    super.propertyFilter(key, t, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  override def bothE(labels: String*): GremlinScalaPipeline[S, Edge] =
    super.bothE(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Edge]]

  override def both(labels: String*): GremlinScalaPipeline[S, Vertex] =
    super.both(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def bothV: GremlinScalaPipeline[S, Vertex] =
    super.bothV.asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def E: GremlinScalaPipeline[S, Edge] =
    super.E.asInstanceOf[GremlinScalaPipeline[S, Edge]]

  override def idEdge(graph: Graph): GremlinScalaPipeline[S, Edge] =
    super.idEdge(graph).asInstanceOf[GremlinScalaPipeline[S, Edge]]

  override def id: GremlinScalaPipeline[S, Object] =
    super.id.asInstanceOf[GremlinScalaPipeline[S, Object]]

  override def idVertex(graph: Graph): GremlinScalaPipeline[S, Vertex] =
    super.idVertex(graph).asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def inE(labels: String*): GremlinScalaPipeline[S, Edge] =
    super.inE(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Edge]]

  override def in(labels: String*): GremlinScalaPipeline[S, Vertex] =
    super.in(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def inV: GremlinScalaPipeline[S, Vertex] =
    super.inV.asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def label: GremlinScalaPipeline[S, String] =
    super.label.asInstanceOf[GremlinScalaPipeline[S, String]]

  override def outE(labels: String*): GremlinScalaPipeline[S, Edge] =
    super.outE(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Edge]]

  override def out(labels: String*): GremlinScalaPipeline[S, Vertex] =
    super.out(labels: _*).asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def outV: GremlinScalaPipeline[S, Vertex] =
    super.outV.asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  def map[F <: Element]: GremlinScalaPipeline[S, JMap[String, Object]] = //TODO use scala Map here?
    super.map.asInstanceOf[GremlinScalaPipeline[S, JMap[String, Object]]]

  def property[F <: Element](key: String): GremlinScalaPipeline[S, Object] =
    super.property(key).asInstanceOf[GremlinScalaPipeline[S, Object]]

  override def V: GremlinScalaPipeline[S, Vertex] =
    super.V.asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  override def index[F <: Element](index: Index[F], key: String, value: Object): GremlinScalaPipeline[S, F] =
    super.index(index, key, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  /********************************************/
  /********************************************/
  /**
   * ****************************************
   */
  def step[F](f: JIterator[E] => F): GremlinScalaPipeline[S, F] =
    super.step(f).asInstanceOf[GremlinScalaPipeline[S, F]]

  def step[F](pipe: Pipe[E, F]): GremlinScalaPipeline[S, F] =
    super.step(pipe).asInstanceOf[GremlinScalaPipeline[S, F]]

  ////////////////////
  /// BRANCH PIPES ///
  ////////////////////
  override def copySplit(pipes: Pipe[_, _]*): GremlinScalaPipeline[S, E] =
    super.copySplit(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, E]]

  override def exhaustMerge(pipes: Pipe[_, _]*): GremlinScalaPipeline[S, E] =
    super.exhaustMerge(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, E]]

  override def exhaustMerge: GremlinScalaPipeline[S, E] =
    super.exhaustMerge.asInstanceOf[GremlinScalaPipeline[S, E]]

  override def fairMerge(pipes: Pipe[_, _]*): GremlinScalaPipeline[S, E] =
    super.fairMerge(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, E]]

  override def fairMerge: GremlinScalaPipeline[S, E] =
    super.fairMerge.asInstanceOf[GremlinScalaPipeline[S, E]]

  def ifThenElse(ifFunction: S => Boolean, thenFunction: S => _, elseFunction: S => _): GremlinScalaPipeline[S, E] =
    super.ifThenElse(ifFunction, thenFunction, elseFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(whileFunction: LoopBundle[S] => Boolean, pipeFunction: Object => Pipe[S, S]): GremlinScalaPipeline[S, S] =
    super.loop(whileFunction, pipeFunction).asInstanceOf[GremlinScalaPipeline[S, S]]

  def loop(whileFunction: LoopBundle[S] => Boolean, pipeFunction: Object => Pipe[S, S], emitFunction: LoopBundle[S] => Boolean): GremlinScalaPipeline[S, S] =
    super.loop(whileFunction, pipeFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, S]]


  ////////////////////
  /// FILTER PIPES ///
  ////////////////////
  /*  def and(pipes: Pipe[_, Boolean]*): GremlinPipeline[S, E] = {
    return this.add(new AndFilterPipe[_](pipes))
  }

  def back(numberedStep: Int): GremlinPipeline[S, _] = {
    return this.add(new BackFilterPipe[_](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, numberedStep))))
  }

  def back(namedStep: String): GremlinPipeline[S, _] = {
    return this.add(new BackFilterPipe[_](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, namedStep))))
  }

  def back(pipe: Pipe[_, _]): GremlinPipeline[S, _] = {
    return this.add(new BackFilterPipe[_](pipe))
  }

  def dedup: GremlinPipeline[S, E] = {
    return this.add(new DuplicateFilterPipe[_])
  }

  def except(collection: Collection[_]): GremlinPipeline[S, E] = {
    return this.add(new ExceptFilterPipe[_](collection))
  }

  def filter(filterFunction: PipeFunction[_, Boolean]): GremlinPipeline[S, E] = {
    return this.add(new FilterFunctionPipe[_](filterFunction))
  }

  def objectFilter(`object` : AnyRef, filter: FilterPipe.Filter): GremlinPipeline[S, E] = {
    return this.add(new ObjectFilterPipe[_](`object`, filter))
  }

  def or(pipes: Pipe[S, Boolean]*): GremlinPipeline[S, E] = {
    return this.add(new OrFilterPipe[_](pipes))
  }

  def random(bias: Double): GremlinPipeline[S, E] = {
    return this.add(new RandomFilterPipe[_](bias))
  }

  def range(low: Int, high: Int): GremlinPipeline[S, E] = {
    return this.add(new RangeFilterPipe[_](low, high))
  }

  def retain(collection: Collection[_]): GremlinPipeline[S, E] = {
    return this.add(new RetainFilterPipe[_](collection))
  }

  def simplePath: GremlinPipeline[S, E] = {
    return this.add(new CyclicPathFilterPipe[_])
  }

  /////////////////////////
  /// SIDE-EFFECT PIPES ///
  /////////////////////////
  def aggregate(aggregate: Collection[_]): GremlinPipeline[S, E] = {
    return this.add(new AggregatePipe[_](aggregate))
  }

  def aggregate(aggregate: Collection[_], aggregateFunction: PipeFunction[_, _]): GremlinPipeline[S, E] = {
    return this.add(new AggregatePipe[_](aggregate, aggregateFunction))
  }

  def aggregate: GremlinPipeline[S, E] = {
    return this.aggregate(new ArrayList[_])
  }

  def aggregate(aggregateFunction: PipeFunction[_, _]): GremlinPipeline[S, E] = {
    return this.aggregate(new ArrayList[_], aggregateFunction)
  }

  def optional(numberedStep: Int): GremlinPipeline[S, _] = {
    return this.add(new OptionalPipe[_](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, numberedStep))))
  }

  def optional(namedStep: String): GremlinPipeline[S, _] = {
    return this.add(new OptionalPipe[_](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, namedStep))))
  }

  def optional(pipe: Pipe[_, _]): GremlinPipeline[S, _] = {
    return this.add(new OptionalPipe[_](pipe))
  }

  def groupCount(map: Map[_, Number], keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[Number, Number]): GremlinPipeline[S, E] = {
    return this.add(new GroupCountFunctionPipe[_, _](map, keyFunction, valueFunction))
  }

  def groupCount(keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[Number, Number]): GremlinPipeline[S, E] = {
    return this.add(new GroupCountFunctionPipe[_, _](keyFunction, valueFunction))
  }

  def groupCount(map: Map[_, Number], keyFunction: PipeFunction[_, _]): GremlinPipeline[S, E] = {
    return this.add(new GroupCountFunctionPipe[_, _](map, keyFunction, null))
  }

  def groupCount(keyFunction: PipeFunction[_, _]): GremlinPipeline[S, E] = {
    return this.add(new GroupCountFunctionPipe[_, _](keyFunction, null))
  }

  def groupCount(map: Map[_, Number]): GremlinPipeline[S, E] = {
    return this.add(new GroupCountPipe[_](map))
  }

  def groupCount: GremlinPipeline[S, E] = {
    return this.add(new GroupCountPipe[_])
  }

  def sideEffect(sideEffectFunction: PipeFunction[_, _]): GremlinPipeline[S, E] = {
    return this.add(new SideEffectFunctionPipe[_](sideEffectFunction))
  }

  def table(table: Table, stepNames: Collection[String], columnFunctions: PipeFunction[_, _]*): GremlinPipeline[S, E] = {
    return this.add(new TablePipe[_](table, stepNames, FluentUtility.getAsPipes(this), columnFunctions))
  }

  def table(table: Table, columnFunctions: PipeFunction[_, _]*): GremlinPipeline[S, E] = {
    return this.add(new TablePipe[_](table, null, FluentUtility.getAsPipes(this), columnFunctions))
  }

  def table(table: Table): GremlinPipeline[S, E] = {
    return this.add(new TablePipe[_](table, null, FluentUtility.getAsPipes(this)))
  }

  def table: GremlinPipeline[S, E] = {
    return this.add(new TablePipe[_](new Table, null, FluentUtility.getAsPipes(this)))
  }

  ///////////////////////
  /// TRANSFORM PIPES ///
  ///////////////////////
  def gather: GremlinPipeline[S, List[_]] = {
    return this.add(new GatherPipe[_])
  }

  def gather(function: PipeFunction[List[_], _]): GremlinPipeline[S, _] = {
    this.addPipe(new GatherPipe[_])
    return this.add(new TransformFunctionPipe[_, _](function))
  }

  def _: GremlinPipeline[S, E] =
  {
    return this.add(new IdentityPipe[_])
  }

  def memoize(namedStep: String): GremlinPipeline[S, E] = {
    return this.add(new MemoizePipe[_, _](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, namedStep))))
  }

  def memoize(numberedStep: Int): GremlinPipeline[S, E] = {
    return this.add(new MemoizePipe[_, _](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, numberedStep))))
  }

  def memoize(namedStep: String, map: Map[_, _]): GremlinPipeline[S, E] = {
    return this.add(new MemoizePipe[_, _](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, namedStep)), map))
  }

  def memoize(numberedStep: Int, map: Map[_, _]): GremlinPipeline[S, E] = {
    return this.add(new MemoizePipe[_, _](new Pipeline[_, _](FluentUtility.removePreviousPipes(this, numberedStep)), map))
  }*/

  override def path(pathFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, JList[_]] =
    super.path(pathFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, JList[_]]]

  /*def scatter: GremlinPipeline[S, _] = {
    return this.add(new ScatterPipe[_, _])
  }

  def cap: GremlinPipeline[S, _] = {
    return this.add(new SideEffectCapPipe[_, _](FluentUtility.removePreviousPipes(this, 1).get(0).asInstanceOf[SideEffectPipe[_, _]]))
  }*/

  def transform[F](function: PipeFunction[E, F]): GremlinScalaPipeline[S, F] =
    super.transform(function).asInstanceOf[GremlinScalaPipeline[S, F]]

  //////////////////////
  /// UTILITY PIPES ///
  //////////////////////
  /*def as(name: String): GremlinPipeline[S, E] = {
    return this.add(new AsPipe[_, _](name, FluentUtility.removePreviousPipes(this, 1).get(0)))
  }

  def start(starts: AnyRef): GremlinPipeline[S, E] = {
    this.add(new StartPipe[_](starts))
    FluentUtility.setStarts(this, starts)
    return this
  }
  */
}
