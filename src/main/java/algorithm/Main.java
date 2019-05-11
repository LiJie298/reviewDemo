package algorithm;

public class Main {

    /**
     * 单链表翻转
     */

    class Node {
        char value;
        Node next;
    }


    public Node reverse1(Node current) {
        //initialization
        Node previousNode = null;
        Node nextNode = null;

        while (current != null) {
            //save the next node
            nextNode = current.next;
            //update the value of "next"
            current.next = previousNode;
            //shift the pointers
            previousNode = current;
            current = nextNode;
        }
        return previousNode;
    }


    public Node reverse2(Node current) {
        if (current == null || current.next == null) return current;
        Node nextNode = current.next;
        current.next = null;
        Node reverseRest = reverse2(nextNode);
        nextNode.next = current;
        return reverseRest;
    }


    static class NodeDemo {
        private Object key;
        private NodeDemo nextNode;

        public NodeDemo(Object key, NodeDemo nextNode) {
            this.key = key;
            this.nextNode = nextNode;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public NodeDemo getNextNode() {
            return nextNode;
        }

        public void setNextNode(NodeDemo nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }


    public static void re(NodeDemo demo) {
        NodeDemo temp = demo.nextNode;
        while (temp != null) {
            NodeDemo a = temp.nextNode;
            temp.nextNode = demo;
            temp = a.nextNode;
        }
    }

    public static void main(String[] args) {
        NodeDemo demo5 = new NodeDemo("5", null);
        NodeDemo demo1 = new NodeDemo("4", demo5);
        NodeDemo demo2 = new NodeDemo("3", demo1);
        NodeDemo demo3 = new NodeDemo("2", demo2);
        NodeDemo demo4 = new NodeDemo("1", demo3);
        re(demo4);
        System.out.println(demo5.toString());
    }


}
