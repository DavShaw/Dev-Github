package OOP.Book;

public class Book
{

    //Constructor
    private long ISBN;
    private int Pages;
    private String Title; 
    private String Author;
    
    public Book(long ISBN, int Pages, String Title, String Author)
    {
        this.ISBN = ISBN;
        this.Pages = Pages;
        this.Title = Title;
        this.Author = Author;
    }

    public String toString()
    {
        return String.format("Book %s with ISBN %s has been written by %s and has %s pages", this.Title, this.ISBN, this.Author, this.Pages);
    }

    //Set methods
    public void setISBN(long enter)
    {
        this.ISBN = enter;
    }

    public void setPages(int enter)
    {
        this.Pages = enter;
    }

    public void setTitle(String enter)
    {
        this.Title = enter;
    }

    public void setAuthor(String enter)
    {
        this.Author = enter;
    }

    //Get methods
    public long getISBN()
    {
        return this.ISBN;
    }

    public int getPages()
    {
        return this.Pages;
    }

    public String getTitle()
    {
        return this.Title;
    }

    public String getAuthor()
    {
        return this.Author;
    }
}
