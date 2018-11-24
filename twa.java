import java.awt.*;
import java.awt.event.*;
import java.applet.*;
class two extends Frame implements ActionListener,TextListener
{
Button b1;
Label l1,l2,l3;
TextField t1,t2,t3;
public two()
{
setTitle("Event handler");
setLayout(new GridLayout(4,2));
setSize(400,250);
b1=new Button("Exit");
l1=new Label("basic pay");
l2=new Label("travel allowance");
l3=new Label("dear allowance");
t1=new TextField(20);
t2=new TextField(20);
t3=new TextField(20);

add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(b1);
t1.addTextListener(this);
b1.addActionListener(this);
setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
System.exit(0);
}
public void textValueChanged(TextEvent e)
{ 
int bs;
double ta=0.0,da=0.0;
if(e.getSource()==t1)
{
bs=Integer.parseInt(t1.getText());
ta=0.4*bs;
da=0.6*bs;
t2.setText(Double.toString(ta));
t3.setText(Double.toString(da));
}
}
public static void main(String args[])
{
two obj=new two();
}

}