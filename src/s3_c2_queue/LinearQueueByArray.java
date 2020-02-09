package s3_c2_queue;

public class LinearQueueByArray {

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public LinearQueueByArray(final int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Successfully created an empty queue of size: " + size);
    }

    public void enQueue(final int value) {
        if (this.arr == null) {
            System.out.println("Array is not yet created. Please create one first.");
        } else if (this.isQueueFull()) {
            System.out.println("\nQueue overflow error!!");
        } else if (this.isQueueEmpty()) {
            this.beginningOfQueue = 0;
            this.topOfQueue++;
            this.arr[this.topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        } else {
            this.topOfQueue++;
            this.arr[this.topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
        this.printQueue();
    }

    public boolean isQueueFull() {
        if (this.topOfQueue == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQueueEmpty() {
        if (this.beginningOfQueue == -1 || this.beginningOfQueue == this.arr.length) {
            return true;
        } else {
            return false;
        }
    }

    private void printQueue() {
        if (!this.isQueueEmpty()) {
            System.out.println("Queue now ...");
            for (int i = this.beginningOfQueue; i <= this.topOfQueue; i++) {
                System.out.print(this.arr[i] + "   ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty !");
        }
    }

    public void peekOperation() {
        if (!this.isQueueEmpty()) {
            System.out.println(this.arr[this.beginningOfQueue]);
        } else {
            System.out.println("The Queue is empty.");
        }
    }

    public void deQueue() {
        if (this.isQueueEmpty()) {
            System.out.println("The Queue is empty.");
        } else {
            System.out.println("Dequeing value from Queue...");
            System.out.println("Dequeued: " + this.arr[this.beginningOfQueue] + " from queue");
            this.beginningOfQueue++;
            if (this.beginningOfQueue > this.topOfQueue) {
                this.beginningOfQueue = this.topOfQueue = -1;
            }
        }
    }

    public void deleteQueue() {
        this.arr = null;
        System.out.println("Queue is successfully deleted !");
    }
}
