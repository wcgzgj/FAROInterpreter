package top.faroz.domain;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/20 下午3:49
 * @Version 1.0
 **/
public class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String val) {
        this.val = val;
        left=null;
        right=null;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val+" ";
    }
}
