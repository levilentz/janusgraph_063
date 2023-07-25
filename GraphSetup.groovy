:remote connect tinkerpop.server conf/remote.yaml session
:remote console
//CREATE Template Configuration
map = new HashMap<>()
map.put('storage.backend', 'cql')
map.put('storage.hostname', 'cassandra')
map.put('storage.username', 'cassandra')
map.put('storage.password', 'cassandra')
map.put('storage.cql.keyspace', 'janusgraph-configuredgraphmanangement')
map.put('schema.default', 'none')
map.put('storage.batch-loading',true)
map.put('storage.buffer-size',10000)
conf = new MapConfiguration(map)
ConfiguredGraphFactory.createTemplateConfiguration(conf)

//CREATE toyGraph
map = ConfiguredGraphFactory.getConfiguration()
map.put('storage.cql.keyspace', 'graphs_janusgraph_toygraph')
map.put('graph.graphname', 'toygraph')
conf = new MapConfiguration(map)
ConfiguredGraphFactory.createConfiguration(conf)

//CREATE graph of the gods graph and schema (see: https://docs.janusgraph.org/getting-started/basic-usage/ for more examples)
mgmt = ConfiguredGraphFactory.open('toygraph').openManagement()
graph = ConfiguredGraphFactory.open('toygraph')
GraphOfTheGodsFactory.loadWithoutMixedIndex(graph,true)

