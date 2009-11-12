/**
XPath parser, based on XPath v1 grammar defined by W3C.
http://www.w3.org/TR/xpath

I would like to remark that the AST output produced by this grammar 
still requires a tree grammar to properly disambiguate the resulting
trees. This is due to the fact that only needed to perform a single
pass over an XPath expression.

As usual, this grammar is free to use and modify. Contact me if you
need more information.

jjzazuet@gmail.com
*/

grammar XPath1;
options { output = AST; }

tokens {
    QNAME; STRING; NUMBER; VARREF; 
    OREXPR; ANDEXPR; UNIONEXPR; EQUEXPRESSION; 
    PREDICATE; FUNCALL;
    NAMED_AXIS_STEP; SIMPLE_AXIS_STEP; ABBREVIATED_AXIS_STEP;
    NAME_AXIS; ATTRIBUTE_AXIS;
    EXPRLIST;
    ANY_NODE; ANY_NAMESPACED_NODE;
}

// ---------------- Parser Rules ---------------- //
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
    : ( SingleAxisStep    -> ^(SIMPLE_AXIS_STEP SingleAxisStep)
      | RecursiveAxisStep -> ^(SIMPLE_AXIS_STEP RecursiveAxisStep)
      )
    ;

abbreviatedAxisStep
    : AbbreviatedStep -> ^(ABBREVIATED_AXIS_STEP AbbreviatedStep);

namedAxisStep
    : (axisSpecifier? nodeTest) -> ^(NAMED_AXIS_STEP axisSpecifier? nodeTest);

axisSpecifier
    : AxisName AxisNameSeparator -> ^(NAME_AXIS AxisName)
    | AbbreviatedAxisSpecifier -> ^(ATTRIBUTE_AXIS AbbreviatedAxisSpecifier)
    ;

nodeTest
	: nameTest 
	| NodeType LeftParenthesis RightParenthesis -> ^(ANY_NODE NodeType)
	| ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis
	; 

nameTest 
    : Star -> ^(ANY_NODE)
    | NCName Colon Star -> ^(ANY_NAMESPACED_NODE NCName)
    | qName
    ;

predicate
    : LeftSquareBracket predicateExpr RightSquareBracket -> ^(PREDICATE predicateExpr)
    ;

predicateExpr : expr;
    
functionCall
	: qName LeftParenthesis
	  expressionList? 
	  RightParenthesis -> ^(FUNCALL qName expressionList?)
	;
	
expressionList
    : expr ( Comma expr )* -> ^(EXPRLIST expr+)
    ;	

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

orExpr: andExpr (Or andExpr)* -> ^(OREXPR andExpr+);

andExpr: equalityExpr (And equalityExpr)? -> ^(ANDEXPR equalityExpr+);

equalityExpr
    : relationalExpr (EqualtyOp relationalExpr)? -> ^(EQUEXPRESSION relationalExpr (EqualtyOp relationalExpr)?);
    
relationalExpr: unionExpr;

unionExpr: pathExpr (Pipe pathExpr)? -> ^(UNIONEXPR pathExpr+);

literal 
    : StringLiteral -> ^(STRING StringLiteral)
    | numericLiteral -> ^(NUMBER numericLiteral)
    | VariableReference -> ^(VARREF VariableReference)
    ;
    
numericLiteral: IntegerLiteral | DecimalLiteral | DoubleLiteral;

qName: (NCName Colon)? NCName -> ^(QNAME NCName+);

// ---------------- Lexer Rules ---------------- //
SingleAxisStep: '/';   
RecursiveAxisStep: '//';

AxisNameSeparator: '::';
AbbreviatedAxisSpecifier: '@';

Star:      '*';
Colon:     ':';
Comma:     ',';
Pipe:      '|';

AbbreviatedStep : '.' | '..';

LeftParenthesis: '(';    	
RightParenthesis: ')';

LeftSquareBracket: '[';
RightSquareBracket: ']';

And	: 'and';
Or	: 'or';

AxisName
    :  'ancestor'  | 'ancestor-or-self'  | 'attribute' |
       'child'     | 'descendant'        | 'descendant-or-self' |
       'following' | 'following-sibling' | 'namespace' |
       'parent'    | 'preceding'         | 'preceding-sibling' |
       'self'
    ;

ProcessingInstruction:  'processing-instruction';

NodeType
	:  'comment' | 'text' | ProcessingInstruction | 'node';

Letter
    :  '\u0024' | '\u005f'|
       '\u0041'..'\u005a' | '\u0061'..'\u007a' | 
       '\u00c0'..'\u00d6' | '\u00d8'..'\u00f6' | 
       '\u00f8'..'\u00ff' | '\u0100'..'\u1fff' | 
       '\u3040'..'\u318f' | '\u3300'..'\u337f' | 
       '\u3400'..'\u3d2d' | '\u4e00'..'\u9fff' | 
       '\uf900'..'\ufaff'
    ;

IntegerLiteral :  ('0'..'9')+;
DecimalLiteral :  ('.' ('0'..'9')+)  | (('0'..'9')+ '.' '0'..'9'*);
DoubleLiteral  :  (('.' ('0'..'9')+) | (('0'..'9')+ ('.' '0'..'9'*)?)) ('e' | 'E') ('+' | '-')? ('0'..'9')+;

StringLiteral : '"' ~('"')* '"' | '\'' ~('\'')* '\'';

EqualtyOp: '=' | '!=';

VariableReference: '$' NCName;

NCName : Letter (Letter | '0'..'9' | '.' | '-')*;

WS: (' '|'\t'|'\u000C') {skip();};
