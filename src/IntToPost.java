/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.Stack;

/**
 *
 * @author Bhuller
 */
public class IntToPost{
     
    private String resultt="";
    private Stack<String> oprator = new Stack<String>();
    private Stack<Double> oprand = new Stack<Double>();
    private boolean fI=false;
    
    public String inttoposst(String inputt){
      for(int i=0; i<inputt.length(); i++){
          char curchar = inputt.charAt(i);
          if(!isOperator(curchar)){
              resultt += Character.toString(curchar);
              
          }
          else{
              resultt = resultt + " ";
                if(oprator.empty()){ 
                    oprator.push(Character.toString(curchar));
                }
                
                else{
                    if(prior(Character.toString(curchar))<prior(oprator.peek())) {
                        resultt += oprator.pop();
                    }
                    
                    else if((prior(Character.toString(curchar))==prior(oprator.peek()))){
                        resultt += oprator.pop();
                    }
                    oprator.push(Character.toString(curchar));
                }
          }  
          }
      while(!oprator.empty()) {
      resultt +=" " + oprator.pop() ;
      }
      return resultt;
    }
    String numbero=" ";
    public Double posttoans(String res){
        double tempVal1=0, tempVal2=0;
        double resolt=0;
        
        for(int i=0; i<res.length(); i++) {
            char curchar = res.charAt(i);
           
            if(!isOperator(curchar) ){ 
                if(curchar!= ' '){
                numbero+= curchar;
                }
                if(curchar== ' '){
                    if (numbero!=" "){
                oprand.push(Double.parseDouble(numbero));
                    }    
                numbero = " ";
                }
            }
            else if(isOperator(curchar) ) {
                if(!oprand.empty()) {
                    performOp(curchar);
                }
            }   
        }        
        return oprand.peek();
    }
    
     public void run(){
         String inpot = "1+2*8-3";
         System.out.print(inttoposst(inpot));
         System.out.println("");
         System.out.println(posttoans(inttoposst(inpot)));
     }
     
     public int prec;
     public int prior(String oprato){
            
            switch(oprato){
                case"+":
                case"-":
                    prec=1;
                    break;
                case"*":
                case"/":
                    prec=3;
                    break;
            }
     return prec;
     }
    
     public boolean isOperator(char input){
         
         switch(input){
                 case '+':
                 return true;
                 case '-':
                 return true;
                 case '*':
                 return true;
                 case '/':
                 return true;
         }
         return false;
      }
     
     
     public double performOp( char operatorr){
         double result=0;
         
         if (operatorr == '+'){
             double x = oprand.pop();
             double y = oprand.pop();
             result = x + y;
             oprand.push(result);
             
         }
         else if (operatorr == '-'){
            double x = oprand.pop();
             double y = oprand.pop();
             result = y - x;
             oprand.push(result);
         }
         else if (operatorr == '*'){
             double x = oprand.pop();
             double y = oprand.pop();
             result = x * y;
             oprand.push(result);
         }
         else if (operatorr =='/'){
             double x = oprand.pop();
             double y = oprand.pop();
             result = y / x;
             oprand.push(result);
         }
         System.out.println(result);
        return result;
     }
     
       
}
