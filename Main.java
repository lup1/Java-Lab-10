/*	PoeAn Lu
	CSC220-01
	Lab 10	*/
	
	import java.util.Scanner;
	import java.util.ArrayList;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.InputMismatchException;
	
	
	public class Main {
		static Scanner scnr = new Scanner(System.in);
		static boolean pathWork;	// Does the path still work?
		private static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		
		
		
		public static void main(String[] args) {
			
			System.out.println("Input file name: ");
			String fileName = scnr.next();
			//new ArrayList mapRows.map(fileName);
			
			
			//path(map);
			// 2D arraylist? something else?
			System.out.println("Input x-coordinate of starting location: ");
			int x0 = scnr.nextInt();
			System.out.println("Input y-coordinate of starting location: ");
			int y0 = scnr.nextInt();
			System.out.println("Input x-coordinate of ending location: ");
			int x1 = scnr.nextInt();
			System.out.println("Input y-coordinate of ending location: ");
			int y1 = scnr.nextInt();
			map(fileName);
			
			if(map.get(x0).get(y0)==0 && map.get(x1).get(y1)==0) {
				System.out.println("Invalid starting and ending locations");
			}
			else if(map.get(x0).get(y0)==0) {
				System.out.println("Invalid starting location");
			}		
			else if(map.get(x1).get(y1)==0) {
				System.out.println("Invalid ending location");
			}
			else if(path(x0,y0,x1,y1)==true) {
				System.out.println("There is a path.");
			}
			else {
				System.out.println("There is no path.");
			}
		}
		/*
		public void createMap(String fileName) {	// Creates a 2D array to simulate a map
			
			
			File f = new File(fileName);
			try {
				scnr = new Scanner(f);				
				
			}
		}
		*/
		
		public static void map(String fileName) {	//Defines the path
			File f = new File(fileName);
			try {
				scnr = new Scanner(f);											
				while (scnr.hasNextLine()){
					String s = scnr.nextLine();
					String [] numbers = s.split(" ");
					ArrayList<Integer> row = new ArrayList<Integer>();
					for(int i=0;i<numbers.length;i++)
					{
						row.add(Integer.parseInt(numbers[i]));
					}
					map.add(row);
				}
			}
			catch (FileNotFoundException e){
				System.out.println("File not found");
			}
			catch (InputMismatchException e){
				System.out.println("Input mismatch");
			}
			catch (Exception e){
				System.out.println("Error in file reading");
			}
			finally {
				if (scnr != null){
					scnr.close();
				}
			}
		}
		
		public static boolean path(int x, int y, int x1, int y1) {
	
				if(x==x1&&y==y1) return true;
				
				if(x<map.size()-2 && map.get(x+1).get(y)==1)
				{
					if(path(x+1,y,x1,y1)==true)
						return true;
				}
				if(y<map.get(x).size()-2 && map.get(x).get(y+1)==1)
				{
					if(path(x,y+1,x1,y1)==true)
						return true;
				}
				
				return false;
			
		}
		
		
		
		
		
	}