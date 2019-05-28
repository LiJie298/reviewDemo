package algorithm;

public class MyLinkedList {
    private Node head = null;
    private static int size = 0;

    static class Node<T extends Number> implements Comparable {
        private T value;
        Node next = null;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Node a = (Node) o;
            return this.value.intValue() - a.value.intValue();
        }
    }

    /**
     * 添加一个新节点
     *
     * @param node
     */
    public void addNode(Node node) {
        if (head != null) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        } else {
            head = node;
        }
        ++size;
    }

    /**
     * 删除最后一个节点
     */
    public void delNode() {
        if (head == null) {
            return;
        } else {
            Node preNode = head;
            Node currentNode = preNode.next;
            while (currentNode.next != null) {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            preNode.next = null;
            --size;
        }
    }

    /**
     * 删除指定节点
     *
     * @param index
     * @return
     */

    public boolean delNode(int index) {
        if (index > size) {
            return false;
        } else {
            --size;
            if (index == 1) {

                head = head.next;
                return true;
            }
            Node preNode = head;
            Node currentNode = preNode.next;
            int i = 2;
            while (currentNode != null) {
                if (index == i) {
                    preNode.next = currentNode.next;
                    return true;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }
            return false;
        }
    }


    /**
     * 获取单向链表的长度
     *
     * @return
     */
    public int length() {
        int i = 0;
        if (head == null) {
            i = 0;
        } else {
            Node d = head;
            while (d != null) {
                i++;
                d = d.next;
            }
        }
        return i;
    }

    /**
     * 对链表进行排序，返回拍完序的头节点
     * 从大到小 降序
     *
     * @return
     */
    public Node orderList() {
        Node nextNode = null;
        Node currentNode = head;
        Number temp = null;
        while (currentNode.next != null) {
            nextNode = currentNode.next;
            while (nextNode != null) {
                if (nextNode.compareTo(currentNode) > 0) {
                    temp = currentNode.value;
                    currentNode.value = nextNode.value;
                    nextNode.value = temp;
                }
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public void printLink() {
        System.out.println(length() + "----  link -----" + size);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 查找单向列表倒数第k个位置的数
     *
     * @param k
     * @return
     */
    public Node findNode(int k) {
        if (k < 0) {
            return null;
        } else {
            Node before = head;
            Node after = head;
            int i = 0;
            for (; i < k && after != null; i++) {
                after = after.next;
            }
            if (i < k && after == null) {
                System.out.println(k + " -- not ");
            }
            while (after != null) {
                before = before.next;
                after = after.next;
            }
            return before;
        }
    }

    /**
     * 递归的思想 从尾到头 输出链表
     *
     * @param node
     */
    public void printListReversely(Node node) {
        if (node != null) {
            printListReversely(node.next);
            System.out.print(node.value + " -> ");
        }
    }


    /**
     * 查找单向链表的中间节点
     * 快的速度是慢的的速度的2倍
     */
    public void printMiddleNodeValue() {
        Node slowNode = head;
        Node fastNode = head;
        while (slowNode.next != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        System.out.println(slowNode.value);
    }

    public Node fanzhuan() {
        if (null == head || null == head.next)
            return head;
        Node pre = head;
        Node cur = head.next;
        while (null != cur.next) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        Node head = new Node<>(15);
        linkedList.addNode(head);
        linkedList.addNode(new Node<>(12));
        linkedList.addNode(new Node<>(9));
        linkedList.addNode(new Node<>(45));
        linkedList.addNode(new Node<>(10));
        linkedList.addNode(new Node<>(235));
        linkedList.addNode(new Node<>(5));
        linkedList.addNode(new Node<>(65));
        linkedList.addNode(new Node<>(101));
        linkedList.addNode(new Node<>(25));
        linkedList.addNode(new Node<>(51));
        linkedList.addNode(new Node<>(625));
        linkedList.printLink();
//        System.out.println("del node");
//        linkedList.delNode();
//        linkedList.printLink();


        System.out.println("del node  3");
        linkedList.delNode(3);
        linkedList.printLink();


//        System.out.println("order link");
//        linkedList.orderList();
//        linkedList.printLink();

        System.out.println("find node");
//        for (int i = 0; i < linkedList.length(); i++) {
//            Node node = linkedList.findNode(i);
//            System.out.println(node == null ? "xxx" : node.value);
//        }

        linkedList.printListReversely(head);


        linkedList.printMiddleNodeValue();

        linkedList.fanzhuan();
        linkedList.printLink();
    }

}
