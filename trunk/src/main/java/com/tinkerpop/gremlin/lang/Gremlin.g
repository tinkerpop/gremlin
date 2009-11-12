grammar Gremlin;

options {
	output=AST;
	tokenVocab = GremlinLexer;	
}

@header { package com.tinkerpop.gremlin.lang; }

program : statement+;

integer : INTEGER;
real 	: REAL;
string 	: STRING;
path	: PATH;

value : integer | real | string | path;
variable : VARIABLE;
terminator : NEWLINE | EOF;	 	

 		
statement : variable ASSIGN value terminator -> ^(ASSIGN variable value) | value terminator -> ^(value);	
	






