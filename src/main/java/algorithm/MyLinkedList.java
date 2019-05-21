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
            while (d!= null) {
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


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addNode(new Node<>(15));
        linkedList.addNode(new Node<>(12));
        linkedList.addNode(new Node<>(9));
        linkedList.addNode(new Node<>(45));
        linkedList.addNode(new Node<>(10));
        linkedList.addNode(new Node<>(235));
        linkedList.addNode(new Node<>(5));
        linkedList.addNode(new Node<>(65));
        linkedList.printLink();
//        System.out.println("del node");
//        linkedList.delNode();
//        linkedList.printLink();


        System.out.println("del node  3");
        linkedList.delNode(3);
        linkedList.printLink();


        System.out.println("order link");
        linkedList.orderList();
        linkedList.printLink();


    }

}
