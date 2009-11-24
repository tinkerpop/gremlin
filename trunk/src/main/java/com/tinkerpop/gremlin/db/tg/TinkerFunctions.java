package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.db.tg.parser.TinkerGraphML;

import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerFunctions {

    public static final String NAMESPACE_PREFIX = "tg";

    public static TinkerGraph open_tg(String graphFile) {
        // this returns the hardcoded graph-example-1 graph until I can implement a tinker graph serialization
        return TinkerGraphFactory.createTinkerGraph();
        /*try {
            return TinkerGraphML.generateGraph(new FileInputStream(graphFile));
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(XMLStreamException e) {
            System.out.println(e);
        }
        return null;*/
    }

}
