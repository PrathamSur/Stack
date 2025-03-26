import java.util.*;

class MyStack<T>{
    public T[] arr;
    public int top;

    public MyStack(int n){
        arr=(T[])new Object[n];
        top=-1;
    }
    //method to push a number into the stack
    public void push(T num){
        if(top<arr.length-1){
            top++;
            arr[top]=num;
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Overflow");
        }
    }
    //pop method that returns the last value and removes it
    public T pop(){
        if(top>=0){
            return arr[top--];
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Underflow");
        }
    }
    //method to print the stack array
    public void print(){
        if(top==-1){
            System.out.println("empty stack");
        }
        else{
            for(int i=0;i<=top;i++){
                System.out.print(" "+arr[i]);
            }
            System.out.println();
        }
    }
    //method to determine the size of the stack
    public int size(){
        return top+1;
    }

    //method to check whether the stack is empty or not
    public boolean isEmpty(){
        return top==-1;
    }
    //method to get the element of a specific index
    public T getElement(int i){
        if(i>=0 && i<arr.length)
            return arr[i];
        else{
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
    }

    public T peek(){
        if(top==-1){
            throw new ArrayIndexOutOfBoundsException("Underflow");
        }
        else{
            return arr[top];
        }
    }

    public static <T> boolean similarity(MyStack<T> s1,MyStack<T> s2){
        HashSet<T> set1=new HashSet<>();
        HashSet<T> set2=new HashSet<>();
        for(int i=0;i<s1.size();i++){
            set1.add(s1.getElement(i));
        }
        for(int i=0;i<s2.size();i++){
            set2.add(s2.getElement(i));
        }

        return set1.equals(set2);
    }
}
public class Program1{
    public static void main(String[] args) {
        MyStack stack1 = new MyStack(5);
        stack1.push(1);
        stack1.push(6);
        stack1.print(); // Output: 1 6

        stack1.pop();
        stack1.pop();
        stack1.print(); // Output: Empty stack

        try {
            stack1.pop(); // Checking underflow condition
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        MyStack stack2 = new MyStack(5);
        stack2.push(6);
        stack2.push(1);
        stack2.print();

        System.out.println("Stacks have same elements? " + MyStack.similarity(stack1, stack2));

        stack1.push(1);
        stack1.push(6);
        stack1.print(); // Output: 1 2
        System.out.println("Stacks have same elements? " + MyStack.similarity(stack1, stack2));

    }
}