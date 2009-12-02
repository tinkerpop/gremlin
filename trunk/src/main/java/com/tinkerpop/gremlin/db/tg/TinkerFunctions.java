package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.parser.GraphMLReader;

import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerFunctions {

    public static final String NAMESPACE_PREFIX = "tg";

    public static TinkerGraph open_tg() {
        //this returns the hardcoded graph-example-1 graph until I can implement a tinker graph serialization
        return TinkerGraphFactory.createTinkerGraph();
    }
        
    public static TinkerGraph open_tg(String graphFile) {
        try {
            TinkerGraph graph = new TinkerGraph();
            GraphMLReader.inputGraph(graph, new FileInputStream(graphFile));
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }


}
