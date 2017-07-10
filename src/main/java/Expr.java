import net.objecthunter.exp4j.*;
import java.util.Scanner;

/**
 * Created by kwonyoung on 2017-07-10.
 */
public class Expr {
    public static void main(String[] args) {
            while(true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter Expression:");
                    String exp = scanner.nextLine();

                    System.out.print("Enter X:");
                    String x = scanner.nextLine();

                    exp = exp.replaceAll("y|Y", "");
                    exp = exp.replaceAll("=", "");

                    Expression e = new ExpressionBuilder(exp)
                            .variables("x", "y")
                            .build()
                            .setVariable("x", Float.valueOf(x));

                    System.out.println("Y Result: " + e.evaluate());

                    System.out.print("Again? (y/n)");
                    String again = scanner.nextLine();
                    if(again.toUpperCase().equals("N")){
                        System.out.print("Terminated.");
                        break;
                    }
                } catch (ArithmeticException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }


    }
}
