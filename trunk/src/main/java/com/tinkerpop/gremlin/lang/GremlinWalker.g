tree grammar GremlinWalker;

options {
  tokenVocab=GremlinLexer;
  ASTLabelType=CommonTree;
}

@header {
package com.tinkerpop.gremlin.lang;
}

program : statement+;

integer : INTEGER;
real 	: REAL;
string 	: STRING;
path	: PATH;

value : integer | real | string | path ;
variable : VARIABLE;
terminator : NEWLINE | EOF;	 	

 		
statement : ^(ASSIGN variable value) {System.out.println($variable.text + " here dude " + $value.text);}
	  | value {System.out.println("marko: " + $value.text);};
