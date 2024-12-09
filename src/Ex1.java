/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param "num" a String representing a number in basis [2,16]
     * @return
     */

    public static int power(int n, int k) {
        if (k == 0)
            return 1;
        return power(n, k - 1) * n;
    }

    public static boolean StIsNumber(String num)                 //הפונקציה בודקת האם המחרוזת הנתונה היא מספר
    {
        boolean isNum = true;
        for(int i = 0; i< num.length(); i++)
        {
            if(!Character.isDigit(num.charAt(i))) {
                isNum = false;
                break;
            }
        }
        return isNum;
    }

    public static int leToNum(char num) {
        int add = 10;
        char[] nums = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        for (int j = 0; j < nums.length; j++) {
            if (num == nums[j]) {
                add = add + j;
                break;
            }
        }
        return add;
    }

    public static String[] splitNum(String num) {
        String[] nums = num.split("b");
        return nums;
    }

    public static int number2Int(String num) {
        int ans = -1;
        if (!isNumber(num)) {
            return ans;
        }
        if(StIsNumber(num))
        {
            return Integer.parseInt(num);
        }
        ans = 0;
        String[] nums = splitNum(num);
        String snumber = nums[0];
        String sbase = nums[1];
        int s = 0;
        char base1 = sbase.charAt(0);

        for (int i = 0; i < snumber.length(); i++) {
            if (Character.isDigit(base1)) {
                if (Character.isDigit(snumber.charAt(i))) {
                    ans = ans + Character.getNumericValue(snumber.charAt(i)) * power(Integer.parseInt(sbase), (snumber.length() - 1 - i));
                } else {
                    s = leToNum(snumber.charAt(i));
                    ans = ans + s * power(Integer.parseInt(sbase), (snumber.length() - i - 1));
                }
            } else {
                if (Character.isDigit(snumber.charAt(i))) {
                    ans = ans + Character.getNumericValue(snumber.charAt(i)) * power(leToNum(base1), (snumber.length() - 1 - i));
                } else {
                    s = leToNum(snumber.charAt(i));
                    ans = ans + s * power(leToNum(base1), (snumber.length() - i - 1));
                }
            }
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */


    public static boolean isNumber(String a) {
        boolean ans = true;
        String[] nums = new String[2];
        nums = splitNum(a);
        String snumber = nums[0];
        String sbase = nums[1];
        if(StIsNumber(a))                       //אם המחרוזת היא מספר דצימלי בפני עצמו, המחרוזת תקינה
        {
            return ans;
        }
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        boolean c = false;
        for (int i = 0; i < snumber.length(); i++)                                  //לולאה  שבודקת האם יש במספר הנתון תו שלא קיים במערך ובהתאם לכך מכניסה ערך אמת או שקר לc
        {
            for (int j = 0; j < numbers.length; j++) {
                if (snumber.charAt(i) == numbers[j]) {
                    c = true;
                    break;
                }
            }
            if (!c) {
                break;
            }
        }
        for(int j =0; j<snumber.length(); j++) {                        // הלולאה בודקת האם המספר גדול או שווה לבסיס ואם כן מכניסה שקר לans
            if (!(Character.getNumericValue(snumber.charAt(j)) <= sbase.charAt(0)))
            {
                ans = false;
                break;
            }
        }
        if(StIsNumber(snumber))
        {
            if(Integer.parseInt(snumber)>Integer.parseInt(sbase))
                ans = false;
        }
        else
        {
            if (a.isEmpty() || a.indexOf("b") == -1 || sbase == snumber || Integer.parseInt(nums[1]) > 10 || a.contains(" ") || !c || a.contains("bb")) {
                ans = false;
            }
            else
            {
                if(!goodBase(sbase))
                    ans = false;
            }
        }

        return ans;

    }

    public static boolean goodBase(String base)                                    //פונקציה שמקבלת מחרוזת ומחזירה אמת אם המחרוזת יכולה להיות בסיס, אחרת מחזירה שקר
    {
        boolean ans = true;
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        if (base.length() != 1) {
            return false;
        } else {
            if (base == "0" || base == "1" || base == null) {
                return false;
            } else {
                for (int j = 0; j < numbers.length; j++) {                             //לולאה  שבודקת האם הבסיס הנתון הוא תו שקיים במערך, אם לא מכניסה לans שקר
                    if (base.charAt(0) != numbers[j] && j == (numbers.length - 1)) {
                        ans = false;
                    }
                }
            }
            return ans;
        }
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            ans = "";
        } else {

        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;


        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }
}
