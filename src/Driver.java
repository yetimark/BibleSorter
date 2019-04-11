import java.io.FileInputStream;
import java.util.Scanner;
import java.util.LinkedList;
public class Driver 
{
	public static void main(String[] args) 
	{
		BibleBook[] theBible;
		try
		{
			LinkedList<String> ll = new LinkedList<String>();
			FileInputStream fis = new FileInputStream("C:\\Users\\Blaine\\Desktop\\BibleBooks.txt");
			Scanner input = new Scanner(fis);
			while(input.hasNextLine())
			{
				ll.add(input.nextLine());
			}
			
			theBible = new BibleBook[ll.size()];
			
			for(int i = 0; i < ll.size(); i++)
			{
				theBible[i] = new BibleBook(ll.get(i));
			}
			
			Driver.displayBibleBooks(theBible);
			Driver.mergeSort(theBible);
			System.out.println("*******");
			Driver.displayBibleBooks(theBible);
			
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong: " + e.toString());
		}
		
	}
	
	public static void displayBibleBooks(BibleBook[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			ar[i].display();
		}
	}
	
	private static void mergeStep(BibleBook[] ar, int begin1, int end1, int begin2, int end2)
	{
		//ar.getNumberOfChapters()
	}
	
	private static void mergeSortHelper(BibleBook[] ar, int begin, int end)
	{
		int begin1 = 0;
		int end1 = (begin + end) /2;
		int begin2 = end1 +1;
		int end2 = begin + end;
		
		Driver.mergeSortHelper(ar, begin1, end1);
		Driver.mergeSortHelper(ar, begin2, end2);
		Driver.mergeStep(ar, begin1, end1, begin2, end2);
	}
	
	private static void mergeSort(BibleBook[] ar)
	{
		int begin1 = 0;
		int end1 = (ar.length -1) /2;
		int begin2 = end1 +1;
		int end2 = ar.length -1;
		
		Driver.mergeSortHelper(ar, begin1, end1);
		Driver.mergeSortHelper(ar, begin2, end2);
		Driver.mergeStep(ar, begin1, end1, begin2, end2);
	}
}
