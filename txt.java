import java.awt.*;
import java.awt.event.*;
import java.applet.*;
class text extends Frame implements ActionListener,TextListener
{
Label l1,l2,l3;
TextField t1,t2,t3;
Button b1;
public text()
{
setTitle("TEXT EDITOR");
setLayout(new GridLayout(4,2));
setSize(450,200);
l1=new Label("Basic Salary");
l2=new Label("Ta");
l3=new Label("Da");
t1=new TextField(10);
t2=new TextField(10);
t3=new TextField(10);
b1=new Button("Exit");
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
if(e.getSource()==t1)
{
int bs,ta,da;
bs=Integer.parseInt(t1.getText());
ta=(bs*4)/100;
da=(bs*6)/100;
t2.setText(Integer.toString(ta));
t3.setText(Integer.toString(da));
}
}
public static void main(String args[])
{
text obj=new text();
}
}