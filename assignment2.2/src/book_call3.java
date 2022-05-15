// Assignment2.2 - CSC250 by Kristopher Smolarek
// Read New Testament books from file "New_Testament_books.dat"
// Get user input for sorting method, sort/display based on user choice

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class book_call3
{
	public static void main(String[] args)
	{
		try
		{
			Scanner fileIn = new Scanner(new File(System.getProperty("user.dir") + "/src/New_Testament_books.dat"))
			.useDelimiter("\n");
			List<String> book_list = new ArrayList<String>();
			
			while(fileIn.hasNext())
			{
				String items = fileIn.next();
				book_list.add(items);
			}
				fileIn.close();
					
			String[] booksArray = new String[book_list.size()];
			book_list.toArray(booksArray);
			// test print for booksArray
			// System.out.println(Arrays.toString(booksArray));
				
			String sort_input = user_choice();
			if (sort_input.compareTo("title") == 0)
				{
					titleSort(booksArray);
				}
			else if (sort_input.compareTo("chapter") == 0)
				{
					chapterSort(booksArray);
				}
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
		}
	}
	
	static String user_choice()
	{
		Scanner sort_type = new Scanner(System.in);
		System.out.println("Welcome to the New Testament BibleBooks display");
		System.out.println("Sort books alphabetically or by number of chapters? ");
		System.out.println("Please type either title or chapter");
		String sort_input = sort_type.nextLine();
		sort_type.close();
		System.out.println("You chose to sort by " + sort_input);
		System.out.println();
		return sort_input;
	}
	
	static void titleSort(String[] booksArray)
	{
		for (int i = 0; i < booksArray.length; i++)
		{
			for (int j = i+1; j < booksArray.length; j++)
			{
				if (booksArray[i].compareTo(booksArray[j]) > 0)
				{
					String temp = booksArray[i];
					booksArray[i] = booksArray[j];
					booksArray[j] = temp;
				}
			}
		}
		// create new string and array to split booksArray into title/chapters/summary
		// performing here, after sort by title
		String sorted_title = String.join(":", booksArray);
		String[] title_array = sorted_title.split(":");
					
		for (int i = 0; i < title_array.length; i+=3)
		{
			String title = title_array[i];
			Object chapters = title_array[i+1];
			String summary = title_array[i+2];
			BibleBooks_sort add_book = new BibleBooks_sort(title, chapters, summary);
			add_book.display();
		}	
	}
	
	static void chapterSort(String[] booksArray)
	{
		// create new string and array to split booksArray into title/chapters/summary
		// performing here, before sort by chapter
		String strBychapter = String.join(":", booksArray);
		String[] chapter_array = strBychapter.split(":");
			
		for (int i = 1; i < chapter_array.length; i+=3)
		{
			for (int j = i+3; j < chapter_array.length; j+=3)
			{
				if (chapter_array[i].compareTo(chapter_array[j]) > 0)
				{
					String temp = chapter_array[i];
					chapter_array[i] = chapter_array[j];
					// move title and summary elements with chapter
					chapter_array[i-1] = chapter_array[j-1];
					chapter_array[i+1] = chapter_array[j+1];
					chapter_array[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < chapter_array.length; i+=3)
		{
			String title = chapter_array[i];
			Object chapters = chapter_array[i+1];
			String summary = chapter_array[i+2];
			BibleBooks_sort add_book = new BibleBooks_sort(title, chapters, summary);
			add_book.display();
		}	
	}
}