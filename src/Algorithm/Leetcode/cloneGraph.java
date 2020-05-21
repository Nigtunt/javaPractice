package Algorithm.Leetcode;

import java.util.*;

/**
 * @Author: YHQ
 * @Date: 2019/12/7 15:26
 */
public class cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node CLONE(Node node){
        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node head = new Node(node.val,new ArrayList<>());
        map.put(node.val,head);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            Node nd = null;
            if (!map.containsKey(n.val)){
                nd = new Node(n.val,new ArrayList<Node>());
                map.put(n.val,nd);
            }else nd=map.get(n.val);

            for (Node N:n.neighbors){
                if (!map.containsKey(N.val)){
                    queue.offer(N);
                    Node newNode = new Node(N.val,new ArrayList<Node>());
                    nd.neighbors.add(newNode);
                    map.put(N.val,newNode);
                }else
                    nd.neighbors.add(map.get(N.val));
            }
        }
        return head;
    }
    public Node CloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGrapthHelper(node, map);
    }

    private Node cloneGrapthHelper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        //生成当前节点
        Node n = new Node();
        n.val = node.val;
        n.neighbors = new ArrayList<Node>();
        map.put(node.val, n);
        //添加它的所有邻居节点
        for (Node temp : node.neighbors) {
            n.neighbors.add(cloneGrapthHelper(temp, map));
        }
        return n;
    }

}
