import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Destination extends JFrame implements ActionListener
{
	JTabbedPane tp ;
	JLabel jl,jl1,jl2,jL;
	JButton jb,jb1,jb2, saveb;
	JTextField tf1,tf2,tfd,tfd1;
	static JTextArea tf,ta1;
	JScrollPane sp,sp1;
	static String g1=" ";
	static String n,n1,n2;
	static byte str[];
	static byte realSig[];
	static byte realSig1[];
	static String y="";
	static String str6,str61,str2,str12,str13;
	static String t,st="",st1="",vj="";

	public Destination()
	{
		super("Transaction");
		setSize(500,530);
		Container c = getContentPane();

		JPanel jp = new JPanel();
		jp.setLayout(null);
		jl = new JLabel("Sender Name ",JLabel.LEFT);
		jL = new JLabel("Receiver Name ",JLabel.LEFT);
		tfd = new JTextField(15);
		tfd1 = new JTextField(15);
		tf = new JTextArea(20,40);
		sp = new JScrollPane(tf);
		jb= new JButton("OPEN");
		saveb = new JButton("SAVE");
		jp.add(jl);
		jp.add(tfd);
		jp.add(jL);
		jp.add(tfd1);
		jp.add(sp);
		jp.add(jb);
		jp.add(saveb);

		jl.setBounds(25,10,150,25);
		tfd.setBounds(150,10,150,25);
		jL.setBounds(25,40,150,25);
		tfd1.setBounds(150,40,150,25);
		sp.setBounds(25,70,450,350);
		jb.setBounds(200,425,75,25);
		saveb.setBounds(300,425, 75,25);
		jp.setVisible(true);

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jl1 = new JLabel("Sender Name ",JLabel.LEFT);
		jl2 = new JLabel("Receiver Name ",JLabel.LEFT);
		tf1 = new JTextField(15);
		tf2 = new JTextField(15);
		ta1 = new JTextArea(20,40);
		sp1 = new JScrollPane(ta1);
		jb2= new JButton("Retrive");

		jl1.setBounds(25,10,150,25);
		tf1.setBounds(150,10,150,25);
		jl2.setBounds(25,40,150,25);
		tf2.setBounds(150,40,150,25);
		sp1.setBounds(25,70,450,350);
		jb2.setBounds(220,425,75,25);
		jb.addActionListener(this);
		jb2.addActionListener(this);
		saveb.addActionListener(this);
		jp1.add(jl1);
		jp1.add(tf1);
		jp1.add(jl2);
		jp1.add(tf2);
		jp1.add(sp1);
		jp1.add(jb2);
		jp1.setVisible(true);
		ta1.setText("");

		tp = new JTabbedPane();
		tp.addTab("Message",null,jp,"Retrive the Message here");
		//tp.addTab("File",null,jp1,"Retrive the File Name here");
		c.add(tp);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String arg[])throws Exception
	{
		Destination rm = new Destination();

	}

	public static void ServSoc(String str2,String sw,String sw1)
	{
		try
		{
		char a[]=new char[50000];
		char res[]=new char[9];
		char s1[]=new char[5];
		String w =new String();
		String r =new String();
		int i,j=0,d=1,h,n,l=8,c=0,l2=0,l1=0;
		String t,st="",st1="";
		str6=sw;
		str61=sw1;

		System.out.println("Enter the Hex-Code:");
		System.out.println(str2);
		int len=str2.length();
		System.out.print("String Length:");
		System.out.println(len);

	      /*   Converting Hexcode into Bits    */

				for(i=0;i<len;i++)
				{
					char aa= ((str2).charAt(i));
					a[i]=aa;
					if(a[i]=='A')
					{
						st="1010";
						st1=st;
					}
					else if(a[i]=='B')
					{
						st="1011";
						st1=st;
					}
					else if(a[i]=='C')
					{
						st="1100";
						st1=st;
					}
					else if(a[i]=='D')
					{
						st="1101";
						st1=st;
					}
					else if(a[i]=='E')
					{
						st="1110";
						st1=st;
					}
					else if(a[i]=='F')
					{
						st="1111";
						st1=st;
					}
					else if(a[i]=='0')
					{
						st="0000";
						st1=st;
					}
					else if(a[i]=='1')
					{
						st="0001";
						st1=st;
					}
					else if(a[i]=='2')
					{
					st="0010";
						st1=st;
					}
					else if(a[i]=='3')
					{
						st="0011";
						st1=st;
					}
					else if(a[i]=='4')
					{
						st="0100";
						st1=st;
					}
					else if(a[i]=='5')
					{
						st="0101";
						st1=st;
					}
					else if(a[i]=='6')
					{
						st="0110";
						st1=st;
					}
					else if(a[i]=='7')
					{
						st="0111";
						st1=st;
					}
					else if(a[i]=='8')
					{
						st="1000";
					}
					else if(a[i]=='9')
					{
						st="1001";
					}
					w=w+st;
				}

				char w_ch[]=w.toCharArray();
				String x=w.toString();
				System.out.print(x);
				System.out.println("Length:"+len);

				      /*   Converting Hexcode into Character   */


				try
				{
					if(len==8)
					{
						int k;
						k=len;
						for(j=k-1;j>=0;j--)
						{
							c=c+(w_ch[j]-48)*d;
							y=y+c;
							d=d*2;
						}
						System.out.print("\n");
						vj=vj+(char)c;
						//System.out.print((char)c);
					}



					else
					{
						int k;
						for(i=0;i<5000;i++)
						{
							c=0; d=1;
							k=i*8;
							for(j=k+7;j>=k;j--)
							{
								c=c+(w_ch[j]-48)*d;
								y=y+c;
								d=d*2;
							}
							vj=vj+(char)c;
							//System.out.print((char) c);
						}
					}

				}
				catch(Exception e)
				{

				}

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println("the file content is :"+vj);
			System.out.println("File Ends *********** ");
			ta1.append(vj);
		}



	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == jb2)
		{
			
			
			tf1.setText(str6);
			tf2.setText(str61);
			ta1.setText(vj);

		}
		else if(e.getSource() == jb)
		{
			JOptionPane.showMessageDialog(null, "Signature are Verified","Verify Sign", JOptionPane.ERROR_MESSAGE);
			
			tfd.setText(str6);
			tfd1.setText(str61);
			System.out.print("FileContent"+vj);
			tf.setText(vj);
		}
		else if(e.getSource() == saveb)
		{
			
			try{
		String smsg = ta1.getText();
	   	JFileChooser jf1=new JFileChooser();
		int m1=jf1.showSaveDialog(null);
		if(m1==JFileChooser.APPROVE_OPTION) 
		{
			      File f1=jf1.getSelectedFile();
			     
				  String path1=f1.getAbsolutePath();
				  
				  FileOutputStream fop=new FileOutputStream(path1,true);
			
				  byte bb1[]=smsg.getBytes();
			
				  fop.write(bb1);
			
		 		  fop.close();
				 
		}
		 
		}
		catch(Exception e4)
		{
			System.out.println("Error in Save Function  " + e4);
		}
		}
	}
}
