import java.util.List;

public class App {
    public static void main(String[] args)
    {
        Rebuscado RebuscadoTree = new Rebuscado();
        BinaryTree tree = RebuscadoTree.tree;

        //Añadir valores al tree
        tree.setRoot("1");

        tree.addLeftAt("1", "2");
            tree.addLeftAt("2", "0");
            tree.addRightAt("2", "2");

        tree.addRightAt("1", "3");
            tree.addLeftAt("3", "0");
            tree.addRightAt("3", "3");

        tree.addLeftAt("0", "8");
            tree.addLeftAt("8", "3");
            tree.addRightAt("8", "52");

        tree.addRightAt("8", "9");
            tree.addLeftAt("9", "6");
            tree.addRightAt("9", "3");

        tree.printTree();

        //Obtener nodos talque la suma de sus hijos = nodo
        List<BinaryNode> nodos = RebuscadoTree.Challenge();
        System.out.println(nodos);

        
    }
    
}
