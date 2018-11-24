import java.util.*;
public class AddOne
{
	int addone(int x)
	{
		return (-(~x));
	}
	int addShift(int x)
	{
		int m=1;
		while(((int)(x&m))!=0)
		{
			x = x ^ m;
			m <<= 1;
		}
		x= x ^ m;
		return x;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n;
		n=sc.nextInt();
		AddOne obj=new AddOne();
		System.out.println(obj.addone(n));
		System.out.println(obj.addShift(n));
	}
}