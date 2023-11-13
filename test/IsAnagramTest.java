import static org.junit.jupiter.api.Assertions.*;

class IsAnagramTest {

    IsAnagram isAnagram = new IsAnagram();

    @org.junit.jupiter.api.Test
    void anagramChecker() {
        assertTrue(isAnagram.anagramChecker("test", "tset"));
        assertFalse(isAnagram.anagramChecker("tes", "tset"));
        assertTrue(isAnagram.anagramChecker("test", "test"));

    }

}