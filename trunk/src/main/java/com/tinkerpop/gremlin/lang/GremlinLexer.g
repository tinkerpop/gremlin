lexer grammar GremlinLexer;

@header { package com.tinkerpop.gremlin.lang; }

WHITESPACE: (' ' | '\t')+ { $channel = HIDDEN; };

NEWLINE : ('\r'? '\n')+;	

SINGLE_COMMENT: '//' ~('\r' | '\n')* NEWLINE { skip(); };

VARIABLE : '$' ('a'..'z' | 'A' .. 'Z') (('a'..'z') | ('A' .. 'Z') | ('0'..'9'))*;

ASSIGN	: ':=';	

fragment DIGIT : ('0'..'9');
INTEGER : ('1'..'9') DIGIT*;
REAL : ('0'..'9')+ '.' '0'..'9'*;
STRING : '"' ~('"')* '"' | '\'' ~('\'')* '\'';
PATH : '~' STRING;