package com.mcheungsen;

import com.mcheungsen.Exceptions.EvaluationErrorException;
import com.mcheungsen.Exceptions.SyntaxErrorException;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner in = new Scanner(System.in);
        System.out.println("Essai de boucle d'interaction");
        while (true) {
            System.out.print("> ");
            if (!in.hasNextLine()) {
                break;
            }
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.equals("\\q")) {
                break;
            }

            try {
                int value = calculator.evaluation(line);
                System.out.format("> %d\n", value);
            }
            catch (SyntaxErrorException ex) {
                System.out.format(" ! Incorrect syntax %s\n",
                        ex.getMessage()) ;
            }
            /*
            catch (EvaluationErrorException ex) {
                System.out.format(" ! Evaluation failed %s\n",
                        ex.getMessage()) ;
            }*/


        }
        System.out.println("Bye.");
    }

}
