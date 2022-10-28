import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @Test
    void goodString() {

        System.out.println("====== Puneeth Reddy == TEST ONE EXECUTED =======");
        assertEquals(true,urinals.goodString("10001"));
        System.out.println("====== Puneeth Reddy == TEST TWO EXECUTED =======");
        assertEquals(true,urinals.goodString("1001"));
        System.out.println("====== Puneeth Reddy == TEST THREE EXECUTED =======");
        assertEquals(true,urinals.goodString("00000"));
        System.out.println("====== Puneeth Reddy == TEST FOUR EXECUTED =======");
        assertEquals(true,urinals.goodString("0000"));
        System.out.println("====== Puneeth Reddy == TEST FIVE EXECUTED =======");
        assertEquals(true,urinals.goodString("01000"));
        System.out.println("====== Puneeth Reddy == TEST SIX EXECUTED =======");
        assertEquals(false,urinals.goodString("011"));
        System.out.println("====== Puneeth Reddy == TEST SEVEN EXECUTED =======");
        assertEquals(false,urinals.goodString("110"));



    }


    @Test
    public void urinalscount() {

        System.out.println("====== Puneeth Reddy == TEST ONE EXECUTED =======");
        assertEquals(1,urinals.urinalscount("10001"));
        System.out.println("====== Puneeth Reddy == TEST TWO EXECUTED =======");
        assertEquals(0,urinals.urinalscount("1001"));
        System.out.println("====== Puneeth Reddy == TEST THREE EXECUTED =======");
        assertEquals(3,urinals.urinalscount("00000"));
        System.out.println("====== Puneeth Reddy == TEST FOUR EXECUTED =======");
        assertEquals(2,urinals.urinalscount("0000"));
        System.out.println("====== Puneeth Reddy == TEST FIVE EXECUTED =======");
        assertEquals(1,urinals.urinalscount("01000"));
        System.out.println("====== Puneeth Reddy == TEST SIX EXECUTED =======");
        assertEquals(-1,urinals.urinalscount("011"));
        System.out.println("====== Puneeth Reddy == TEST SEVEN EXECUTED =======");
        assertEquals(-1,urinals.urinalscount("100011"));
    }
}

