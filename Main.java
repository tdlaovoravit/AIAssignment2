package code;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

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
	  public LinkedList<String> Splice(ArrayList<List<String>> children){
	  ArrayList<List<String>> splicedfront = new ArrayList<List<String>>();
	  ArrayList<List<String>> splicedback = new ArrayList<List<String>>();
	  ArrayList<List<String>> splicedproduct = new ArrayList<List<String>>();
	  
	  ArrayList<List<String>> indexf = new ArrayList<List<String>>();
	  ArrayList<List<String>> indexb = new ArrayList<List<String>>();
	  //List<String> splicelist = new List<String>();
	  int x = rand.nextInt(3)+1;
	  for (int element = 0; element < 4; element++) {
		  ArrayList<List<String>> splicedf = new ArrayList<List<String>>();
		  splicedf.add(children.get(element).subList(0, x));
		  //creates a sublist of spliced lists
		  splicedfront.addAll(splicedf);
		  //List<String> splicelist = children.subList(0, 5);
		  ArrayList<List<String>> splicedb = new ArrayList<List<String>>();
		  splicedb.add(children.get(element).subList(x+1, 5));
		  splicedback.addAll(splicedb);
		  //adds spliced sublists to an arraylist spliced product
		  //TODO need to write the merge functions
	  }
	  //merge function
	  for (int i = 0; i<splicedfront.size(); i++){
		  int randelement = rand.nextInt(splicedfront.size());
		  indexf.add(splicedfront.get(i));
		  indexb.add(splicedback.get(randelement));
		  for(List<String> element:splicedfront){
			  List<String> buffer = new ArrayList<String>();
			  for(String e: element){
				  buffer.add(e);
			  }
			  for(String e: splicedback.get(0)){
				  buffer.add(e);
			  }
			  splicedproduct.add(buffer);
			  splicedback.remove(0);
		  }
		  
			  
			  
		  }
		  		  
	  }
	  
	  public ArrayList<List<String>> retInOrder(ArrayList<List<String>> Lof(int start,int goal){
  			for(LinkedList<String> los:lofl){
  				int soFar = start;
  				for(String s:los){
  					soFar = operate(soFar,s);
  					if(soFar == goal){
  						break;
  					}
  					los.addLast(Math.abs(soFar-goal).ToString());
		  }
		ArrayList<List<String>> retList = new ArrayList<List<String>>();
		while(lofl.size()>0){
			int lowdiff = Integer.MAX_VALUE;
				for(LinkedList<String> los:lofl){
					if(los.getLast()<lowdiff){
						lowdiff = los.getLast();
						addNext = los;
				}	
		}
				retlist.AddLast(addNext);
				lofl.remove(addNext);
		}
		return retlist;
  			}
  		}
}
////////////////////////////////////////////////////////////////////////////////////////
package assginment2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
	static int genCounter =0;
	static int goal; //goal
	static int start; //start
	static double timeLimit; //timeLimit
	static String type; //type
	static ArrayList<String> operations = new ArrayList<String>();//operations
	static long endTime;
	static long startTime;
	static Random rand = new Random();
	static int[] ErrorAndLength = {1000000,10000000};
	static int[] checkErrorAndLength = new int[2];
	static List<String> bestPath = new LinkedList<String>();
	static ArrayList<LinkedList<String>> startPaths = new ArrayList<LinkedList<String>>();

	
	
	public static void main(String args[]){

		System.out.println("please input the file location of the .txt file you want to run");
	    Scanner user_input = new Scanner(System.in);
	    String line= user_input.nextLine();  
		String fileName = line;
		//C:\Users\hp\workspace\Assignment2\src\assginment2\test_1.txt
		try
		 {
			 BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
			 System.out.println("opened");
			 String inputFromTxt;
				int count=0;
				while((inputFromTxt=in.readLine()) != null){
					if(count==0){
						type = inputFromTxt.trim();
					}
					else if(count==1){
						start = Integer.parseInt(inputFromTxt.trim());
					}
					else if(count==2){
						goal = Integer.parseInt(inputFromTxt.trim());
					}
					else if(count==3){
						timeLimit = Double.parseDouble(inputFromTxt.trim());
					}
					else{
						operations.add(inputFromTxt.trim());
					}
					count++;
				}
				//at this point the type, start, goal, timeLimit,and array of operations should have been stored
				
			 in.close();
			 
			 if (type.equals("genetic")){
				 
				 int counter2 = 0;
				 startPaths=initiate();
				 System.out.println(1);
				 startPaths = sortList(startPaths,start,goal);
				 System.out.println(2);
				 genCounter++;
				 startTime = System.currentTimeMillis();
				 endTime = startTime+(int)(timeLimit*1000);
				 while(System.currentTimeMillis()<endTime){//timer
					 startPaths = Splice(startPaths);
					 counter2++;
					 if(counter2 == 5){//mutate every 5
						 mutate(startPaths);
						 counter2=0;
					 }
					 startPaths = sortList(startPaths,start,goal);
					 genCounter++;
					 //System.out.println(2);
				 }
				 printResults();
			 }
			 
			 }
		catch (IOException e){
				 System.out.println("error");
		}

		 
	}
	
	public static ArrayList<LinkedList<String>> initiate(){//returns 20 genes with 5 depth randomized with String operators
		ArrayList<LinkedList<String>> returnList = new ArrayList<LinkedList<String>>();
		for (int i = 0; i<20; i++){
			LinkedList<String> tempList = new LinkedList<String>();
			for (int j = 0; j<5; j++){
				tempList.add(operations.get(rand.nextInt(operations.size())));
				
			}
			returnList.add(tempList);
		}
		return returnList;
	}
	
	public static void mutate(ArrayList<LinkedList<String>> input){//set the last two genes with one random mutation
		input.get(input.size()-2).set(rand.nextInt(5), operations.get(rand.nextInt(operations.size())));
		input.get(input.size()-1).set(rand.nextInt(5), operations.get(rand.nextInt(operations.size())));
	}
	
	public static void compare(int[] best,int[] check, List<String> current){
		System.out.println(0.3);
		if(best[0] > check[0]){//error
			bestPath=current;
		}
		if(best[0]==check[0]){//depth
			if(best[1] < check[1]){
				bestPath=current;
			}
		}
	}
	public static int operate(int parentnum, String operation){ //parent 'operation' = return value
	    String num = operation.replaceAll(" ", "");
	    int secondnumber = Integer.parseInt(num.substring(1, num.length()));
	    String startop = operation.substring(0, 1);
	    if(startop.equals("+")){
	      return parentnum + secondnumber;
	    }
	    if(startop.equals("-")){
	      return parentnum - secondnumber;
	    }
	    if(startop.equals("*")){
	      return parentnum * secondnumber;
	    }
	    if(startop.equals("^")){
	      return (int) Math.pow(parentnum, secondnumber);
	    }
	    if(startop.equals("/")){
	      return parentnum / secondnumber;
	    }
	    System.out.println("Invalid or unknown operation string");
	    return 0;
	  }
	public static ArrayList<LinkedList<String>> sortList(ArrayList<LinkedList<String>> listofl, int start, int goal){// sorts and stores best so far		
		for(LinkedList<String> los : listofl){
			int counter = 0;
			int sofar = start;
			for(String s : los){
				sofar = operate(sofar, s);
				counter++;
				if(sofar == goal){
					checkErrorAndLength[0]=0;
					checkErrorAndLength[1]=counter;
					break; 
				}
				checkErrorAndLength[0]=Math.abs(goal-sofar);
				checkErrorAndLength[1]=5;
			}
			compare(ErrorAndLength,checkErrorAndLength,los);
			los.addLast(Integer.toString(Math.abs(goal - sofar)));
		}
		ArrayList<LinkedList<String>> retlist = new ArrayList<LinkedList<String>>();
		int shortestl = Integer.MAX_VALUE;
		LinkedList<String> shortlist = new LinkedList<String>();
		while(listofl.size() > 0){
			for(LinkedList<String> los : listofl){
				if(Integer.parseInt(los.getLast()) < shortestl){
					shortestl = Integer.parseInt(los.getLast());
					shortlist = los;
				}
			}
			shortestl = Integer.MAX_VALUE;
			shortlist.removeLast();
			retlist.add(shortlist);
			listofl.remove(shortlist);
		}
		return retlist;
	}
	
	public static ArrayList<LinkedList<String>> Splice(ArrayList<LinkedList<String>> children){
		ArrayList<LinkedList<String>> splicedfront = new ArrayList<LinkedList<String>>();
		ArrayList<LinkedList<String>> splicedback = new ArrayList<LinkedList<String>>();
		ArrayList<LinkedList<String>> splicedproduct = new ArrayList<LinkedList<String>>();
		  System.out.println(children);
		ArrayList<LinkedList<String>> indexf = new ArrayList<LinkedList<String>>();
		ArrayList<LinkedList<String>> indexb = new ArrayList<LinkedList<String>>();
		//List<String> splicelist = new List<String>();
		int x = rand.nextInt(3);
		for (int element = 0; element < 4; element++) {
		  ArrayList<LinkedList<String>> splicedf = new ArrayList<LinkedList<String>>();
		  LinkedList<String> tempo = new LinkedList<String>();
		  for( String t: children.get(element)){
		  }
		  for (String b: children.get(element).subList(0,x)){
			  tempo.add(b);
		  }
		  splicedf.add(tempo);
		  //creates a sublist of spliced lists
		  splicedfront.addAll(splicedf);
		  //List<String> splicelist = children.subList(0, 5);
		  ArrayList<LinkedList<String>> splicedb = new ArrayList<LinkedList<String>>();
		  LinkedList<String> tempo2 = new LinkedList<String>();
		  for (String b: children.get(element).subList(x+1, 5)){
			  tempo2.add(b);
		  }
		  splicedb.add(tempo2);
		  splicedback.addAll(splicedb);
		  //adds spliced sublists to an arraylist spliced product
		  //TODO need to write the merge functions
		}
	  //merge function
	  for (int i = 0; i<splicedfront.size(); i++){
		  int randelement = rand.nextInt(splicedfront.size());
		  indexf.add(splicedfront.get(i));
		  indexb.add(splicedback.get(randelement));
		  for(LinkedList<String> element:splicedfront){
			  LinkedList<String> buffer = new LinkedList<String>();
			  for(String e: element){
				  buffer.add(e);
			  }
			  for(String e: splicedback.get(0)){
				  buffer.add(e);
			  }
			  splicedproduct.add(buffer);
			  splicedback.remove(0);
		  }	  
	  }
	  return splicedproduct;
		  		  
	}
	public static void printResults(){
		System.out.print(start+" ");
		int value = start;
		for(int a = 0;a < ErrorAndLength[1]; a++){
			System.out.print(bestPath.get(a)+" = ");
			System.out.println(operate(value,bestPath.get(a))+"\n");
			value=operate(value,bestPath.get(a));
		}
		System.out.println("Error: "+ ErrorAndLength[0]);
		System.out.println("Size of organism: "+ ErrorAndLength[1]);
		System.out.println("Search required: "+timeLimit);//+ timer
		System.out.println("Population size: 20");//how many pop
		System.out.println("Number of generations: "+genCounter);// number of generations
	}
}



