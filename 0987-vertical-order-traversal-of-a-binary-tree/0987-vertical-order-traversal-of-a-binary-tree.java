
class Solution {
    // Nested static class Tuple
    static class Tuple {
        TreeNode node;
        int x; // Vertical distance
        int y; // Level

        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
  
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

        // Queue for BFS traversal (stores node along with its x and y coordinates)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // (node, x, y)

        // Perform BFS
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Add the node's value to the map at the correct x and y
            nodesMap.putIfAbsent(x, new TreeMap<>());
            nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.val);

            // Add the left child with updated coordinates to the queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Add the right child with updated coordinates to the queue
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the result by sorting keys and compiling nodes
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : nodesMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        return result;
    }
}

