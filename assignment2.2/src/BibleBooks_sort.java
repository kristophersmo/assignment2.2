// Assignment2.2 - CSC250
// Read New Testament books from file "New_Testament_books.dat"
// Get user input for sorting method, sort/display based on user choice
// by Kristopher Smolarek

public class BibleBooks_sort
	{
		private String title;
		private Object chapters;
		private String summary;
	
	// moved all parameters to single constuctor
	public BibleBooks_sort(String title, Object chapters, String summary)
		{
			this.title = title;
			this.chapters = chapters;
			this.summary = summary;
		}
	public void display()
		{
			System.out.println(title +" (" + chapters + " chapters)" + " - " + summary);
		}
	}