// Question 1
// Programmer: Minh Nguyen

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Question1 {

    // Patterns
    static HashMap<String, String> regex = new HashMap<>();

    public static void initializeRegex() {
        regex.put("PERL_IDEN_SCALAR", "^(\\$)(_)?[a-zA-Z0-9]+_?[a-zA-Z0-9]+");
        regex.put("PERL_IDEN_ARRAY", "^(@)(_)?[a-zA-Z0-9]+_?[a-zA-Z0-9]+");
        regex.put("PERL_IDEN_HASH", "^(%)(_)?[a-zA-Z0-9]+_?[a-zA-Z0-9]+");

        regex.put("JAVA_STRING", "^(\").*(\"$)");
        regex.put("C_INT_DECIMAL", "^[\\d]+");
        regex.put("C_INT_OCT", "^0[0-7]*");
        regex.put("C_INT_HEX", "^0[xX][0-9a-fA-F]*");
        regex.put("C_CHAR", "^\\'[a-zA-Z0-9]\\'");
        regex.put("C_FLOAT", "^[-+]?(\\d)+\\.(\\d)*([eE][-+]?\\d+)?");

        regex.put("STRING", "^String");
        regex.put("INTEGER", "^Integer");
        regex.put("CHARACTER", "^Character");
        regex.put("FLOAT", "^Float");
        regex.put("VOID", "^Void");

        regex.put("ADDITION", "^\\+");
        regex.put("ASSIGNMENT", "^=");
        regex.put("SUBTRACTION", "^-");
        regex.put("DIVISION", "^/");
        regex.put("MULTIPLICATION", "^\\*");
        regex.put("MODULO", "^%");
        regex.put("AND", "^\\&\\&");
        regex.put("OR", "^\\|\\|");
        regex.put("NOT", "^!");
        regex.put("OPEN_BLOCK", "^\\{");
        regex.put("CLOSE_BLOCK", "^\\}");
        regex.put("OPEN_FUNCTION", "^\\(");
        regex.put("CLOSE_FUNCTION", "^\\)");
        regex.put("OPEN_ARRAY", "^\\[");
        regex.put("CLOSE_ARRAY", "^\\]");
    }

    public static String readFile (String fileName) {

        String file = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                file += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;
    }

    public static void lex(String str) {

        Set<String> keys = regex.keySet();
        String output = "Lex " + str + " is ";
        boolean found = false;

        for (String k : keys) {
            String pattern = regex.get(k);
            if (Pattern.compile(pattern).matcher(str).find()) {
                found = true;
                output += k;
                if (k.equals("PERL_IDEN_ARRAY") || k.equals("PERL_IDEN_HASH") || k.equals("PERL_IDEN_SCALAR")){
                    if (str.charAt(1) == '_') {
                        output += " PRIVATE";
                    }
                }
                break;
            }
        }
        if (!found) {
            output += "UNKNOWN";
        }
        System.out.println(output);
    }

    public static void main(String[] args) {

        // Read file
        URL url = Question1.class.getResource("question1.in");
        String data = readFile(url.getPath());

        initializeRegex();
        // Split the string by spaces
        String listStrs [] = data.split("[ \\r\\n]");

        for (String str : listStrs) {
            lex(str);
        }
    }

}
