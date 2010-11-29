package com.tinkerpop.gremlin.functions.g;

import com.tinkerpop.gremlin.functions.AbstractFunctions;
import com.tinkerpop.gremlin.functions.g.bool.BooleanFunction;
import com.tinkerpop.gremlin.functions.g.bool.NotFunction;
import com.tinkerpop.gremlin.functions.g.graph.*;
import com.tinkerpop.gremlin.functions.g.ime.*;
import com.tinkerpop.gremlin.functions.g.io.PrintFunction;
import com.tinkerpop.gremlin.functions.g.number.*;
import com.tinkerpop.gremlin.functions.g.string.*;
import com.tinkerpop.gremlin.functions.g.util.*;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "g";

    public GremlinFunctions() {
        // bool
        functions.add(new BooleanFunction());
        functions.add(new NotFunction());
        // graph
        functions.add(new AddAutoIndexKeyFunction());
        functions.add(new AddEdgeFunction());
        functions.add(new AddIndexFunction());
        functions.add(new AddVertexFunction());
        functions.add(new ClearFunction());
        functions.add(new CloseFunction());
        functions.add(new CopyVertexEdgeFunction());
        functions.add(new DropIndexFunction());
        functions.add(new GetTransactionModeFunction());
        functions.add(new IdEdgeFunction());
        functions.add(new IdVertexFunction());
        functions.add(new KeyEdgeFunction());
        functions.add(new KeyVertexFunction());
        functions.add(new LoadFunction());
        functions.add(new RemoveAutoIndexKeyFunction());
        functions.add(new RemoveVertexEdgeFunction());
        functions.add(new SaveFunction());
        functions.add(new SetTransactionModeFunction());
        functions.add(new ShowAutoIndexKeysFunction());
        functions.add(new ShowIndicesFunction());
        functions.add(new StartTransactionFunction());
        functions.add(new StopTransactionFunction());
        // io
        functions.add(new PrintFunction());
        // ime
        functions.add(new AppendFunction());
        functions.add(new DeduplicateFunction());
        functions.add(new DifferenceFunction());
        functions.add(new ExceptFunction());
        functions.add(new FlattenFunction());
        functions.add(new GetFunction());
        functions.add(new IncludesFunction());
        functions.add(new IntersectFunction());
        functions.add(new KeysFunction());
        functions.add(new ListFunction());
        functions.add(new MapFunction());
        functions.add(new OperateValueFunction());
        functions.add(new PathFunction());
        functions.add(new RetainFunction());
        functions.add(new SetFunction());
        functions.add(new SortFunction());
        functions.add(new UnionFunction());
        functions.add(new ValuesFunction());
        // number
        functions.add(new CeilingFunction());
        functions.add(new CountFunction());
        functions.add(new DoubleFunction());
        functions.add(new FloatFunction());
        functions.add(new FloorFunction());
        functions.add(new IntegerFunction());
        functions.add(new LongFunction());
        functions.add(new PowerFunction());
        functions.add(new RandomNaturalFunction());
        functions.add(new RandomRealFunction());
        functions.add(new RangeFunction());
        functions.add(new SumFunction());
        functions.add(new RoundFunction());
        // string
        functions.add(new ConcatFunction());
        functions.add(new ContainsFunction());
        functions.add(new MatchesFunction());
        functions.add(new NormalizeSpaceFunction());
        functions.add(new ReplaceFunction());
        functions.add(new StartsWithFunction());
        functions.add(new StringFunction());
        functions.add(new StringLengthFunction());
        functions.add(new SubstringAfterFunction());
        functions.add(new SubstringBeforeFunction());
        functions.add(new SubstringFunction());
        functions.add(new TranslateFunction());
        // util
        functions.add(new AssignFunction());
        functions.add(new FromJsonFunction());
        functions.add(new PFunction());
        functions.add(new TimeFunction());
        functions.add(new ToJsonFunction());
        functions.add(new TypeFunction());
        functions.add(new UnassignFunction());
        functions.add(new VersionFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }


}
