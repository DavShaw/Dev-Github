public class Program {
    public static void main(String[] args) {
        

        BinaryTree tree = new BinaryTree();

        tree.setRoot("10");
        tree.addLeftAt("10", "5");
        tree.addRightAt("5", "7");
        tree.addRightAt("10", "30");
        tree.addRightAt("30", "50");
        tree.addLeftAt("50", "40");
        tree.addLeftAt("40", "36");
        tree.addRightAt("50", "500");
        tree.addRightAt("500", "505");
        tree.addLeftAt("500", "300");
        tree.addRightAt("505", "600");

        System.out.println("Arbolito antes uwu");
        tree.printTree();
        tree.challengeToSubirLaNotica(50);
        System.out.println("Arbolito después");
        tree.printTree();   
        

    }
}
