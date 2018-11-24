import java.awt.*;
import java.awt.event.*;
class win extends Frame implements ActionListener
{
	Button b1,b2,b3,b4;
	public win()
	{
		setTitle("Event handling window");
		setLayout(new FlowLayout());
		b1=new Button("RED");
		b2=new Button("GREEN");
		b3=new Button("YELLOW");
		b4=new Button("CLOSE");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(400,150);
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
			setBackground(Color.green);
		}
		else if(e.getSource()==b3)
		{
			setBackground(Color.yellow);
			
		}
		else
		{
			System.exit(0);
		}
	}
}
class m
{
	public static void main(String args[])
	{
		win obj=new win();
	}
}
