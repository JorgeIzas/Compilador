/* -----ANALIZADOR LEXICO, PROYECTO COMPILADORES----- */
package proyectocompfx;
import java_cup.runtime.Symbol;
%%

%class AnalizadorLexico
%line
%char
%column
%cup
%eofval{
  System.out.println("Fin de archivo encontrado");
  return new Symbol(sym.EOF);
%eofval}
%eofclose


/*  -----DECLARACION DE REGLAS----- */
decimal = 0 | [1-9][0-9]*

doub1 = [0-9]+ \. [0-9]+
doub2 = \- {doub1} | \- {decimal}
real = ({decimal} | {doub1} | {doub2})

palabra = [a-zA-Z]([a-zA-Z]|[0-9])*

finLinea = \r|\n|\r\n
WhiteSpace = {finLinea} | [ \t\f]

comentario = "/*" [^*] ~"*/" | "/*" "*"+ "/"
%%

/* -----PALABRAS RESERVADAS----- */
"propiedades" {return new Symbol(sym.PROPIEDADES,new token(yycolumn, yyline, yytext()));}
"clase" {return new Symbol(sym.CLASE,new token(yycolumn, yyline, yytext()));}
"metodos" {return new Symbol(sym.METODO,new token(yycolumn, yyline, yytext()));}
"publicas" {return new Symbol(sym.PUBLICA,new token(yycolumn, yyline, yytext()));}
"publicos" {return new Symbol(sym.PUBLICO,new token(yycolumn, yyline, yytext()));}
"privadas" {return new Symbol(sym.PRIVADA,new token(yycolumn, yyline, yytext()));}
"protegidas" {return new Symbol(sym.PROTEGIDA,new token(yycolumn, yyline, yytext()));}
"cadena" {return new Symbol(sym.STRING,new token(yycolumn, yyline, yytext()));}
"entero" {return new Symbol(sym.INT,new token(yycolumn, yyline, yytext()));}
"real" {return new Symbol(sym.REAL,new token(yycolumn, yyline, yytext()));}
"boleano" {return new Symbol(sym.BOOLEAN,new token(yycolumn, yyline, yytext()));}
"nulo" {return new Symbol(sym.NULL,new token(yycolumn, yyline, yytext()));}
"OR" {return new Symbol(sym.OR,new token(yycolumn, yyline, yytext()));}
"AND" {return new Symbol(sym.AND,new token(yycolumn, yyline, yytext()));}
"si" {return new Symbol(sym.IF,new token(yycolumn, yyline, yytext()));}
"entonces" {return new Symbol(sym.ELSE,new token(yycolumn, yyline, yytext()));}
"sino" {return new Symbol(sym.ELIF,new token(yycolumn, yyline, yytext()));}
"devolver" {return new Symbol(sym.RETURN,new token(yycolumn, yyline, yytext()));}
"desde" {return new Symbol(sym.FROM,new token(yycolumn, yyline, yytext()));}
"mientras" {return new Symbol(sym.WHILE,new token(yycolumn, yyline, yytext()));}
"incrementar" {return new Symbol(sym.INC,new token(yycolumn, yyline, yytext()));}
"decrementar" {return new Symbol(sym.DEC,new token(yycolumn, yyline, yytext()));}
"hacer" {return new Symbol(sym.DO,new token(yycolumn, yyline, yytext()));}
"escribir" {return new Symbol(sym.PRINT,new token(yycolumn, yyline, yytext()));}
"leer" {return new Symbol(sym.GET,new token(yycolumn, yyline, yytext()));}
"instanciar" {return new Symbol(sym.INSTANCIAR,new token(yycolumn, yyline, yytext()));}
"verdadero" {return new Symbol(sym.TRUE,new token(yycolumn, yyline, yytext()));}
"falso" {return new Symbol(sym.FALSE,new token(yycolumn, yyline, yytext()));}

/* -----SEPARADORES----- */
"(" {return new Symbol(sym.PARENTL,new token(yycolumn, yyline, yytext()));}
")" {return new Symbol(sym.PARENTR,new token(yycolumn, yyline, yytext()));}
"{" {return new Symbol(sym.LLAVEL,new token(yycolumn, yyline, yytext()));}
"}" {return new Symbol(sym.LLAVER,new token(yycolumn, yyline, yytext()));}
"[" {return new Symbol(sym.CORCHL,new token(yycolumn, yyline, yytext()));}
"]" {return new Symbol(sym.CORCHR,new token(yycolumn, yyline, yytext()));}
"." {return new Symbol(sym.PUNTO,new token(yycolumn, yyline, yytext()));}
"," {return new Symbol(sym.COMA,new token(yycolumn, yyline, yytext()));}
";" {return new Symbol(sym.PUNTOCOMA,new token(yycolumn, yyline, yytext()));}
\" {return new Symbol(sym.COMILLA,new token(yycolumn, yyline, yytext()));}

/* -----OPERADORES----- */
"=" {return new Symbol(sym.IGUAL,new token(yycolumn, yyline, yytext()));}
"<" {return new Symbol(sym.MENQ,new token(yycolumn, yyline, yytext()));}
">" {return new Symbol(sym.MAYQ,new token(yycolumn, yyline, yytext()));}
"==" {return new Symbol(sym.EQUAL,new token(yycolumn, yyline, yytext()));}
"!=" {return new Symbol(sym.DIFERENTE,new token(yycolumn, yyline, yytext()));}
"+" {return new Symbol(sym.SUMA,new token(yycolumn, yyline, yytext()));}
"-" {return new Symbol(sym.RESTA,new token(yycolumn, yyline, yytext()));}
"*" {return new Symbol(sym.MULTI,new token(yycolumn, yyline, yytext()));}
"/" {return new Symbol(sym.DIVI,new token(yycolumn, yyline, yytext()));}
"%" {return new Symbol(sym.MODULO,new token(yycolumn, yyline, yytext()));}
"^" {return new Symbol(sym.EXP,new token(yycolumn, yyline, yytext()));}

/* -----ESPACIOS----- */
{WhiteSpace} {/* ignorar */}
{comentario} {/* ignorar */}
. {System.err.println("caracter invalido \"" + yytext() + "\" ["+ (yyline+1) + ":"+ (yycolumn+1) + ":"+ yychar + "]");
    return new Symbol(sym.error);}

{palabra} {return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));}
{decimal} {return new Symbol(sym.NUMERO, new token(yycolumn, yyline, yytext(), true));}
