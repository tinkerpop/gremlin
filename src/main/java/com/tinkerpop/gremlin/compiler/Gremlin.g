grammar Gremlin;

options {
	output=AST;
    ASTLabelType=CommonTree;
    backtrack=true;
}

tokens {
	VAR;
	ARG;
	ARGS;
	
	FUNC;
	NS; // function namespace
	NAME; // function local name
	FUNC_NAME; // function name : namespace? : local_function_name
	
	PATH;
	GPATH;
	
	STEP;
	TOKEN;
	PREDICATE;
	PREDICATES;
	
	// tokens
	SELF; // represents '.'
	HISTORY; // represents '..'
	
	FUNC_CALL;

	IF;
	COND;
	BLOCK;
	
	FOREACH;
	WHILE;
	REPEAT;
	INCLUDE;
	
	// for atoms
    NUM;
	STR;
    ARR;

    BOOL;
    NULL;
    ARR_IDX;

	PROPERTY_CALL;
	VARIABLE_CALL;
}

program	
    :	COMMENT+
    |   (statement? NEWLINE)+
	;

COMMENT
    : '#' .* NEWLINE {skip();}
    ;

gpath_statement
	:	step '/' step ('/' step)* -> ^(GPATH step+)
	;

step	
    :	token ('[' statement ']')* -> ^(STEP ^(TOKEN token) ^(PREDICATES ^(PREDICATE statement)*))
    ;

token	
	: 	expression
	;

statement
    :   if_statement
	|	foreach_statement
	|	while_statement
	|	repeat_statement
	|	path_definition_statement
	|	function_definition_statement
	|	include_statement
	|	gpath_statement
	|	VARIABLE ':=' statement -> ^(VAR VARIABLE statement)
	|	expression (('and'^|'or'^) expression)*
	;

include_statement
	:	'include' StringLiteral -> ^(INCLUDE StringLiteral)
	;
	
if_statement 
	:	'if' statement NEWLINE 
           block 
        'end' -> ^(IF ^(COND statement) block)
	;

foreach_statement
	:	'foreach' VARIABLE 'in' statement NEWLINE 
	       block 
	    'end' -> ^(FOREACH VARIABLE statement block)
	;
	
while_statement
	:	'while' statement NEWLINE 
	       block 
	    'end' -> ^(WHILE ^(COND statement) block)
	;

repeat_statement
	:	'repeat' statement NEWLINE
		   block
		'end' -> ^(REPEAT statement block)
	;
	
path_definition_statement
	:	'path' IDENTIFIER NEWLINE
		   statement NEWLINE
		'end' -> ^(PATH IDENTIFIER statement)
	;
	
function_definition_statement
	:	'func' function_name '(' formal_arguments* ')' NEWLINE
		   block
		'end' -> ^(FUNC function_name ^(ARGS formal_arguments*) block) 
	;
	
formal_arguments
	:	VARIABLE (',' VARIABLE)* -> ^(ARG VARIABLE)+
	;

block	
    :	(statement | NEWLINE)* -> ^(BLOCK statement*)
	;
	
expression
	:	operation (('='^ | '!='^ | '<'^ | '<='^ | '>'^ | '>='^) operation)*
	;
	
operation
	:	binary_operation (('+'^|'-'^) binary_operation)*
	;
	
binary_operation
	:	atom (('*'^|'div'^) atom)*
	;
	
function_call
	:	function_name '(' function_call_params* ')' -> ^(FUNC_CALL function_name ^(ARGS function_call_params*))
	;
	
function_name
	:	ns=IDENTIFIER ':' ln=IDENTIFIER -> ^(FUNC_NAME ^(NS $ns) ^(NAME $ln))   // namespace : local_function_name
	;
	
function_call_params
	:	statement (',' statement)* -> ^(ARG statement)+
	;
	
atom
	:	NUMBER		    -> ^(NUM NUMBER)
	|	StringLiteral	-> ^(STR StringLiteral)
    |   b=BOOLEAN       -> ^(BOOL $b)
    |   NULL
	|	PROPERTY	    -> ^(PROPERTY_CALL PROPERTY)
	|	VARIABLE        -> ^(VARIABLE_CALL VARIABLE)
	|	IDENTIFIER
	|	function_call
	|	'('! statement ')'!
	;

StringLiteral
	: '"' DoubleStringCharacter* '"'
	| '\'' SingleStringCharacter* '\''
	;
		
BOOLEAN
    : 'true'
    | 'false'
    ;

NULL
    : 'null'
    ;

/*
array
    : NUMBER '|'! NUMBER ('|'! NUMBER)*
    ;
*/
NUMBER	
    : 	('0'..'9')+ ('.' ('0'..'9')+)? 
	;
		
VARIABLE 
	:	'$' IDENTIFIER
	;
	
PROPERTY
	:	'@' IDENTIFIER	
	;
	
IDENTIFIER 
	: 	('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')+
    ;

NEWLINE
	: '\n'		// Line feed.
	| '\r'		// Carriage return.
	| '\u2028'	// Line separator.
	| '\u2029'	// Paragraph separator.
	;

WS      
    : (' '|'\t')+ {skip();}  //(' '|'\t'|'\n'|'\r')+ {skip();} 
	;
	
fragment DoubleStringCharacter
	: ~('"' | '\\' | NEWLINE)	
	| '\\' EscapeSequence
	;

fragment SingleStringCharacter
	: ~('\'' | '\\' | NEWLINE)	
	| '\\' EscapeSequence
	;

fragment EscapeSequence
	: CharacterEscapeSequence
	| '0'
	| HexEscapeSequence
	| UnicodeEscapeSequence
	;

fragment CharacterEscapeSequence
	: SingleEscapeCharacter
	| NonEscapeCharacter
	;

fragment NonEscapeCharacter
	: ~(EscapeCharacter | NEWLINE)
	;

fragment SingleEscapeCharacter
	: '\'' | '"' | '\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v'
	;

fragment EscapeCharacter
	: SingleEscapeCharacter
	| DecimalDigit
	| 'x'
	| 'u'
	;
	
fragment HexEscapeSequence
	: 'x' HexDigit HexDigit
	;
	
fragment UnicodeEscapeSequence
	: 'u' HexDigit HexDigit HexDigit HexDigit
	;

fragment HexDigit
	: DecimalDigit | ('a'..'f') | ('A'..'F')
	;

fragment DecimalDigit
	: ('0'..'9')
	;

