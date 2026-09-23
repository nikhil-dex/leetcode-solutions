
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    int index = 0;
    public String serialize(TreeNode root) {
       sb.setLength(0);
       preOrder(root);
       return sb.toString();
        
        
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index=0;
        String[] array = data.split(",");
        return build(array);


        
    }
public TreeNode build(String[] array){
    if(index==array.length) return null;
    if(array[index].equals("null")){
        index++;
         return null;
    } 
    int val = Integer.parseInt(array[index]);
    index++;
    
    TreeNode root = new TreeNode(val);
    root.left = build(array);
    root.right = build(array);
    return root;


}

public void preOrder(TreeNode root){
    if(root!=null){
        sb.append(Integer.toString(root.val)+",");
        preOrder(root.left);
        preOrder(root.right);
    }else{
        sb.append("null,");
        return;
    }
}
}



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));