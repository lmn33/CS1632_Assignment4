import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class ArraysTest 
{
	//static int size;
	//static int actualSize;
	//static int[] numbers;
	/*public static void main(String [] args)
	{
		Random rnd = new Random();
		rnd.setSeed(1000);
		for(int i=0; i<106; ++i)
		{
			Random newRnd = new Random();
			size=rnd.nextInt();
			numbers=new int[size];
			for(int k=0;k<size;++k)
			{
				numbers[k]=newRnd.nextInt();
			}
			Arrays.sort(numbers);
			actualSize=numbers.length;
			
			//1.Check output array same size as array passed in
			//2.Values in output array always increasing or staying
			//3.Value in output array never decreasing
			//4.Every element in input array is in output array
			//5.No element not in input array is in output array
			//6.Idempotent - running it again should not change output array
			//7.Pure - running it twice on same input array should always result in same output array
			//8.Only ints are entered
		}
	}*/
	
	//Generates an array of given size and 
	//fills the array with random ints
	public int[] createArray(int ArraySize) 	
	{											
		//Random rnd = new Random();
		//rnd.setSeed(1000);
		Random newRnd = new Random();
		int size=ArraySize;
		int [] numbers=new int[size];
		for(int k=0;k<size;++k)
		{
			numbers[k]=newRnd.nextInt();
		}
		return numbers;
	}
	
	//runs the createArray method and guarantees
	//that the size passed in is the array size
	@Test
	public void testShowsCorrectSize() 			
	{											
		for(int i=0;i<150;++i)
		{
			Random rnd = new Random();
			//rnd.setSeed(1000);
			
			int size=rnd.nextInt(1000)+1;
			System.out.println(size);
			int[] numbers=createArray(size);
			assertTrue(size==numbers.length);
		}
		
	}
	
	//runs the createArray method and guarantees
	//that the java sort() method has the beggining
	//and end items in the correct order
	@Test
	public void beginningEndSort()							
	{														
		for(int i=0;i<150;++i)								
		{
			Random rnd = new Random();
			//rnd.setSeed(1000);
			
			int size=rnd.nextInt(1000)+1;
			System.out.println(size);
			int[] numbers=createArray(size);
			Arrays.sort(numbers);
			assertTrue(numbers[0]<=numbers[numbers.length-1]);
		}
	}
	
	//runs the createArray method and guarantees
	//that the values do not change if the sort method
	//is called multiple times
	@Test
	public void runningSortMultipleTimesTest()					
	{															
		for(int i=0;i<150;++i)								
		{
			Random rnd = new Random();
			//rnd.setSeed(1000);
			
			int size=rnd.nextInt(1000)+1;
			System.out.println(size);
			int[] numbers=createArray(size);
			Arrays.sort(numbers);
			int first=numbers[0];
			int last=numbers[numbers.length-1];
			int middle=numbers[(numbers.length-1)/2];
			//assertTrue(numbers[0]<=numbers[numbers.length-1]);
			
			Arrays.sort(numbers);
			int first2=numbers[0];
			int last2=numbers[numbers.length-1];
			int middle2=numbers[(numbers.length-1)/2];
			
			Arrays.sort(numbers);
			int first3=numbers[0];
			int last3=numbers[numbers.length-1];
			int middle3=numbers[(numbers.length-1)/2];
			
			assertTrue((first==first2)&&(first==first3));
			assertTrue((middle==middle2)&&(middle==middle3));
			assertTrue((last==last2)&&(last==last3));
		}
	}
}
