package controller.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilTest {

    @Test
    void testNullCase() {
        String password = null;
        assertEquals("", HashUtil.generateMD5HashedPassword(password));
    }

    @Test
    void testEmptyString() {
        String password = "";
        assertEquals("", HashUtil.generateMD5HashedPassword(password));
    }

    @Test
    void testSimplePassword() {
        String password = "qwerty";
        assertEquals("d8578edf8458ce06fbc5bb76a58c5ca4", HashUtil.generateMD5HashedPassword(password));
    }

    @Test
    void testComplexPasswordWithSpecialCharacters() {
        String password = "2. attrib -h -r -s /s /d g:\\*.*. W";
        assertEquals("4d1edf01528cd505a0bf6eadde0d658c", HashUtil.generateMD5HashedPassword(password));
    }

}