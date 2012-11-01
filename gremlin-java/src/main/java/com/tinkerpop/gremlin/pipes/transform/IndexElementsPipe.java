package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Index;
import com.tinkerpop.pipes.transform.IdentityPipe;
import com.tinkerpop.pipes.transform.TransformPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IndexElementsPipe<E extends Element> extends IdentityPipe<E> implements TransformPipe {

    public IndexElementsPipe(final Index<E> index, final String key, final Object value) {
        super.setStarts(index.get(key, value).iterator());
    }
}
