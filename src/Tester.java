import java_cup.runtime.Symbol;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by a on 10/21/2016.
 */
public class Tester {

    public static void main(String[] args) throws Exception {

        Lexer l = new Lexer(new FileReader("codiceCorretto.txt"));

        Symbol s = null;
        while ((s = l.next_token()).sym != 0)
            ;//System.out.println(s.sym);

        parser p = new parser(new Lexer(new FileReader("codiceCorretto.txt")), "");
        try{
        p.parse();} catch(Exception e){
        }
    }
}
