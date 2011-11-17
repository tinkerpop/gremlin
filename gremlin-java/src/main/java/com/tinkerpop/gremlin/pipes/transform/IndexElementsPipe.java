package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.pipes.transform.IdentityPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IndexElementsPipe<E extends Element> extends IdentityPipe<E> {

    public IndexElementsPipe(final Index<E> index, final String key, final Object value) {
        super.setStarts(index.get(key, value).iterator());
    }
}
