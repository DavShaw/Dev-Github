import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree
{
    private Node root = null;
    private boolean hasRoot = false;

    public void addAt(String father, String value)
    {
        try
        {
            Node node = this.getNode(father);
            node.addChild(new Node(value));
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setRoot(String value)
    {
        if (!hasRoot)
        {
            this.root = new Node(value);
            this.hasRoot = true;
        }
        else
        {
            throw new IllegalArgumentException("Tree already has a root");
        }
    }


    public void genereteTest()
    {
        this.root = new Node("A");
        //Añadir 3 hijos a A (B C P)
        this.root.addChild(new Node("B"));
        this.root.addChild(new Node("C"));
        this.root.addChild(new Node("P"));
    }

    public Node getNode(String value)
    {
        List<Node> allNodes = new ArrayList<>(Arrays.asList(this.root));
    
        while (!allNodes.isEmpty())
        {
            Node current = allNodes.remove(0);
    
            if (current.getValue().equalsIgnoreCase(value))
            {
                return current;
            }
    
            allNodes.addAll(current.getChildren());
        }

        return null;
    }
    

    public void traverse()
    {
        if (this.hasRoot)
        {
            List<Node> allNodes = new ArrayList<>();
            allNodes.add(this.root);
    
            while (!allNodes.isEmpty())
            {
                Node current = allNodes.remove(0);
                System.out.println(current);
                allNodes.addAll(current.getChildren());
            }
        }
    }
}
