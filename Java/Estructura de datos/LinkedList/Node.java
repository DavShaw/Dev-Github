import java.text.MessageFormat;

public class Node
{
    private int value;
    private Node next;

    public Node(int value)
    {
        this.value = value;
        this.next = null;
    }

    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        if (this.next != null)
        {
            return MessageFormat.format("{0} ->", this.value);
        }
        return MessageFormat.format("{0}", this.value);
    }

}