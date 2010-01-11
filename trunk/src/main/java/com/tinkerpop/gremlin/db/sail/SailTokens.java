package com.tinkerpop.gremlin.db.sail;

import com.tinkerpop.gremlin.statements.EvaluationException;
import org.openrdf.rio.RDFFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SailTokens {
    public static final String NAMESPACE_SEPARATOR = ":";
    public static final String XSD_PREFIX = "xsd";
    public static final String XSD_NS = "http://www.w3.org/2001/XMLSchema#";
    public static final String RDF_PREFIX = "rdf";
    public static final String RDF_NS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    public static final String RDFS_PREFIX = "rdfs";
    public static final String RDFS_NS = "http://www.w3.org/2000/01/rdf-schema#";
    public static final String OWL_PREFIX = "owl";
    public static final String OWL_NS = "http://www.w3.org/2002/07/owl#";
    public static final String FOAF_PREFIX = "foaf";
    public static final String FOAF_NS = "http://xmlns.com/foaf/0.1/";
    public static final String BLANK_NODE_PREFIX = "_:";
    public static final String URN_UUID_PREFIX = "urn:uuid:";

    public static final String DATATYPE = "type";
    public static final String LANGUAGE = "lang";
    public static final String VALUE = "value";

    public static final Map<String, RDFFormat> formats = new HashMap<String, RDFFormat>();

    static {
        formats.put("rdf-xml", RDFFormat.RDFXML);
        formats.put("n-triples", RDFFormat.NTRIPLES);
        formats.put("turtle", RDFFormat.TURTLE);
        formats.put("n3", RDFFormat.N3);
        formats.put("trix", RDFFormat.TRIX);
        formats.put("trig", RDFFormat.TRIG);

    }

    public static RDFFormat getFormat(String format) {
        RDFFormat ret = formats.get(format);
        if (null == ret)
            throw new EvaluationException(format + " is an unsupported RDF file format. Use rdf-xml, n-triples, turtle, n3, trix, or trig");
        else
            return ret;
    }

}
