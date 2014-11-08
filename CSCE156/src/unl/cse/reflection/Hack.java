package unl.cse.reflection;

import java.lang.reflect.Field; 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method; 

public class Hack {
 
  private static final Object[] EMPTY = {};

  public void reflect() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Secret instance = new Secret();
    Class secretClass = instance.getClass();

    // Print all the method names & execution result
    Method methods[] = secretClass.getDeclaredMethods(); 
    System.out.println("Access all the methods"); 
    for (int i = 0; i < methods.length; i++) { 
       System.out.println("Method Name: " + methods[i].getName());
       System.out.println("Return type: " + methods[i].getReturnType());
       methods[i].setAccessible(true);
       System.out.println(methods[i].invoke(instance, EMPTY) + "\n");
    }

    //  Print all the field names & values
    Field fields[] = secretClass.getDeclaredFields();
    System.out.println("Access all the fields");
    for (int i = 0; i < fields.length; i++){ 
       System.out.println("Field Name: " + fields[i].getName()); 
       fields[i].setAccessible(true); 
       System.out.println(fields[i].get(instance) + "\n"); 
    }
 }

 public static void main(String[] args){

   Hack newHacker = new Hack();
 
   try { 
     newHacker.reflect();
   }
   catch (Exception e) {
     e.printStackTrace();
   }
 }
}