// import java.util.ArrayList;
// import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree {

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }

        // public List<Node> getChildren() {
        //     List<Node> children = new ArrayList<>();
        //     if (left != null) children.add(left);
        //     if (right != null) children.add(right);
        //     return children;
        // }

        public DoublyLinkedList<Node> getChildren() {
            DoublyLinkedList<Node> children = new DoublyLinkedList<>();
            if (left != null) children.add(left);
            if (right != null) children.add(right);
            return children;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if (right != null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
            if (left != null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        @Override
        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }

    Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {  //valores duplicados na direita
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    //remove um nó da arvore
    void remove(int value) {
        root = removeRec(root, value);
    }

    Node removeRec(Node root, int value) {
        if (root == null) {
            return root;
        }
        //busca o nó q vai ser removido
        if (value < root.value) {
            root.left = removeRec(root.left, value);
        } else if (value > root.value) {
            root.right = removeRec(root.right, value);
        } else {
            //0 ou 1 filho
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //2 filhos -> substituir pelo sucessor
            root.value = minValue(root.right);
            root.right = removeRec(root.right, root.value);
        }

        return root;
    }

    //metodo auxiliar para encontrar o valor minino da arvore
    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }

    //metodo que printa a arvore (horizontalmente REF -> https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java)
    public void printTree() {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty.");
        } else {
            System.out.print(root);
        }
    }
}
