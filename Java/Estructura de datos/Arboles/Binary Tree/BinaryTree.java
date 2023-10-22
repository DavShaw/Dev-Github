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

    private short height(BinaryNode root, short total) {
        if(root != null) {
            if(root.getRightChild() == null && root.getLeftChild() == null) {
                return (short) (total + 1);
            }
            short left_height = this.height(root.getLeftChild(), (short) (total + 1));
            short right_height = this.height(root.getRightChild(), (short) (total + 1));
            
            if (left_height == right_height) {
                return left_height;
            }
            else if (left_height > right_height) {
                return left_height;
            }
            else {
                return right_height;
            }
        }
        return total;
    }

    public short nodeHeight(String nodeValue) {
        BinaryNode node = this.getNode(nodeValue);
        return height(node, (short) 0);
    }

    public short treeHeight() {
        return height(this.getRoot(), (short) 0);
    }

    public short treeBalanceFactor() {
        return balanceFactor(this.getRoot());
    }

    public short balanceFactor(String value) {
        BinaryNode node = this.getNode(value);
        return balanceFactor(node);
    }

    private short balanceFactor(BinaryNode node) {

        if (node == null) {
            return 0;
        }

        short heightLeft = height(node.getLeftChild(), (short) 0);
        short heightRight = height(node.getRightChild(), (short) 0);
    
        return (short) (heightRight - heightLeft);
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
