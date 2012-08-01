-= Gremlin: A Graph Traversal Language =-

Gremlin is a domain specific language for traversing property graphs.
Gremlin makes use of a path-based syntax to support complex graph traversals.
Gremlin has application in the areas of graph query, analysis, and manipulation.

Gremlin connects to various graph databases including:
    * TinkerGraph
    * Neo4j
    * OrientDB
    * DEX
    * InfiniteGraph
    * Titan
    * Rexster
    * Sail RDF Stores

Gremlin documentation can be found online at:
  http://gremlin.tinkerpop.com

--------------- RUNNING GREMLIN ---------------

gremlin$ bin/gremlin.sh

         \,,,/
         (o o)
-----oOOo-(_)-oOOo-----
gremlin> g = TinkerGraphFactory.createTinkerGraph()
==>tinkergraph[vertices:6 edges:6]
gremlin> g.v(1)
==>v[1]
gremlin> g.v(1).name
==>marko
gremlin> g.v(1).out('knows').name
==>vadas
==>josh

NOTE: TinkerGraphFactory.createTinkerGraph() returns a hardcoded toy graph for the purposes of demonstration.

-----------------------------------------------

Gremlin is provided by TinkerPop [http://tinkerpop.com]
    "Open Source Software Products in the Graph Space"