tree grammar Gremlin;

options {
  language=Java;
  tokenVocab=GremlinParser;
  ASTLabelType=CommonTree;
}

@header {
  package com.tinkerpop.gremlin.lang;
  
  import com.tinkerpop.gremlin.Evaluator;
}

@members {
   private Evaluator evaluator;
  
   public Gremlin(TreeNodeStream input, Evaluator evaluator) {
        this(input, new RecognizerSharedState());
        this.evaluator = evaluator;
   }

}

program : statement+;

natural : NATURAL;
real 	: REAL;
string 	: STRING;
path	: PATH;

value returns [String t]: natural {$t="NATURAL";}| real {$t="REAL";} | string {$t="STRING";} | path {$t="PATH";} | variable {$t="VARIABLE";};
variable : VARIABLE;
terminator : NEWLINE | EOF;	 	

 		
statement : ^(ASSIGN variable value) {

  evaluator.setVariable($variable.text, $value.t, $value.text);
}
	  | value {
	  
  evaluator.evaluate(null, $value.text);
};
