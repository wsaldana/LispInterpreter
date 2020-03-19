import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class myVectorTest {

    @Test
    public void push() {
    }

    @Test
    public void pop() throws Exception{
        Vector<String> try1 = new Vector<String>();
        try1.add("car");
        try1.add("car2");
        try1.add("car3");
        try1.add("car4");
        String eliminate = try1.remove((try1.size())-1);
        assertEquals("car4",eliminate);
    }

    @Test
    public void peek() {
        Vector<String> try1 = new Vector<String>();
        try1.add("car");
        try1.add("car2");
        try1.add("car3");
        try1.add("car4");
        String eliminate = try1.get((try1.size())-1);
        assertEquals("car4",eliminate);
    }

    @Test
    public void size() {
        Vector<String> try1 = new Vector<String>();
        try1.add("car");
        try1.add("car2");
        try1.add("car3");
        try1.add("car4");
        int total_of_elements = try1.size();
        assertEquals(4,total_of_elements);
    }

    @Test
    public void empty() {
        Vector<String> try1 = new Vector<String>();
        boolean decide;
        try1.add("car");
        try1.add("car2");
        try1.add("car3");
        try1.add("car4");
        if(try1.size() > 0){
            decide = true;
        }else{
            decide = false;
        }
        assertEquals(true, decide);
    }
}