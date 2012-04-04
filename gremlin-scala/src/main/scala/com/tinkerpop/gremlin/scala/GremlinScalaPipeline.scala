package com.tinkerpop.gremlin.scala

import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.blueprints.pgm._
import com.tinkerpop.pipes.{PipeFunction, Pipe}
import com.tinkerpop.pipes.branch.LoopPipe.LoopBundle
import java.util.{Map => JMap, List => JList, Iterator => JIterator, Collection => JCollection, ArrayList => JArrayList}
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.pipes.util.structures.{Tree, Table, Row, Pair => TPair}

class GremlinScalaPipeline[S, E] extends GremlinPipeline[S, E] {

  //def apply(key:String) = super.property(key);

  def out: GremlinScalaPipeline[S, Vertex] =
    super.out().asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  def in: GremlinScalaPipeline[S, Vertex] =
    super.in().asInstanceOf[GremlinScalaPipeline[S, Vertex]]

  def path: GremlinScalaPipeline[S, JList[_]] =
    super.path().asInstanceOf[GremlinScalaPipeline[S, JList[_]]]

  ////

  def has[F <: Element, T](key: String, value: T): GremlinScalaPipeline[S, F] =
    super.has(key, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  def has[F <: Element, T](key: String, comparison: Tokens.T, value: T): GremlinScalaPipeline[S, F] =
    super.has(key, comparison, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  def hasNot[F <: Element, T](key: String, value: T): GremlinScalaPipeline[S, F] =
    super.hasNot(key, value).asInstanceOf[GremlinScalaPipeline[S, F]]

  def hasNot[F <: Element, T](key: String, comparison: Tokens.T, value: T): GremlinScalaPipeline[S, F] =
    super.hasNot(key, comparison, value).asInstanceOf[GremlinScalaPipeline[S, F]]

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

  def step[F](f: JIterator[E] => F): GremlinScalaPipeline[S, F] =
    super.step(f).asInstanceOf[GremlinScalaPipeline[S, F]]

  override def step[F](pipe: Pipe[E, F]): GremlinScalaPipeline[S, F] =
    super.step(pipe).asInstanceOf[GremlinScalaPipeline[S, F]]

  ////////////////////
  /// BRANCH PIPES ///
  ////////////////////
  override def copySplit(pipes: Pipe[E, _]*): GremlinScalaPipeline[S, _] =
    super.copySplit(pipes: _*).asInstanceOf[GremlinScalaPipeline[S, _]]

  override def exhaustMerge: GremlinScalaPipeline[S, _] =
    super.exhaustMerge.asInstanceOf[GremlinScalaPipeline[S, _]]

  override def fairMerge: GremlinScalaPipeline[S, _] =
    super.fairMerge.asInstanceOf[GremlinScalaPipeline[S, _]]

  def ifThenElse(ifFunction: E => Boolean, thenFunction: E => _, elseFunction: E => _): GremlinScalaPipeline[S, _] =
    super.ifThenElse(ifFunction, thenFunction, elseFunction).asInstanceOf[GremlinScalaPipeline[S, _]]

  def loop(numberedStep: Int, whileFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(numberedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(namedStep: String, whileFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(namedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(numberedStep: Int, whileFunction: LoopBundle[E] => Boolean, emitFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(numberedStep, whileFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

  def loop(namedStep: String, whileFunction: LoopBundle[E] => Boolean, emitFunction: LoopBundle[E] => Boolean): GremlinScalaPipeline[S, E] =
    super.loop(namedStep, whileFunction, emitFunction).asInstanceOf[GremlinScalaPipeline[S, E]]

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

  override def dedup: GremlinScalaPipeline[S, E] = {
    super.dedup().asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def dedup(dedupFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.dedup(dedupFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def except(collection: JCollection[E]): GremlinScalaPipeline[S, E] = {
    super.except(collection).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def filter(filterFunction: E => Boolean): GremlinScalaPipeline[S, E] = {
    super.filter(filterFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
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

  override def retain(collection: JCollection[E]): GremlinScalaPipeline[S, E] = {
    super.retain(collection).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def simplePath: GremlinScalaPipeline[S, E] = {
    super.simplePath().asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  /////////////////////////
  /// SIDE-EFFECT PIPES ///
  /////////////////////////
  override def aggregate(aggregate: JCollection[E]): GremlinScalaPipeline[S, E] = {
    super.aggregate(aggregate).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def aggregate(aggregate: JCollection[_], aggregateFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.aggregate(aggregate, aggregateFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def aggregate(): GremlinScalaPipeline[S, E] = {
    super.aggregate(new JArrayList[E]()).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def aggregate(aggregateFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.aggregate(new JArrayList[Object](), aggregateFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def optional(numberedStep: Int): GremlinScalaPipeline[S, _] = {
    super.optional(numberedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def optional(namedStep: String): GremlinScalaPipeline[S, _] = {
    super.optional(namedStep).asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  override def groupBy(map: JMap[_, JList[_]], keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupBy(map, keyFunction, valueFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupBy(keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupBy(keyFunction, valueFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupBy(keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[_, _], reduceFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupBy(keyFunction, valueFunction, reduceFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupBy(reduceMap: JMap[_, _], keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[_, _], reduceFunction: PipeFunction[_, _]): GremlinScalaPipeline[S, E] = {
    super.groupBy(reduceMap, keyFunction, valueFunction, reduceFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(map: JMap[_, Number], keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[TPair[_, Number], Number]): GremlinScalaPipeline[S, E] = {
    super.groupCount(map, keyFunction, valueFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def groupCount(keyFunction: PipeFunction[_, _], valueFunction: PipeFunction[TPair[_, Number], Number]): GremlinScalaPipeline[S, E] = {
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

  def sideEffect(sideEffectFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.sideEffect(sideEffectFunction).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def store(storage: JCollection[E]): GremlinScalaPipeline[S, E] = {
    super.store(storage).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def store(storage: JCollection[_], storageFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.aggregate(storage, storageFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def store(): GremlinScalaPipeline[S, E] = {
    super.store(new JArrayList[E]()).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  def store(storageFunction: E => _): GremlinScalaPipeline[S, E] = {
    super.store(new JArrayList[Object](), storageFunction).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def table(table: Table, stepNames: JCollection[String], columnFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, E] = {
    super.table(table, stepNames, columnFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def table(table: Table, columnFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, E] = {
    super.table(table, columnFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def table(columnFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, E] = {
    super.table(columnFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def table(table: Table): GremlinScalaPipeline[S, E] = {
    super.table(table).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def table: GremlinScalaPipeline[S, E] = {
    super.table().asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def tree(tree: Tree[_], branchFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, E] = {
    super.tree(tree, branchFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def tree(branchFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, E] = {
    super.tree(branchFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  ///////////////////////
  /// TRANSFORM PIPES ///
  ///////////////////////
  override def gather: GremlinScalaPipeline[S, JList[_]] = {
    super.gather().asInstanceOf[GremlinScalaPipeline[S, JList[_]]];
  }

  def gather(function: JList[_] => JList[_]): GremlinScalaPipeline[S, JList[_]] = {
    super.gather(function).asInstanceOf[GremlinScalaPipeline[S, JList[_]]];
  }

  /*def _: GremlinPipeline[S, E] =
  {
    return this.add(new IdentityPipe[_])
  }*/

  override def memoize(namedStep: String): GremlinScalaPipeline[S, E] = {
    super.memoize(namedStep).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def memoize(numberedStep: Int): GremlinScalaPipeline[S, E] = {
    super.memoize(numberedStep).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def memoize(namedStep: String, map: JMap[_, _]): GremlinScalaPipeline[S, E] = {
    super.memoize(namedStep, map).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def memoize(numberedStep: Int, map: JMap[_, _]): GremlinScalaPipeline[S, E] = {
    super.memoize(numberedStep, map).asInstanceOf[GremlinScalaPipeline[S, E]];
  }

  override def path(pathFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, JList[_]] =
    super.path(pathFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, JList[_]]]

  override def select: GremlinScalaPipeline[S, Row[_]] = {
    super.select().asInstanceOf[GremlinScalaPipeline[S, Row[_]]]
  }

  override def select(stepFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, Row[_]] = {
    super.select(stepFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, Row[_]]]
  }

  override def select(stepNames: JCollection[String], stepFunctions: PipeFunction[_, _]*): GremlinScalaPipeline[S, Row[_]] = {
    super.select(stepNames, stepFunctions: _*).asInstanceOf[GremlinScalaPipeline[S, Row[_]]]
  }

  override def scatter: GremlinScalaPipeline[S, _] = {
    super.scatter().asInstanceOf[GremlinScalaPipeline[S, _]]
  }

  override def cap: GremlinScalaPipeline[S, _] = {
    super.cap().asInstanceOf[GremlinScalaPipeline[S, _]];
  }

  def transform[T](function: E => T): GremlinScalaPipeline[S, T] = {
    super.transform(function).asInstanceOf[GremlinScalaPipeline[S, T]]
  }

  //////////////////////
  /// UTILITY PIPES ///
  //////////////////////

  override def as(name: String): GremlinScalaPipeline[S, E] = {
    super.as(name).asInstanceOf[GremlinScalaPipeline[S, E]]
  }

  override def start(starts: S): GremlinScalaPipeline[S, S] = {
    super.start(starts).asInstanceOf[GremlinScalaPipeline[S, S]]
  }
}
