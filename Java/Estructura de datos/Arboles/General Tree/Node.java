import java.util.ArrayList;
import java.util.List;

public class Node
{
    private String value;
    private List<Node> children = new ArrayList<Node>();
    public Node(String value)
    {
        this.value = value;
    }

    public void addChild(Node child)
    {
        this.children.add(child);
    }

    public List<Node> getChildren()
    {
        return this.children;
    }

    public String getValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        return this.value;
    }
}