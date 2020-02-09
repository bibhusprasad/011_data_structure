package s2_c2_node;

public class DoubleNode {

    private int value;
    private DoubleNode next;
    private DoubleNode prev;

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setNext(final DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return this.prev;
    }

    public void setPrev(final DoubleNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
