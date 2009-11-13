parser grammar GremlinParser;

options {
	output=AST;
	tokenVocab = GremlinLexer;	
}

@header { package com.tinkerpop.gremlin.lang; }

program : statement+;

terminator : NEWLINE | EOF;

natural : NATURAL;
real 	: REAL;
string 	: STRING;
path	: PATH;
variable : VARIABLE;

value : natural | real | string | path | variable;
	 	 		
statement : variable ASSIGN value terminator -> ^(ASSIGN variable value) | value terminator -> ^(value);	
	






