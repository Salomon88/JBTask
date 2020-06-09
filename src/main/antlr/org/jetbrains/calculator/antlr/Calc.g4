grammar Calc;

stmt: expr EOF;

expr: MINUS? '(' expr ')' #paren |
      expr (MULT|DIV) expr #MulDiv |
      expr (PLUS|MINUS) expr #PlusMinus |
      doublen #number;

doublen:
  PLUS NUMBER |
  MINUS NUMBER|
  NUMBER
  ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

MULT
   : '*'
   ;


DIV
   : '/'
   ;

NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

fragment SIGN
   : ('+' | '-')
   ;

WS : [ \t\n\r]+ -> channel(HIDDEN) ;