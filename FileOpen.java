import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.event.*;

class FileOpen extends JFrame 
{
	 JLabel jl1;
	 JLabel jl2;
	 JLabel jl3;
	 JLabel jl5;
	 JButton jb1;
	 JButton jb2;
	 JButton jb3;
	 JTextField jt1;
	 JTextField jt2;
	 String msg="";
	 static JTextArea jta;
	 JScrollPane jsp1;
	 Container c;
	 ImageIcon ii;
	 ImageIcon i2;
	 JLabel jl4;
	 JLabel jl6;
	 JLabel jl7;
	 JList jlist;
	 JScrollPane jsp;
	 String str="";
	 Core co;
	 ReCore rc;
	 String pass="";
	 String path="";
	 String coreaddr="";
	 String core="";
	 String nextcore="";
	 String dest="";
	 String dest1="";
	 File f;
	 File fgs;
	 Vector v = new Vector();

	 FileOpen()

	 {
		 new net();
		 v = net.vnode;
		 jl1=new JLabel("Plz Enter The Destination Name ");
		 jl2=new JLabel("Plz Choose File ");
		 jl3=new JLabel("File Name Will Be Displayed Here..");
		 jl5=new JLabel("Next Core Address ");
		 jb1=new JButton("Send");
		 jb2=new JButton("Reset");
		 jb3=new JButton("Browse..");
		 jt1=new JTextField(10);
		 jt2=new JTextField(10);
		 ii=new ImageIcon("Multi.jpg");
		 i2=new ImageIcon("tele.jpg");
		 jl4=new JLabel(ii);
		 jl6=new JLabel(i2);
		 jl7=new JLabel("NEXTMESH");
		 jta=new JTextArea();
		 jsp=new JScrollPane(jta);
		 jlist=new JList(v);
		 jsp1=new JScrollPane(jlist);
		 c=getContentPane();
		 c.setLayout(null);
		 c.add(jl1);
		 c.add(jt1);
		 c.add(jl2);
		 c.add(jl3);
		 c.add(jb3);
		 c.add(jb1);
		 c.add(jb2);
		 c.add(jsp);
		 c.add(jl4);
		 c.add(jl5);
		 c.add(jl6);
		 c.add(jl7);
		 c.add(jt2);
		 c.add(jsp1);
		 jl4.setBounds(0,10,900,90);
		 jl1.setBounds(70,110,200,25);
		 jt1.setBounds(300,110,100,25);
		 jl2.setBounds(70,145,200,25);
		 jt2.setBounds(300,145,100,25);
		 jb3.setBounds(300,180,100,25);
		 jsp.setBounds(410,110,280,400);
		 jb1.setBounds(150,235,100,25);
		 jb2.setBounds(300,235,100,25);
		 jl6.setBounds(150,275,250,150);
		 jl7.setBounds(700,75,75,50);
		 jsp1.setBounds(700,110,150,400);
		 jl3.setBounds(35,440,600,25);
		 jl5.setBounds(35,475,600,25);
		 setSize(900,600);
		 setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		 jb3.addActionListener(new ActionListener() {

			 public void actionPerformed(ActionEvent ae)
			 {
				JFileChooser jf=new JFileChooser();
				jta.setText("");
				String str1 = "";
				int m=jf.showOpenDialog(null);
				if(m==JFileChooser.APPROVE_OPTION)
				{
				   f=jf.getSelectedFile();
				   str=f.getPath();
				   path=f.getAbsolutePath();
				   jl3.setText("The Selected File:\""+str);
				try
				{
				   FileInputStream fis=new FileInputStream(str);
				   byte b[]=new byte[fis.available()];
				   jt2.setText(str);
				   fis.read(b);
					str1=new String(b);
				   jta.setText(str1);
			   }
			   catch(Exception ui){}
			   }
			}
		} );
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae)
			{
				
				co=new Core();
				rc=new ReCore();

				try {
				coreaddr=co.findCore();
				jl3.setText("The Core Address is : "+coreaddr);
				String d=((InetAddress.getLocalHost()).getHostAddress());
				System.out.println("The local address is : "+d);
				dest=jt1.getText();
				dest1=jt2.getText();
				jl5.setText(dest);
				pass=co.met1();
				if(coreaddr.equals((InetAddress.getLocalHost()).getHostAddress()))
				{
			 //  nextcore = ReCore.sss;
                     nextcore=rc.reqCore();
                     System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwww"+nextcore);
                     if(nextcore.equalsIgnoreCase("false"))
                     {
                     	jl5.setText("The Next Mesh Not Found");
                     }
                     else
                     {
                     	jl5.setText("The Next Mesh Core is :"+nextcore);
                     }
                     
                     co.sendFileToCore(nextcore,(InetAddress.getLocalHost()).getHostAddress(),dest,pass);
                     //Thread.sleep(1000);
                     co.sendFileToCore(nextcore,(InetAddress.getLocalHost()).getHostAddress(),dest1,pass);
			
				}
				else
				{
					co.sendFileToCore(coreaddr,(InetAddress.getLocalHost()).getHostAddress(),dest,pass);
					//Thread.sleep(1000);
					co.sendFileToCore(coreaddr,(InetAddress.getLocalHost()).getHostAddress(),dest1,pass);
					System.out.println("Successful transfer of file ");
					jl5.setText("The Next Mesh Core is :"+coreaddr);
					
				 }

			}
			catch(Exception e) { System.out.println(e);
			}

			}
});
	 
		jb2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae)
			{
			jt1.setText("");
			jt2.setText("");
			jta.setText("");
			} 
			});

			 jlist.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent le) 
 			{ 
 				System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 				if(!le.getValueIsAdjusting()) 
 				{ 
					try
					{
						Object o = jlist.getSelectedValue(); 
 						System.out.println("" + ((o==null)? "null" : o.toString()) + " is selected."); 
		 				String router=o.toString();
 						System.out.println("\nRouter is" +  router);
						FileOutputStream fos = new FileOutputStream("NEXTMESH.txt");
						fos.write(router.getBytes());
					}
					catch (Exception ee)
					{
						ee.printStackTrace();
					}
 				
 				}
			}
 			 //jsp1.setViewportView(jlist); 
	 } );
   }

	 public static void main(String a[])

	 {
		 new FileOpen();
	 }
 }
