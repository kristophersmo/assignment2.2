// BibleBooks sorting assignment by Kristopher Smolarek (CSC250)
// Read New Testament books from file "New_Testament_books.dat"
// Sort and display based on user choice for sorting method

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
				System.out.println("New Testament books will be sorted by " + sort_input);
				System.out.println();
				
				if (sort_input.compareTo("title") == 0)
					{
						// String[] NTbooks_title = new String[book_list.size()];
						for (int i = 0; i < NTbooks_array.length; i++)
							{
								for (int j = i+1; j < NTbooks_array.length; j++)
									{
										if (NTbooks_array[i].compareTo(NTbooks_array[j]) > 0)
											{
												String temp = NTbooks_array[i];
												NTbooks_array[i] = NTbooks_array[j];
												NTbooks_array[j] = temp;
											}
									}
							}
						// System.out.println(Arrays.toString(NTbooks_array));	
						for (int i = 0; i < NTbooks_array.length; i++)
						{
							BibleBooks_sort add_book = new BibleBooks_sort(NTbooks_array[i]);
							add_book.num_chapters(NTbooks_array[i]);
							add_book.theme(NTbooks_array[i]);
							add_book.display();
						}
					}
				// if (sort_input.compareTo("chapter") == 0)
						// {
						
						// }
				else
					{
						System.out.println("Invalid input. Please try again");
						return;
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
			return sort_input;
		}
	}