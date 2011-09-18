Strictly speaking, you cannot have duplicated egdes with the same id.
This example finds edges with same outV/inV/label/properties.

Here is an example to create a duplicated edge:

```
gremlin> g = TinkerGraphFactory.createTinkerGraph()
==>tinkergraph[vertices:6 edges:6]
gremlin> g.v(1).outE('created')
==>e[9][1-created->3]
gremlin> g.addEdge(null, g.v(1), g.v(3), "created", g.e(9).map()) // see note
==>e[0][1-created->3]
gremlin> g.v(1).outE('created')
==>e[0][1-created->3]
==>e[9][1-created->3]
gremlin> ElementHelper.haveEqualProperties(g.e(9), g.e(0))
==>true
```

note: another way to copy properties between edges is ElementHelper.copyProperties(g.e(9), g.e(0)) 

Q: how to detect such duplicated edges?
A: check outV/inV/label/properties

Assuming e is the edge to check:

```
gremlin> e = g.e(9)
==>e[9][1-created->3]
```

Here is the magicheck:

```
gremlin> e.outV.outE(e.label).filter{ElementHelper.haveEqualProperties(e,it)}.as('e').inV.filter{it==e.inV.next()}.back('e').except([e])
==>e[0][1-created->3]

```