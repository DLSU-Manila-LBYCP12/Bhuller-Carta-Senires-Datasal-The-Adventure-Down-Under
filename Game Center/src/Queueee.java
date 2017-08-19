



/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Queueee <E> {

    private int fsize=5000;
    public int fron;
    public int last;
    private E[] items;
    private int numItems;
    
    
   
    public void create() {
    items = ( E[]) new Object[fsize];
    numItems =0;
    fron = 0;
    last = -1;
    }

   
    public void enqueue(E elem) {
        if(isFull()){
           System.out.println("It is full");
        }
        else{
            last = last+1;
            items[last] = elem;
            numItems++;
        }
    }

 
    public void dequeue() {
        if(isEmpty()){
            System.out.println("It is empty");
        }
        else{
            for(int i=0; i<numItems; i++){
                items[i] = items[i+1];
            }
            last = last-1;
            numItems--;
        }
    }

  
    public E top() {
        return items[last];
    }

    public E first() {
        return items[fron];
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems==0;
    }

    public boolean isFull() {
        return numItems==fsize;
    }
    
    public E get(int i){
        return items[i];
    }
}

    

