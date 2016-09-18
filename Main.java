package code;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args)
	{
		mutate();
	}
	
	public static void mutate()
	{
		Random r=new Random();
		ArrayList<String> ops=new ArrayList<String>();
		ops.add("+");
		ops.add("-");
		ops.add("*");
		ops.add("/");
		ops.add("^");
		ArrayList<String> nums=new ArrayList<String>();
		for(int i=1; i<=9; i++)
		{
			nums.add(""+i);
		}
		
		ArrayList<String> str=new ArrayList<String>();
		str.add("+ 3");
		str.add("- 1");
		str.add("/ 2");
		str.add("* 5");
		str.add("^ 2");
		int probability=r.nextInt(5);
		System.out.println(probability);
		for(int i=0; i<str.size(); i++)
		{
			System.out.println(str.get(i));
		}
		if(probability>2)
		{
			int mutated=r.nextInt(str.size());
			int op=r.nextInt(ops.size());
			int num=r.nextInt(nums.size());
			System.out.println();
			System.out.println(mutated);
			System.out.println(op);
			System.out.println(num);
			str.set(mutated, ops.get(op)+" "+nums.get(num));
		}
		for(int i=0; i<str.size(); i++)
		{
			System.out.println(str.get(i));
		}
	}
}
