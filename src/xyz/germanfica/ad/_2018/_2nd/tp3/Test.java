package xyz.germanfica.ad._2018._2nd.tp3;

import xyz.germanfica.util.Utils;

public class Test {
	public static void main(String[] args){
	    try{
	      System.out.print("Completed : 0  %");
	      Thread.currentThread().sleep(100);
	      for(int i=1; i<=100; i++){
	        System.out.print("\b\b\b\b"+pad(i)+"%");
	        Thread.currentThread().sleep(100);
	      }
	    }
	    catch(Exception e){
	    }
	    System.out.print("\nDone!!!");
	  }
	  public static String pad(int i){
	    String s = ""+i;
	    if(s.length()==1){
	      s += "  ";
	    }
	    else if(s.length()==2){
	      s += " ";
	    }
	    return s;
	  }
}
