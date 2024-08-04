package easy;

public class ConstructtStringFromBinaryTree {

	public String tree2str(TreeNode root) {

		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		dfs(root, sb);
		return sb.toString();
	}

	private void dfs(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.append(String.valueOf(root.val));
		if (root.left == null && root.right == null) {
			return;
		}

		sb.append("(");
		dfs(root.left, sb);
		sb.append(")");
		if (root.right != null) {
			sb.append("(");
			dfs(root.right, sb);
			sb.append(")");
		}
	}

}
