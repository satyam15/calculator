import java.awt.*;
import java.awt.event.*;
class bck extends Frame implements ActionListener
{
Button b1,b3,b2,b4;
   public bck()
   {
     setTitle("first page");
	 setLayout(new FlowLayout());
	 b1=new Button("RED");
	 b2=new Button("BLUE");
	 b3=new Button("GREEN");
	 b4=new Button("EXIT");
	 add(b1);
	 add(b2);
	 add(b3);
	 add(b4);
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
	 setSize(400,200);
	 setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource()==b1)
	  {
	  setBackground(Color.red);
	  }
	  else if(e.getSource()==b2)
	  {
	  setBackground(Color.blue);
	  }
	  else if(e.getSource()==b3)
	  {
	  setBackground(Color.green);
	  }
	  else if(e.getSource()==b4)
	  {
	    System.exit(0);
	  }
	  
   }
}
class sec
{
public static void main(String args[])
{
bck obj=new bck();
}
}