import java.util.Queue;
import java.util.Stack;

public class Stack2Queue<E> {
    private Stack<E> inStack = new Stack<E>();
    private Stack<E> outStack = new Stack<E>();

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e) {
        return inStack.add(e);
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll() {
        if (!outStack.empty()) {
            return outStack.pop();
        } else {
            if (inStack.empty()) {
                return null;
            } else {
                while (inStack.size() > 1) {
                    outStack.push(inStack.pop());
                }
                return inStack.pop();
            }
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek() {
        if (!outStack.empty()) {
            return outStack.peek();
        } else {
            if (inStack.empty()) {
                return null;
            } else {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.peek();
            }
        }
    }

    /**
     * Tests if this queue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * Returns the number of components in this queue.
     *
     * @return  the number of components in this queue
     */
    public int size() {
        return inStack.size() + outStack.size();
    }
}
