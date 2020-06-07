grammar Calc;

stmt: expr* EOF;

expr: '(' expr ')' |
      expr (MULT|DIV) expr|
      expr (PLUS|MINUS) expr|
      SCIENTIFIC_NUMBER;


WS : [ \t\n\r]+ -> channel(HIDDEN) ;

SCIENTIFIC_NUMBER
   : SIGN? NUMBER ((E1 | E2) SIGN? NUMBER)?
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

fragment E1
   : 'E'
   ;
fragment E2
   : 'e'
   ;

fragment SIGN
   : ('+' | '-')
   ;
fragment NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;
