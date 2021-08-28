import java.io.*;

class r
{
public static void main(String args[])
{
try
{
Runtime rr = Runtime.getRuntime();
Process p = rr.exec("net view");
DataInputStream dis = new DataInputStream(p.getInputStream());
String s;
while((s=dis.readLine()) != null)
{
System.out.println(s);
}
}catch(Exception e)
{
e.printStackTrace();
}
}
}