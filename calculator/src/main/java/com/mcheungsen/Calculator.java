package com.mcheungsen;

import com.mcheungsen.Exceptions.SyntaxErrorException;

public class Calculator {
    Tokenizer tokenizer;


    public int evaluation(String line) throws SyntaxErrorException {
        tokenizer = new Tokenizer(line);
        Token token = tokenizer.get();

        checkSyntax(token.isNumber(), "Number expected");
        int res = token.value();

        token = tokenizer.get();
        while(token.isSymbol()){
            switch(token.getString()){
                case "+":
                    token = tokenizer.get();
                    checkSyntax(token.isNumber(), "Number expected");
                    res += token.value();
                    break;
                case "-" :
                    token = tokenizer.get();
                    checkSyntax(token.isNumber(), "Number expected");
                    res -= token.value();
                    break;
                default:
                    break;
            }

            token = tokenizer.get();
        }
        //checkSyntax(token.isEnd(), String.format("End of expression expected, %s found", token));

        return res;
    }

    private void checkSyntax(boolean syntax, String expected) throws SyntaxErrorException {
        if(!syntax) throw new SyntaxErrorException(expected);
    }
}
