import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

public class Codec {
	public List<Integer> serialize(TreeNode root) {
		List<Integer> data = new ArrayList<Integer>();
		if (root == null) {
			return data;
		}
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			if (node == null) {
				data.add(null);
			} else {
				data.add(node.val);
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		return data;
	}

	public TreeNode deserialize(List<Integer> data) {
		if (data == null || data.size() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(data.get(0));
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int n = data.size();
		for (int i = 1; i < n; i += 2) {
			TreeNode node = queue.pollFirst();
			Integer left = data.get(i);
			if (left != null) {
				node.left = new TreeNode(left);
				queue.add(node.left);
			}
			Integer right = data.get(i + 1);
			if (right != null) {
				node.right = new TreeNode(right);
				queue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Integer[] data = { 1, 2, 3, null, null, 4, 5, null, null, null, null };
		List<Integer> array = Arrays.asList(data);
		System.out.println(array);

		Codec codec = new Codec();
		System.out.println(codec.serialize(codec.deserialize(array)));
	}
}
