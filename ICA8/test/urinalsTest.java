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
        
    }


}