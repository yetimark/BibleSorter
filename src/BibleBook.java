
public class BibleBook 
{
	private String title;
	private int numberOfChapters;
	
	public BibleBook(String title, int numberOfChapters)
	{
		this.title = title;
		this.numberOfChapters = numberOfChapters;
	}
	
	public BibleBook(String srcString)
	{
		this.title = "";
		String chapterString = "";
		boolean foundTitle = false;
		for(int i = 0; i < srcString.length(); i++)
		{
			if(!foundTitle)
			{
				if(srcString.charAt(i) != '(')
				{
					this.title += srcString.charAt(i);
				}
				else
				{
					this.title = this.title.trim();
					foundTitle = true;
				}
			}
			else //looking for number of chapters
			{
				if(srcString.charAt(i) != ' ')
				{
					chapterString += srcString.charAt(i);
				}
				else
				{
					this.numberOfChapters = Integer.parseInt(chapterString);
					break;
				}
			}
		}
		//display here
	}
	
	public void display()
	{
		System.out.format("%s - (Number of Chapters: %d)\n", this.title, this.numberOfChapters);
	}
	
	public int getNumberOfChapters()
	{
		return this.numberOfChapters;
	}
}
