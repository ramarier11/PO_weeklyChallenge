package convertarraytobst;


// Logical Reasoning Question

/*
 * 	A watch, which loses time uniformly, was observed to be 5 minutes fast at 8.00 p.m. on Thursday.
 *  It was noticed to be 7 minutes slow at 8.00 a.m. on the subsequent Monday. 
 *  When did the watch show the correct time ?
 * 
 * There are 84 hours separating 8pm Thursday and 8am Monday
 * There are 12 minutes between 5 minutes fast and 7 minutes slow
 * 84 / 12 => the watch is slowing down at a rate of 1 minutes per 7 hours
 * Because we are trying to find the time at which the watch displayed the correct time we do
 * 7 * 5 = 35 because the watch was initially 5 minutes fast.
 * If you add 35 hours to the time of 8pm on Thursday you get 7am on Saturday.
 * 
 *  Answer -> A 7am Saturday 
 * 
 */
class Node {
    
    int data;
    Node left, right;
     
    Node(int d) {
        data = d;
        left = right = null;
    }
}
 
class BinaryTree {
     
    static Node root;
    Node sortedArrayToBST(int arr[], int left, int right) {
 
        if (left > right) {
            return null;
        }
        
        /* Get the middle element */
        int middle = left + (right - left) / 2;
        Node node = new Node(arr[middle]);
        
        node.left = sortedArrayToBST(arr, left, middle - 1);

        node.right = sortedArrayToBST(arr, middle + 1, right);
         
        return node;
    }
 
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
     
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);
        tree.preOrder(root);
       
    }
}