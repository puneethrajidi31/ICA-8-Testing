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

    }


}