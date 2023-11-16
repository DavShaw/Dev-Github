import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private List<BinaryNode> getNodesAtLevel(int level, int counter, List<BinaryNode> nodes, BinaryNode current) {
        
        if (current == null) {
            
            return nodes;
        }
    
        if (counter == level) {

            nodes.add(current);
        }
        
        else {

            this.getNodesAtLevel(level, counter + 1, nodes, current.getLeftChild());
            this.getNodesAtLevel(level, counter + 1, nodes, current.getRightChild());
        }

        return nodes;
    }
    
    //Delete after challenge
    private BinaryNode getItsFather(BinaryNode root, String childValue) {

        if (root != null) {

            if (root.getLeftChild() != null) {
    
                if (root.getLeftChild().getValue().equals(childValue)) {
                    return root;
                }
            }
    
            if (root.getRightChild() != null) {
    
                if (root.getRightChild().getValue().equals(childValue)) {
                return root;
                }
            }

            BinaryNode f1 = this.getItsFather(root.getLeftChild(), childValue);
            BinaryNode f2 = this.getItsFather(root.getRightChild(), childValue);

            if (f1 != null) {
                return f1;
            }

            if (f2 != null) {
                return f2;
            }

        }

        return null;

    }

    //Delete after challenge
    public BinaryNode getItsFather(String chidleValue) {
        return this.getItsFather(this.root, chidleValue);
    }

    //Delete after challenge
    private List<BinaryNode> getLeavesNodes(BinaryNode root, List<BinaryNode> leaves) {

        if (root != null) {

            if (root.getLeftChild() != null) {
                if (root.getLeftChild().getLeftChild() == null
                    &&
                    root.getLeftChild().getRightChild() == null) {
                        // Only add if its parentless
                        if (true) {
                            leaves.add(root.getLeftChild());
                        }
                } else {
                    leaves.addAll(this.getLeavesNodes(root.getLeftChild(), leaves));
                }
            }
        
            if (root.getRightChild() != null) {
        
                if (root.getRightChild().getLeftChild() == null
                    &&
                    root.getRightChild().getRightChild() == null) {
                        // Only add if its parentless
                        if (true) {
                            leaves.add(root.getRightChild());
                        }
                } else {
                    leaves.addAll(this.getLeavesNodes(root.getRightChild(), leaves));
                }
            }
        }

        Set<BinaryNode> temporal = leaves.stream().collect(Collectors.toSet());
        leaves.clear();
        List<BinaryNode> temporal2 = temporal.stream().collect(Collectors.toList());
        leaves.clear();
        leaves.addAll(temporal2);
        return leaves;
        // No se ponga triste profundamente
    }

    //Delete after challenge 
    public List<BinaryNode> clearParentless(List<BinaryNode> nodeList) {
        List<BinaryNode> nodesToRemove = new ArrayList<>();
    
        for (BinaryNode node : nodeList) {
            if (isParentless(node.getValue())) {
                nodesToRemove.add(node);
            }
        }
        nodeList.removeAll(nodesToRemove);
        return nodeList;    
    }
    
    //Delete after challenge
    public List<BinaryNode> getLeavesNodes() {

        return this.getLeavesNodes(this.root, new ArrayList<>());
    }

    //Delete after challenge
    public void deleteLeaveFrom(String father, String child) {
        BinaryNode theFather = this.getNode(father);
        if (theFather.getRightChild().getValue() == child) {
            theFather.setRightChild(null);
        }

        else if (theFather.getLeftChild().getValue() == child) {
            theFather.setLeftChild(null);
        }
    }

    //Delete after challenge 
    public boolean isParentless(String child) {
        BinaryNode theFather = getItsFather(child);
    
        if (theFather == null) {
            return false;
        }
        BinaryNode leftChild = theFather.getLeftChild();
        BinaryNode rightChild = theFather.getRightChild();
    
        if ((leftChild != null && leftChild.getValue().equals(child) && rightChild == null) ||
            (rightChild != null && rightChild.getValue().equals(child) && leftChild == null)) {
            return true;
        }
    
        return false;
    }
    
    // THE CHALLENGE!!!!
    public void challengeToSubirLaNotica(Integer v) {
        List<BinaryNode> toShow = new ArrayList<>();

        // Primero, obtener lista de nodos hojas
        List<BinaryNode> leavesNodes = this.getLeavesNodes();
        leavesNodes = this.clearParentless(leavesNodes);

        // Segundo, iterar en cada uno de ellos
        for (BinaryNode node : leavesNodes) {

            // Tercero, si su valor es mayor o igual a v, entonces se continua
            Integer value = Integer.valueOf(node.getValue());
            if (value >= v) {
                // Cuarto, si es así, obtengamos su padre
                BinaryNode itsFather = this.getItsFather(node.getValue());
                
                // Quinto, borrar el nodo
                this.deleteLeaveFrom(itsFather.getValue(), node.getValue());
                toShow.add(node);
            }

        }

        // Mostrar nodos borrados 
        System.out.println(toShow);
    }

    //Delete after challenge
    public List<BinaryNode> getNodesAtLevel(int level) {
        return this.getNodesAtLevel(level, 0, new ArrayList<BinaryNode>(), this.getRoot());
    }

    // Delete after challenge
    public List<String> getNodeValuesFromList(List<BinaryNode> nodes) {

        List<String> values = new ArrayList<String>();

        for (BinaryNode node : nodes) {
            if (node.getValue() != null) {
                values.add(node.getValue());
            }
        }
        return values;
    }

    // Delete after challenge
    public Boolean reto(int nivel) {
        List<String> values = this.getNodeValuesFromList(this.getNodesAtLevel(nivel));
        return Help.listaConRepetidos(values);
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
