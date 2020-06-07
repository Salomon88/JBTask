grammar Calc;

stmt: expr* EOF;

expr: '(' expr ')' |
      expr ('*'|'/') expr|
      expr ('+'| '-') expr|
      SCIENTIFIC_NUMBER;


WS : [ \t\n\r]+ -> channel(HIDDEN) ;

SCIENTIFIC_NUMBER
   : NUMBER ((E1 | E2) SIGN? NUMBER)?
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
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
