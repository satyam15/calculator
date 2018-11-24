import java.awt.*;
import java.awt.event.*;
import java.util.*;
class sum extends Frame implements ActionListener
{
Button b1,b2,b3,b4;
int num1,num2;
TextField t1;
public sum(int n1,int n2)
{
	num1=n1;
	num2=n2;
setTitle("sum of two numbers");
setLayout(new GridLayout(3,3));
b1=new Button(Integer.toString(n1));
b2=new Button(Integer.toString(n2));
b3=new Button("sum");
b4=new Button("Exit");
t1=new TextField(10);
add(t1);
add(b1);
add(b2);
add(b3);
add(b4);
b3.addActionListener(this);
b4.addActionListener(this);
setSize(400,250);
setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b3)
{

int sum=num1+num2;
t1.setText(Integer.toString(sum));
}
else if(e.getSource()==b4)
{
	System.exit(0);
}
}
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter buttons values");
	int n1,n2;
	n1=sc.nextInt();
	n2=sc.nextInt();
sum obj=new sum(n1,n2);
}

}