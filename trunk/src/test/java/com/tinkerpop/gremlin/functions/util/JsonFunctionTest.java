package com.tinkerpop.gremlin.functions.util;

import junit.framework.TestCase;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class JsonFunctionTest extends TestCase {

    //todo: I need a good way to test this function? any ideas anyone?

    public void testJsonSimple() {
        JSONObject object = new JSONObject();
        object.put("key1", "value1");
        JSONObject object2 = new JSONObject();
        object2.put("key0", 123);
        object.put("key2", object2);
        //System.out.println(object.toJSONString());
        List list = new ArrayList();
        list.add(1);
        list.add("marko");
    }
}
