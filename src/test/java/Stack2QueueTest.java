import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Stack2QueueTest {
    @Test
    public void test() {
        Stack2Queue queue = new Stack2Queue<Integer>();
        assertEquals(0, queue.size());
        assertEquals(true, queue.empty());
        assertEquals(null, queue.peek());
        assertEquals(null, queue.poll());

        queue.add(100);
        assertEquals(1, queue.size());
        assertEquals(false, queue.empty());
        assertEquals(100, queue.peek());
        assertEquals(100, queue.poll());
        assertEquals(true, queue.empty());

        queue.add(1024);
        assertEquals(1, queue.size());
        assertEquals(false, queue.empty());
        assertEquals(1024, queue.peek());
        assertEquals(1024, queue.poll());
        assertEquals(true, queue.empty());

        queue.add(new Integer(8888));
        assertEquals(1, queue.size());
        assertEquals(false, queue.empty());
        assertEquals(8888, queue.peek());
        assertEquals(8888, queue.poll());
        assertEquals(true, queue.empty());

    }
}
