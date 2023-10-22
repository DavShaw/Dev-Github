public class Program {
    public static void main(String[] args) {
        

        BinaryTree tree = new BinaryTree();
        tree.setRoot("30");
        tree.addLeftAt("30", "20");
        tree.addRightAt("20", "10");
        tree.printTree();
        System.out.println(tree.treeBalanceFactor());

    }
}
