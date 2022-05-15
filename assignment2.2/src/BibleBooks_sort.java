// assignment2.2 - CSC250 by Kristopher Smolarek
// title, chapters, summary from book_call3 (read in from New_Testament_books.dat)
// single constructor and display method for book data

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