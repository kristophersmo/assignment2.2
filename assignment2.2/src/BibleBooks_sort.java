// Sorting BibleBooks from file New_Testament_books
// by Kristopher Smolarek (CSC250)

// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;

public class BibleBooks_sort
	{
		private String title;
		private Object chapters;
		private String summary;
	
	// create constructor for (class) BibleBook
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