
 import java.io.*;
 import java.net.*;

public class ip {
        
    
    public ip() {
    }
    
   
    public static void main(String[] args) {
    	
        
        try{
             InetAddress in1=InetAddress.getLocalHost();
		     String str = in1.getHostName();
 			 System.out.println("Host Name/IP Address     :"+in1);
		     System.out.println("Host Name    :"+str);
		   
        }
        catch(IOException e){
        }
    }
}
