package com.tinkerpop.gremlin.scala

/*
import org.specs2.mutable._
import com.tinkerpop.blueprints.pgm.{Vertex, Graph, Edge}
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory.createTinkerGraph
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.scala.{ScalaGraph, ScalaFluentPipeline}

class ScalaWrapperTest extends SpecificationWithJUnit {
  "The ScalaFluentPipeline wrapper" should {
    "be a Scala Iterator" in {
      val g = createTinkerGraph()
      val vs = g.getVertices.iterator
      val i: Iterator[Any] = new ScalaFluentPipeline(new GremlinPipeline(g).V())

      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beFalse
    }

    "implicitly wrap a PipesPipeline" in {
      val g = createTinkerGraph()
      val sfp: ScalaFluentPipeline[_, _] = new GremlinPipeline(g).V()

      //sfp must_!= null // <===== weird compiler errors on this line...
      sfp.isInstanceOf[ScalaFluentPipeline[_, _]] must beTrue
    }

    "implicitly wrap a PipesPipeline when calling an Iterable method" in {
      val g = createTinkerGraph()
      val i: Iterable[Any] = new GremlinPipeline(g).V().toIterable

      i must_!= null
    }

    "unwrap ScalaFluentPipeline => PipesPipeline" in {
      val g = createTinkerGraph()
      val fp: GremlinPipeline[_, _] = new GremlinPipeline(g)
      val sfp: ScalaFluentPipeline[_, _] = fp
      def toString(p: GremlinPipeline[_, _]) = p.toString

      toString(fp) must_== toString(sfp) //sfp must be unwrapped when passed to toString
    }
  }

  "The ScalaGraph wrapper" should {
    "return all vertices using V" in {
      val g = createTinkerGraph()
      val vs = g.V.toIterable

      vs must have size (6)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
      vs must contain(g getVertex 5)
      vs must contain(g getVertex 6)
    }

    "return all edges using E" in {
      val g = createTinkerGraph()
      val es = g.E.toIterable

      es must have size (6)
      es must contain(g getEdge 7)
      es must contain(g getEdge 8)
      es must contain(g getEdge 9)
      es must contain(g getEdge 10)
      es must contain(g getEdge 11)
      es must contain(g getEdge 12)
    }

    "return vertices with specified IDs using v" in {
      val g = createTinkerGraph()
      val vs = g.v(1, 2, 3)

      vs must have size (3)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)

      //ensures that v(ids: Any*) works with Java types
      val j1: java.lang.Integer = 1
      val j2: java.lang.Integer = 2
      val j3: java.lang.Integer = 3
      val vs2 = g.v(j1, j2, j3)
      vs2 must have size (3)
      vs2 must contain(g getVertex 1)
      vs2 must contain(g getVertex 2)
      vs2 must contain(g getVertex 3)
    }

    //TODO return edges with specified IDs using e
    //TODO addVertex
    //TODO addEdge

    "unwrap ScalaGraph => Graph" in {
      val g = createTinkerGraph()
      val sg: ScalaGraph = g
      def toString(graph: Graph) = graph.toString

      toString(g) must_== toString(sg) //sg must be unwrapped when passed to toString
    }
  }

  "The ScalaVertex wrapper" should {
    "return all out vertices using out" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(1).out.toIterable

      vs must have size (3)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
    }

    "return proper out vertices using out with label" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(1).out("knows").toIterable

      vs must have size (2)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 4)
    }

    "return all out edges using outE" in {
      val g = createTinkerGraph()
      val es = g.getVertex(1).outE.toIterable

      es must have size (3)
      es must contain(g getEdge 7)
      es must contain(g getEdge 8)
      es must contain(g getEdge 9)
    }

    "return all out edges using outE with label" in {
      val g = createTinkerGraph()
      val es = g.getVertex(1).outE("knows").toIterable

      es must have size (2)
      es must contain(g getEdge 7)
      es must contain(g getEdge 8)
    }

    "return all in vertices using in" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(3).in.toIterable

      vs must have size (3)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 4)
      vs must contain(g getVertex 6)
    }

    "return all in vertices using in with label" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(3).in("created").toIterable

      vs must have size (3)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 4)
      vs must contain(g getVertex 6)
    }

    "return all in edges using inE" in {
      val g = createTinkerGraph()
      val es = g.getVertex(3).inE.toIterable

      es must have size (3)
      es must contain(g getEdge 9)
      es must contain(g getEdge 11)
      es must contain(g getEdge 12)
    }

    "return all in edges using inE with label" in {
      val g = createTinkerGraph()
      val es = g.getVertex(3).inE("created").toIterable

      es must have size (3)
      es must contain(g getEdge 9)
      es must contain(g getEdge 11)
      es must contain(g getEdge 12)
    }

    "return all out and in vertices using both" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(4).both.toIterable

      vs must have size (3)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 5)
    }

    "return all out and in vertices using both with label" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(4).both("created").toIterable

      vs must have size (2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 5)
    }

    "return all out and in edges using bothE" in {
      val g = createTinkerGraph()
      val es = g.getVertex(4).bothE.toIterable

      es must have size (3)
      es must contain(g getEdge 8)
      es must contain(g getEdge 11)
      es must contain(g getEdge 10)
    }

    "return all out and in edges using bothE with label" in {
      val g = createTinkerGraph()
      val es = g.getVertex(4).bothE("created").toIterable

      es must have size (2)
      es must contain(g getEdge 11)
      es must contain(g getEdge 10)
    }

    "unwrap ScalaVertex => Vertex" in {
      val g = createTinkerGraph()
      val v1: Vertex = g getVertex 1
      val v2: ScalaVertex = v1
      def toString(v: Vertex) = v.toString

      toString(v1) must_== toString(v2) //v2 must be unwrapped when passed to toString
    }
  }

  "The ScalaEdge wrapper" should {
    "return the in vertex using inV" in {
      val g = createTinkerGraph()
      val v = g.getEdge(7).inV.toIterable

      v must have size (1)
      v must contain(g getVertex 2)
    }

    "return the out vertex using outV" in {
      val g = createTinkerGraph()
      val v = g.getEdge(7).outV.toIterable

      v must have size (1)
      v must contain(g getVertex 1)
    }

    "return the out and in vertices using bothV" in {
      val g = createTinkerGraph()
      val v = g.getEdge(7).bothV.toIterable

      v must have size (2)
      v must contain(g getVertex 1)
      v must contain(g getVertex 2)
    }

    "unwrap ScalaEdge => Edge" in {
      val g = createTinkerGraph()
      val e = g getEdge 7
      val se: ScalaEdge = e
      def toString(edge: Edge) = edge.toString

      toString(e) must_== toString(se) //se must be unwrapped when passed to toString
    }
  }
}
*/
