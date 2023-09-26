import java.util.List;
import java.util.ArrayList;

public class Rebuscado
{
    BinaryTree tree = new BinaryTree();

    public List<BinaryNode> Challenge()
    {
        List<BinaryNode> allNodes = new ArrayList<>();
        List<BinaryNode> allNodes2 = new ArrayList<>();
        if (this.tree.getRoot() != null)
        {
            allNodes.add(this.tree.getRoot());
            while (!allNodes.isEmpty())
            {
                BinaryNode current = allNodes.remove(0);

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

                if (current != null)
                {
                    //Obteniendo sus hijos
                    BinaryNode right = current.getRightChild();
                    BinaryNode left = current.getLeftChild();

                    if((left != null) && (right != null))
                    {
                        if((left.getValueAsInt() + right.getValueAsInt()) == current.getValueAsInt())
                        {
                            allNodes2.add(current);
                        }
                    }

                }
            }
        }
        return allNodes2;
    }
}
