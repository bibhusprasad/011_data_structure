package s3_c1_stack;

public class StackByArray {

    int[] arr;
    int topOfStack; //keeps track of the cell which is last occupied in Array, this will help in insertion/deletion

    //createStack
    public StackByArray(int size){
        arr = new int[size];
        topOfStack = -1;
        System.out.println("Successfully created an empty Stack of Size: "+size);
    }

    //push
    public void push(int value) {
        //if array is full, show stack overflow error
        if(isStackFull()){
            System.out.println("Stack overflow error!!");
        }else{
            arr[topOfStack+1] = value;
            topOfStack++;
            System.out.println("Successfully inserted " + value + " in the stack");
        }
    }

    //peek
    public void peek() {
        if(isStackEmpty()){
            System.out.println("The stack is empty!!");
        } else {
            System.out.println("Top of the stack : " + arr[topOfStack]);
        }
    }

    //pop
    public void pop() {
        if(isStackEmpty()){
            System.out.println("Stack is Empty.");
        }else{
            System.out.println("Poping value from Stack: " + arr[topOfStack] + "...");
            topOfStack--;
        }
    }

    //delete
    public void deleteStack() {
        arr = null;
        System.out.println("Stack is successfully deleted");
    }

    public boolean isStackFull(){
        if(topOfStack == arr.length - 1) {
            System.out.println("Stack is full !");
            return true;
        } else
            return false;
    }

    public boolean isStackEmpty(){
        if(topOfStack == - 1) {
            System.out.println("Stack is Empty !");
            return true;
        } else
            return false;
    }
}
