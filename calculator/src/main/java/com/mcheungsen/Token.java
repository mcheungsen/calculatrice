package com.mcheungsen;

public class Token {
    final TokenType type ;
    final String string ;
    public Token(TokenType type, String string) {
        this.type = type ;
        this.string = string ;
    }
    public boolean isNumber() {
        return type == TokenType.NUMBER ;
    }
    int value() {
        return Integer.parseInt(string) ;
    }

    public boolean isSymbol(){
        return type == TokenType.SYMBOL;
    }

    public String getString(){
        return this.string;
    }

    public boolean isSymbol(String s) {
        return this.string.equals(string);
    }

    public boolean isEnd() {
        return type == TokenType.END;
    }
}
