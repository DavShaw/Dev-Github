import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree
{
    private BinaryNode root;

    public void addRightAt(String father, String value)
    {
        try
        {
            BinaryNode node = this.getNode(father);
            node.setRightChild(new BinaryNode(value));
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addLeftAt(String father, String value)
    {
        try
        {
            BinaryNode node = this.getNode(father);
            node.setLeftChild(new BinaryNode(value));
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setRoot(String value)
    {
        if ((root == null))
        {
            this.root = new BinaryNode(value);
        }
        else
        {
            throw new IllegalArgumentException("Tree already has a root");
        }
    }


    public void genereteTest()
    {
        this.root = new BinaryNode("A");
        //Añadir 2 hijos a A (B C)
        this.root.setRightChild(new BinaryNode("B"));
        this.root.setLeftChild(new BinaryNode("C"));
    }

    public BinaryNode getNode(String value)
    {
        if (this.root == null)
        {
            return null;
        }
    
        List<BinaryNode> allNodes = new ArrayList<>(Arrays.asList(this.root));
    
        while (!allNodes.isEmpty())
        {
            BinaryNode current = allNodes.remove(0);
    
            // Verificar si el nodo actual es null
            if (current == null)
            {
                continue;
            }
    
            if (current.getValue().equals(value))
            {
                return current;
            }
    
            allNodes.add(current.getRightChild());
            allNodes.add(current.getLeftChild());
        }
    
        return null;
    }
    
    public BinaryNode getRoot()
    {
        return this.root;
    }
    

    public void showNodes()
    {
        if (this.root != null)
        {
            List<BinaryNode> allNodes = new ArrayList<>();
            allNodes.add(this.root);
    
            while (!allNodes.isEmpty())
            {
                BinaryNode current = allNodes.remove(0);
                System.out.println(current);
    
                if (current != null)
                {
                    if (current.getRightChild() != null)
                    {
                        allNodes.add(current.getRightChild());
                    }

                    if (current.getLeftChild() != null)
                    {
                        allNodes.add(current.getLeftChild());
                    }
                }
            }
        }
    }

    public void travers()
    {
        if (this.root != null) {
            traversePreOrder(this.root, "");
        }
    }

    private void traversePreOrder(BinaryNode node, String indent) {
        if (node != null) {
            System.out.println(indent + "|-- " + node.getValue());
            traversePreOrder(node.getLeftChild(), indent + "    |");
            traversePreOrder(node.getRightChild(), indent + "    |");
        } else {
            System.out.println(indent + "|-- X");
        }
    }






    public void printTree() {
        if (this.root != null) {
            printTree(this.root, "");
        }
    }
    
    private void printTree(BinaryNode node, String indent) {
        if (node != null) {
            System.out.println(indent + "|- " + node.getValue());
            if (node.getLeftChild() != null || node.getRightChild() != null) {
                printTree(node.getLeftChild(), indent + "   ");
                printTree(node.getRightChild(), indent + "   ");
            }
        }
    }
    

    
}
