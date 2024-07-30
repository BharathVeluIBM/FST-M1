import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
   static ArrayList<String> list;
    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("Hello"); 
        list.add("World"); 
    }

    
    @Test
    public void insertTest() {
    	assertEquals(2, list.size(), "Wrong size");
        
        list.add(2, "FSTTest");
               assertEquals(3, list.size(), "Wrong size");

        assertEquals("Hello", list.get(0), "Wrong element");
        assertEquals("World", list.get(1), "Wrong element");
        assertEquals("FSTTest", list.get(2), "Wrong element");
    }

    
    @Test
    public void replaceTest() { 
    	
    	list.set(1, "FSTTest");
    	assertEquals(2, list.size(), "Wrong size");
    	assertEquals("Hello", list.get(0), "Wrong element");
        assertEquals("FSTTest", list.get(1), "Wrong element");
    }
}