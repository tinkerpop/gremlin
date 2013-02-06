println 'Using aX arguments'
println a1 + a2
assert (a1 + a2) == "12"
println a3
g = TinkerGraphFactory.createTinkerGraph();
println g.V.out.out.count()

println 'Using args[x] arguments'
println args[0] + args[1]
assert (args[0] + args[1]) == "12"
println args[2]
g = TinkerGraphFactory.createTinkerGraph();
println g.V.out.out.count()