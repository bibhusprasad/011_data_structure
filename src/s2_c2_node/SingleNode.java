package s2_c2_node;

public class SingleNode {

    private int value;
    private SingleNode next;

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return this.next;
    }

    public void setNext(final SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
