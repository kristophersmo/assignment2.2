// Sorting BibleBooks from file New_Testament_books
// by Kristopher Smolarek (CSC250)

// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;

public class BibleBooks_sort
	{
		private Object title;
		private Object chapters;
		private Object summary;
	
	// create constructor for (class) BibleBook
	public BibleBooks_sort(Object i)
		{
			this.title = i;
		}
	// assign number of chapters to variable chapters
	public void num_chapters(Object book_chapters)
		{
			chapters = book_chapters;
		}
	// assign summary to variable summary
	public void theme(Object book_summary)
		{
			summary = book_summary;
		}
	public void display()
		{
			System.out.println(title +" (" + chapters + " chapters)" + " - " + summary);
		}
	}