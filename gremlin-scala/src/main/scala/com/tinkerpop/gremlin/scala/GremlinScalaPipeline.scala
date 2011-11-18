package com.tinkerpop.gremlin.scala

import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.pipes.filter._
import com.tinkerpop.blueprints.pgm._
import com.tinkerpop.pipes.{PipeFunction, Pipe}
import com.tinkerpop.pipes.branch.LoopPipe.LoopBundle
import java.util.{Map => JMap, List => JList, Iterator => JIterator}

/**Adds convenience methods to [[com.tinkerpop.gremline.pipes.GremlinPipeline]]. */
class GremlinScalaPipeline[S, E](s: S) extends GremlinPipeline[S, E](s) /*with Iterator[E]*/ {

  /*def hasNext: Boolean = pipeline.hasNext

def next(): E = pipeline.next()*/

  //def apply(key:String) = super.property(key);

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

  override def step[F](pipe: Pipe[E, F]): GremlinScalaPipeline[S, F] =
    super.step(pipe).asInstanceOf[GremlinScalaPipeline[S, F]]

  ////////////////////
  /// BRANCH PIPES ///
  ////////////////////
  override def copySplit(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, _] =
    super.copySplit(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, _]]

  override def exhaustMerge(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, _] =
    super.exhaustMerge(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, _]]

  override def exhaustMerge: GremlinScalaPipeline[S, _] =
    super.exhaustMerge.asInstanceOf[GremlinScalaPipeline[S, _]]

  override def fairMerge(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, _] =
    super.fairMerge(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, _]]

  override def fairMerge: GremlinScalaPipeline[S, _] =
    super.fairMerge.asInstanceOf[GremlinScalaPipeline[S, _]]

  def ifThenElse(ifFunction: E => Boolean, thenFunction: E => _, elseFunction: E => _): GremlinScalaPipeline[S, _] =
    super.ifThenElse(ifFunction, thenFunction, elseFunction).asInstanceOf[GremlinScalaPipeline[S, _]]

  def loop(numberedStep: Int, whileFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(numberedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(namedStep: String, whileFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(namedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(pipe: Pipe[E, E], whileFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(pipe, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(numberedStep: Int, whileFunction: LoopBundle[E] => Boolean, emitFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(numberedStep, whileFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(namedStep: String, whileFunction: LoopBundle[E] => Boolean, emitFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(namedStep, whileFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(pipe: Pipe[E, E], whileFunction: LoopBundle[E] => Boolean, emitFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(pipe, whileFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  ////////////////////
  /// FILTER PIPES ///
  ////////////////////
  override def and(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, E] = {
    super.and(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def back(numberedStep: Int): GremlinScalaPipeline[S, _] = {
    super.back(numberedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def back(namedStep: String): GremlinScalaPipeline[S, _] = {
    super.back(namedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def back(pipe: Pipe[E, _]): GremlinScalaPipeline[S, E] = {
    super.back(pipe).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def dedup: GremlinScalaPipeline[S, E] = {
    super.dedup().asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def except(collection: java.util.Collection[_]): GremlinScalaPipeline[S, E] = {
    super.except(collection).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def filter(filterFunction: E => Boolean): GremlinScalaPipeline[S, E] = {
    super.filter(filterFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def objectFilter(`object` : AnyRef, filter: FilterPipe.Filter): GremlinScalaPipeline[S, E] = {
    super.objectFilter(`object`, filter).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def or(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, E] = {
    super.or(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def random(bias: Double): GremlinScalaPipeline[S, E] = {
    super.random(bias).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def range(low: Int, high: Int): GremlinScalaPipeline[S, E] = {
    super.range(low, high).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def retain(collection: java.util.Collection[_]): GremlinScalaPipeline[S, E] = {
    super.retain(collection).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def simplePath: GremlinScalaPipeline[S, E] = {
    super.simplePath().asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  /////////////////////////
  /// SIDE-EFFECT PIPES ///
  /////////////////////////
  override def aggregate(aggregate: java.util.Collection[_]): GremlinScalaPipeline[S, E] = {
    super.aggregate(aggregate).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def aggregate(aggregate: java.util.Collection[_], aggregateFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.aggregate(aggregate, aggregateFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def aggregate(): GremlinScalaPipeline[S, E] = {
    super.aggregate(new java.util.ArrayList[Object]()).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def aggregate(aggregateFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.aggregate(new java.util.ArrayList[Object](), aggregateFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def optional(numberedStep: Int): GremlinScalaPipeline[S, _] = {
    super.optional(numberedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def optional(namedStep: String): GremlinScalaPipeline[S, _] = {
    super.optional(namedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def optional(pipe: Pipe[E, _]): GremlinScalaPipeline[S, E] = {
    super.optional(pipe).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(map: JMap[_, Number], keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[Number, Number]): GremlinScalaPipeline[S, E] = {
    super.groupCount(map, keyFunction, valueFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[Number, Number]): GremlinScalaPipeline[S, E] = {
    super.groupCount(keyFunction, valueFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(map: JMap[_, Number], keyFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupCount(map, keyFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(keyFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupCount(keyFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(map: JMap[_, Number]): GremlinScalaPipeline[S, E] = {
    super.groupCount(map).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount: GremlinScalaPipeline[S, E] = {
    super.groupCount().asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def sideEffect(sideEffectFunction: PipeFunction[E, _]): GremlinScalaPipeline[S, E] = {
    super.sideEffect(sideEffectFunction).asInstanceOf[GremlinScalaPipeline[S,E]]
  }

  /*def table(table: Table, stepNames: Collection[String], columnFunctions: PipeFunction[_, _]*): GremlinPipeline[S, E] = {
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
  }*/

  override def cap: GremlinScalaPipeline[S, _] = {
    super.cap().asInstanceOf[GremlinScalaPipeline[S, _]];
  }

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
