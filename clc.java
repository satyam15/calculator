import java.awt.*;
import java.awt.event.*;
import java.util.*;
class calc extends Frame implements ActionListener
{
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
Label l=new Label();
TextField t1;
Panel box1,box2;
public calc()
{
setTitle("Calculator");
//box1=new Panel();
box2=new Panel();
//box1.setLayout(new GridLayout());
box2.setLayout(new GridLayout(5,6));
box2.setBounds(0,50,400,350);
//add(box1);
add(box2);

t1=new TextField(100);

t1.setBounds(10,0,400,50);

b1=new Button("1");
b1.setBounds(0,60,60,60);

b2=new Button("2");
b2.setBounds(90,60,60,60);

b3=new Button("3");
b3.setBounds(180,60,60,60);

b4=new Button("4");
b4.setBounds(0,150,60,60);

b5=new Button("5");b5.setBounds(90,150,60,60);

b6=new Button("6");b6.setBounds(180,150,60,60);

b7=new Button("7");b7.setBounds(0,240,60,60);

b8=new Button("8");b8.setBounds(90,240,60,60);

b9=new Button("9");b9.setBounds(180,240,60,60);

b10=new Button("0");b10.setBounds(90,330,60,60);

b11=new Button("+");b11.setBounds(270,60,60,60);

b12=new Button("-");b12.setBounds(270,150,60,60);


b13=new Button("x");b13.setBounds(270,240,60,60);


b14=new Button("/");b14.setBounds(180,330,60,60);


b15=new Button("=");b15.setBounds(270,330,60,60);

b16=new Button("exit");b16.setBounds(0,330,60,60);


add(t1);
box2.add(b1);
box2.add(b2);
box2.add(b3);
box2.add(b11);
box2.add(b4);
box2.add(b5);
box2.add(b6);
box2.add(b12);
box2.add(b7);
box2.add(b8);
box2.add(b9);
box2.add(b13);
box2.add(b16);
box2.add(b10);
box2.add(b14);
box2.add(b15);
box2.add(l);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);
b11.addActionListener(this);
b12.addActionListener(this);
b13.addActionListener(this);
b14.addActionListener(this);
b15.addActionListener(this);
b16.addActionListener(this);
setSize(450,450);

setVisible(true);


}
public void actionPerformed(ActionEvent e)
{
	String str=t1.getText();
	
	if(e.getSource()==b1)
	{
		t1.setText(str+"1");
		System.out.println(t1.getText());
	}
	else if(e.getSource()==b2)
	{
		t1.setText(str+"2");
	}
	else if(e.getSource()==b3)
	{
		t1.setText(str+"3");
	}
	else if(e.getSource()==b4)
	{
		t1.setText(str+"4");
	}
	else if(e.getSource()==b5)
	{
		t1.setText(str+"5");
	}
	else if(e.getSource()==b6)
	{
		t1.setText(str+"6");
	}
	else if(e.getSource()==b7)
	{
		t1.setText(str+"7");
	}
	else if(e.getSource()==b8)
	{
		t1.setText(str+"8");
	}
	else if(e.getSource()==b9)
	{
		t1.setText(str+"9");
	}
	else if(e.getSource()==b10)
	{
		t1.setText(str+"0");
	}
	else if(e.getSource()==b11)
	{
		t1.setText(str+"+");
	}
	else if(e.getSource()==b12)
	{
		t1.setText(str+"-");
	}
	else if(e.getSource()==b13)
	{
		t1.setText(str+"*");
	}
	else if(e.getSource()==b14)
	{
		
		t1.setText(str+"/");
	}
	else if(e.getSource()==b15)
	{
		String str1="";
		String str2="";
		int len=str.length();
		int flag=0;
		for(int i=0;i<len-1;i++)
		{
			char ch=str.charAt(i);
			char ch2=str.charAt(i+1);
			if(ch=='/'&&ch2=='0')
			{
				flag=1;
				break;
			}
				
		}
		if(flag==1)
			t1.setText("divide by zero");
		else
		{
		str=infixToPostfix(str);
		int res=evaluatePostfix(str);
		if(res!=-123456)
		t1.setText(Integer.toString(res));
	    else
			t1.setText("divide by zero case");
		}
	}
	else if(e.getSource()==b16)
	{
		System.exit(0);
	}
	
}
static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
       
    // The main method that converts given infix expression 
    // to postfix expression.  
    static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
                    result += stack.pop(); 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop(); 
       
        return result; 
    } 
	static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
					if(val1==0)
						return -123456;
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 

public static void main(String args[])
{
	calc obj=new calc();
}
}