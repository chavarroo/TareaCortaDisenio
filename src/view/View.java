package view;

import controller.Control;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class View {

    Control c;
    static Scanner s;

    public View() {
        c = Control.getInstance();
    }

    protected String requestInputString(String ms) {

        System.out.print(ms +": ");
        String input = "-1";

        try {
            input = s.next();
        } catch (InputMismatchException e ) {
            System.out.println("-Intente de nuevo");
            return requestInputString(ms);
        } catch (Exception e ) {
            e.printStackTrace();
            System.err.println("Error with scanner");
            System.exit(1);
        }

        return input;
    }

    protected int requestInputInt(String ms) {
        int input = -1;
        System.out.print(ms +": ");

        try {
            input = s.nextInt();
            s.nextLine();
        } catch (InputMismatchException e ) {
            s.nextLine();
            System.out.println("-Intente de nuevo");
            return requestInputInt(ms);
        } catch (Exception e ) {
            e.printStackTrace();
            System.err.println("Error with scanner");
            System.exit(1);
        }

        return input;
    }

}
