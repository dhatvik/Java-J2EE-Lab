//Thread1
package threading;

import java.util.Scanner;

public class Thread1 extends Thread{
	public String word;
	public static String vowels="aeiou";
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		word=sc.next();
		int count=0;
		for(char c1: vowels.toCharArray())
		{
			for(char c2: word.toCharArray())
			{
				if(c1==c2)    count++;
			}
		}
		System.out.println("Number of vowels given word="+count);
	}


}

//Thread2

package threading;

import java.util.ArrayList;
import java.util.Scanner;

public class Thread2 extends Thread{
	public static String digits[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public String number;
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter more then 4 digits number:");
		number=sc.next();
		for(char ch: number.toCharArray() )
		{   
			int i=(int)ch-48;
			System.out.print("  "+digits[i]);
		}
	}

}


//Main

package threading;

public class Main {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread1 ob1=new Thread1();
		Thread2 ob2=new Thread2();
		ob1.start();
		
			Thread.sleep(7000);
		
		ob2.start();
	}

}
