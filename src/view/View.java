package view;

import java.util.Scanner;

public abstract class View {

    public static String requestInputString(String ms) {

        System.out.println(ms +": ");

        try(Scanner s = new Scanner(System.in)) {
            String input = s.next();
            // validations
            return input;
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return "error";
    }

}
