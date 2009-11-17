tree grammar GremlinTree;

options {
  ASTLabelType = CommonTree;
  tokenVocab = Gremlin;
}

@header {
package com.tinkerpop.gremlin.parse;

import com.tinkerpop.gremlin.Evaluator;
}

@members {
        
        protected Evaluator evaluator;
        
        public GremlinTree(TreeNodeStream input, Evaluator evaluator) {
            this(input, new RecognizerSharedState());
            this.evaluator = evaluator;
        }	
}

// PARSER RULES
statement : gpath Newline?;	

foreach : ^(FOREACH ^(VARREF VariableReference) ^(FORSET set=gpath) ^(LOOPBODY loop=gpath))
{
	System.out.println("this is a foreach statement: " + $FOREACH.text);
};	

gpath	: ^(GPATH xpath){ evaluator.evaluate("marko");}
	| ^(GPATH functionCall){ evaluator.evaluate("paul");}
	| ^(GPATH literal) {evaluator.evaluate($literal.value);};
	 


xpath: locationPath;

locationPath 
    : relativeLocationPath 
    | absoluteLocationPath
    ;
    
absoluteLocationPath 
    : SingleAxisStep relativeLocationPath?
    | abbreviatedAbsoluteLocationPath
    ;

abbreviatedAbsoluteLocationPath: RecursiveAxisStep relativeLocationPath;

relativeLocationPath 
    : step 
    ( simpleAxisStep step )*
    ;

step
    : ( namedAxisStep | abbreviatedAxisStep ) predicate*
    ;

simpleAxisStep
    : ( SingleAxisStep//    -> ^(SIMPLE_AXIS_STEP SingleAxisStep)
      | RecursiveAxisStep// -> ^(SIMPLE_AXIS_STEP RecursiveAxisStep)
      )
    ;

abbreviatedAxisStep: AbbreviatedStep;// -> ^(ABBREVIATED_AXIS_STEP AbbreviatedStep);

namedAxisStep: (axisSpecifier? nodeTest); //-> ^(NAMED_AXIS_STEP axisSpecifier? nodeTest);

axisSpecifier
    : AxisName AxisNameSeparator //-> ^(NAME_AXIS AxisName)
    | AbbreviatedAxisSpecifier //-> ^(ATTRIBUTE_AXIS AbbreviatedAxisSpecifier)
    ;

nodeTest
	: nameTest 
	| NodeType LeftParenthesis RightParenthesis //-> ^(ANY_NODE NodeType)
	| ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis
	; 

nameTest 
    : Star //-> ^(ANY_NODE)
    | NCName Colon Star //-> ^(ANY_NAMESPACED_NODE NCName)
    | qName
    ;

predicate: LeftSquareBracket predicateExpr RightSquareBracket;// -> ^(PREDICATE predicateExpr);

predicateExpr : expr;
    
functionCall: ^(FUNCALL qName)//^(FUNCALL qName expressionList?)
	;
	
expressionList : expr ( Comma expr )*;//-> ^(EXPRLIST expr+);	

pathExpr
    : locationPath
    | filterExpr (simpleAxisStep  relativeLocationPath)?
    ;

filterExpr: primaryExpr predicate?;

primaryExpr
    : LeftParenthesis expr RightParenthesis
    | literal
    | functionCall
    ;

expr: orExpr;

orExpr: andExpr (Or andExpr)*;//  -> ^(OREXPR andExpr+);

andExpr: equalityExpr (And equalityExpr)?;// -> ^(ANDEXPR equalityExpr+);

equalityExpr: relationalExpr (EqualtyOp relationalExpr)?;// -> ^(EQUEXPRESSION relationalExpr (EqualtyOp relationalExpr)?);
    
relationalExpr: unionExpr;

unionExpr: pathExpr (Pipe pathExpr)?; //-> ^(UNIONEXPR pathExpr+);

literal returns [String value]
    : StringLiteral {$value = $StringLiteral.text; } // -> ^(STRING StringLiteral)
    | IntegerLiteral	{$value = $IntegerLiteral.text; }
    | DecimalLiteral	{$value = $DecimalLiteral.text; }
    | DoubleLiteral	{$value = $DoubleLiteral.text; }
    | VariableReference {$value = $VariableReference.text; }// -> 
    ;
    

qName: ^(QNAME NCName+);