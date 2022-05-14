// Assignment2.2 - CSC250
// Read New Testament books from file "New_Testament_books.dat"
// Get user input for sorting method, sort/display based on user choice
// by Kristopher Smolarek

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
					
						String[] NTbooks_array = new String[book_list.size()];
						book_list.toArray(NTbooks_array);
						// System.out.println(Arrays.toString(NTbooks_array));
				
						String sort_input = user_choice();
						if (sort_input.compareTo("title") == 0)
							{
								titleSort(NTbooks_array);
							}
						else if (sort_input.compareTo("chapter") == 0)
							{
								chapterSort(NTbooks_array);
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
			System.out.println("Sort books alphabetically or by number of chapers? ");
			System.out.println("Please type either title or chapter");
			String sort_input = sort_type.nextLine();
			sort_type.close();
			System.out.println("New Testament books will be sorted by " + sort_input);
			System.out.println();
			return sort_input;
		}
	
	static void titleSort(String[] NTbooks_array)
		{
			Arrays.sort(NTbooks_array);
			// create new string and array to split NTbooks_array into title/chapters/summary
			// performing here, after sort by title
			String sorted_title = String.join(":", NTbooks_array);
			String[] title_array = sorted_title.split(":");
			
			// test printing for String sorted_title and String[] title_array
			// System.out.println(sorted_title);
			// System.out.println(Arrays.toString(title_array));
					
			for (int i = 0; i < title_array.length; i = i+3)
				{
					String title = title_array[i];
					Object chapters = title_array[i+1];
					String summary = title_array[i+2];
					BibleBooks_sort add_book = new BibleBooks_sort(title, chapters, summary);
					add_book.display();
				}	
		}
	
	static void chapterSort(String[] NTbooks_array)
		{
			// add sort by chapter here
		}
	
	}