class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree(){
        root=null;
        size=0;
    }
    public BinarySearchTree(Node root){
        this.root=root;
        this.size=1;
    }
    public Node getRoot(){
        return root;
    }
    public int getSize(){
        return size;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node node, int data) {
        if (node == null) return false;
        if (data == node.getData()) return true;
        if (data < node.getData())
            return searchRec(node.getLeft(), data);
        else
            return searchRec(node.getRight(), data);
    }

    public void insert(int data) {
        if (search(data)) {
            System.out.println("Input not valid");
            return;
        }
        root = insertRec(root, data);
        size++;
    }

    private Node insertRec(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.getData())
            node.setLeft(insertRec(node.getLeft(), data));
        else
            node.setRight(insertRec(node.getRight(), data));
        return node;
    }

    public int height() {
        return heightRec(root);
    }//Assistance(Google) used to clarify whether 0 or -1 for return value
    private int heightRec(Node node) {
        if (node == null){
            return -1;
        }
        return 1 + Math.max(heightRec(node.getLeft()), heightRec(node.getRight()));
    }

    public void print_in_order() {
        print_in_orderRec(root);
        System.out.println();
    }

    private void print_in_orderRec(Node node) {
        if (node != null) {
            print_in_orderRec(node.getLeft());
            System.out.print(node.getData() + " ");
            print_in_orderRec(node.getRight());
        }
    }

    private int count;

    public int find_kth_smallest(int k) {
        if (k <= 0 || k > size) {
            System.out.println("Input not valid");
            return -1;
        }
        count = 0;
       return kthRec(root, k);
    }

    private int kthRec(Node node, int k) {
        if (node == null) return -1;
        int left = kthRec(node.getLeft(), k);
        if (left != -1) return left;
        count++;
        if (count == k) return node.getData();
        return kthRec(node.getRight(), k);
    }

    public void delete(int data) {
        if (!search(data)) {
            System.out.println("Input not valid");
            return;
        }
        root = deleteRec(root, data);
        size--;
    }
//Made use of Google to understand how delete algorithms work, in order to implement mine
    private Node deleteRec(Node node, int data) {
        if (node == null) return null;
        if (data < node.getData()) {
            node.setLeft(deleteRec(node.getLeft(), data));

        } else if (data > node.getData()) {
            node.setRight(deleteRec(node.getRight(), data));

        } else {
            if (node.getLeft() == null && node.getRight() == null)
                return null;

            if (node.getLeft() == null)
                return node.getRight();

            if (node.getRight() == null)
                return node.getLeft();

            int maxLeft = findMax(node.getLeft());
            node.setData(maxLeft);
            node.setLeft(deleteRec(node.getLeft(), maxLeft));
        }
        return node;
    }
    private int findMax(Node node) {
        while (node.getRight() != null)
            node = node.getRight();

        return node.getData();
    }
}






