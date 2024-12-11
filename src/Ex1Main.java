import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            if (num1 != "quit") {
                num1 = sc.next();
                int number1 = Ex1.number2Int(num1);
                boolean answer1 = Ex1.isNumber(num1);
                if (answer1) {
                    System.out.println("num1= " + num1 + " is number :" + answer1 + ", value: " + number1);
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    if (num2 != "quit") {
                        num2 = sc.next();
                        int number2 = Ex1.number2Int(num2);
                        boolean answer2 = Ex1.isNumber(num2);
                        if(answer2)
                        {
                            System.out.println("num2= " + num2 + " is number :" + answer2 + ", value: " + number2);
                            System.out.println("Enter a base for output: (a number [2, 16]");
                            int base = Integer.parseInt(sc.next());
                            if(base>=2 && base<=16)
                            {
                                String plus = Ex1.int2Number((number1 + number2), base);
                                String multi = Ex1.int2Number((number1 * number2), base);
                                System.out.println(num1 + " + " + num2 + "= " + plus);
                                System.out.println(num1 + " * " + num2 + "= " + multi);
                                String[] numbers = {num1, num2, plus, multi};
                                int indexMax = Ex1.maxIndex(numbers);
                                String max = numbers[indexMax];
                                System.out.println("Max number over [" + num1 + "," + num2 + "," + plus + "," + multi + "] is: " + max);
                            }
                            else{
                                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                            }
                        }
                        else {
                            System.out.println("num2= " + num2 + " is number :" + answer2 + ", value: -1");
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 +")");
                        }
                    }
                }
                else{
                    System.out.println("num1= " + num1 + " is number :" + answer1 + ", value: -1");
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 +")");
                }

            }
        }
        System.out.println("quiting now...");
    }

}
