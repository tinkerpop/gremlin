package com.tinkerpop.gremlin

import org.specs2.mutable._
import com.tinkerpop.blueprints.pgm.{Graph, Vertex}
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.PipeFunction
import com.tinkerpop.pipes.util.FluentPipeline
import com.tinkerpop.gremlin.scala._

class ScalaWrapperTest extends SpecificationWithJUnit {
  "The ScalaFluentPipeline wrapper" should {
    "be a Scala Iterator" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val i: Iterator[Any] = new ScalaFluentPipeline(new FluentPipeline(g).V())
      
      //TODO assert that the proper values come out of the next() calls
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beTrue
      i.next()  must_!= null
      i.hasNext must beFalse
    }
    
    "implicitly wrap a FluentPipeline" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val sfp: ScalaFluentPipeline[_,_] = new FluentPipeline(g).V()
      
      //sfp must_!= null // <===== weird compiler errors on this line...
      sfp.isInstanceOf[ScalaFluentPipeline[_,_]] must beTrue
    }
    
    "implicitly wrap a FluentPipeline when calling an Iterable method" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val i: Iterable[Any] = new FluentPipeline(g).V().toIterable
      
      i must_!= null
    }
    
    "unwrap ScalaFluentPipeline => FluentPipeline" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val fp: FluentPipeline[_,_] = new FluentPipeline(g)
      val sfp: ScalaFluentPipeline[_,_] = fp
      def toString(p: FluentPipeline[_,_]) = p.toString
      
      toString(fp) must_== toString(sfp) //sfp must be unwrapped when passed to print
    }
  }
  
  "The ScalaGraph wrapper" should {
    "return all vertices using V" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val vs = g.V.toIterable
      
      vs must have size(6)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
      vs must contain(g getVertex 5)
      vs must contain(g getVertex 6)
    }
    
    //TODO graph.E
    //TODO graph.v(id)
    //TODO unwrap ScalaGraph => Graph
  }
  
  "The ScalaVertex wrapper" should {
    "return all out vertices using out" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val vs = g.getVertex(1).out.toIterable
      
      vs must have size(3)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
    }
    
    "return proper out vertices using out with label" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val vs = g.getVertex(1).out("knows").toIterable
      
      vs must have size(2)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 4)
    }
    
    //TODO vertex.outE and vertex.outE()
    //TODO vertex.in and vertex.in(label)
    //TODO vertex.inE and vertex.inE(label)
    //TODO vertex.both and vertex.bothE(label)
    
    "get unwrapped by the implicit" in {
      val g = TinkerGraphFactory.createTinkerGraph()
      val v1: Vertex = g getVertex 1
      val v2: ScalaVertex = v1
      def toString(v: Vertex) = v.toString
      
      toString(v1) must_== toString(v2) //v2 must be unwrapped when passed to toString
    }
  }
  
  /*"The ScalaEdge wrapper" should {
    //TODO edge.inV
    //TODO edge.outV
    //TODO edge.bothV
    //TODO unwrap ScalaEdge => Edge
  }*/
}
