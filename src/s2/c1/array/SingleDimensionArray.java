package s2.c1.array;

public class SingleDimensionArray {

    int[] arr = null;

    //constructor
    public SingleDimensionArray(int size){
        arr = new int[size];
        for(int i = 0; i< arr.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    //traverse array
    public void traverseArray(){
        try{
            for(int i = 0; i< arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }catch (Exception e){
            System.out.println("Array no longer exists.");
        }
    }

    //insert in array
    public void insert(int location, int valueToBeInserted){
        try{
            if(arr[location] == Integer.MIN_VALUE){
                arr[location] = valueToBeInserted;
                System.out.println("Successfully Inserted " + valueToBeInserted + " at location " + location);
            } else {
                System.out.println("This cell is already occupied by other value.");
            }
        }catch (Exception e){
            System.out.println("Invalid index to access array.");
        }
    }

    //accessing a cell
    public void accessingACell(int cellNo){
        try{
            System.out.println(arr[cellNo]);
        }catch (Exception e){
            System.out.println("Invalid index to access array.");
        }
    }

    //search a value
    public void searchInAnArray(int valueToSearch){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == valueToSearch){
                System.out.println("Value found.");
                System.out.println("Index of value " + valueToSearch + " is " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " not found.");
    }

    //deleting a value
    public void delete(int cellNo){
        try{
            arr[cellNo] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted value at cell "+ cellNo);
        }catch (Exception e){
            System.out.println("Error, this cell is not exist");
        }
    }

}
