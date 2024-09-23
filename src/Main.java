public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();

        try {
            tree.printTree();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(2);
        tree.insert(7);
        tree.insert(15);
        tree.insert(25);

        System.out.println("Árvore antes da remoção:");
        tree.printTree();

        tree.remove(20);
        System.out.println("\nÁrvore após remover 20:");
        tree.printTree();

        tree.remove(5);
        System.out.println("\nÁrvore após remover 5:");
        tree.printTree();

        tree.remove(10);
        System.out.println("\nÁrvore após remover 10:");
        tree.printTree();

        tree.insert(2); 
        System.out.println("\nÁrvore após adcionar 2:");
        tree.printTree();

        tree.insert(2); 
        System.out.println("\nÁrvore após adcionar 2:");
        tree.printTree();

        tree.insert(3); 
        System.out.println("\nÁrvore após adcionar 3:");
        tree.printTree();

        tree.remove(2); 
        System.out.println("\nÁrvore após remover 2:");
        tree.printTree();
    }
}
