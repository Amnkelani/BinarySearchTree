class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(){
        this.data=0;
        this.left=null;
        this.right=null;
    }

    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

    public int getData(){
        return data;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public void setRight(Node right){
        this.right=right;
    }
}
