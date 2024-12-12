import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void number2Int() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
    }

    @Test
    void StIsNumberTest() {
        assertTrue(Ex1.StIsJustNumber("12345"));
        assertFalse(Ex1.StIsJustNumber("1234A5"));
    }

    @Test
    void isNumber() {
        assertTrue(Ex1.isNumber("10b5"));
    }

    @Test
    void maxIndexTest() {
        String[] nums = {"11b2", "1"};
        int k = Ex1.maxIndex(nums);
        assertEquals(k, 0);
    }

    @Test
    void int2NumberTest() {
        int num = 10;
        int base = 16;
        String v = Ex1.int2Number(num, base);
        assertEquals(v, "AbG");
    }

    @Test
    void leToNumTest() {
        int num = Ex1.leToNum('G');
        assertEquals(num, 16);
    }

    @Test
    void splitTest(){
            String num = "10b2";
            String[] expected = {"10", "2"};
            String[] actual = Ex1.splitNum(num);
            assertArrayEquals(expected, actual);
    }

    @Test
    void goodBaseTest(){
        String base = "G";
        boolean check = Ex1.goodBase(base);
        String base2 = "10";
        boolean check2 = Ex1.goodBase(base2);
        assertTrue(check);
        assertFalse(check2);
    }

}
