package mycollections.list;

import java.util.LinkedList;

/**
 * @Auther: Kam
 * @Date: 下午 2:13 2018-10-21
 * @Description: 自己实现Linkedlist
 * @Version: 1.0
 */
public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
    }

    private int size;

    public E get(int index) throws Exception {
        return node(index).data;
    }

    public boolean add(E e){
        linkedLast(e);
        return true;
    }
    public void addLast(E e){
        linkedLast(e);
    }
    public void addFirst(E e) {
        linkedFirst(e);
    }

    public E getFirst() throws Exception {
        Node<E> f = first;
        if(f==null){
            throw new Exception("没有元素");
        }
        return f.data;
    }

    public E getLast() throws Exception {
        Node<E> l = last;
        if(l==null){
            throw new Exception("没有元素");
        }
        return l.data;
    }

    //连接至第一个元素
    private void linkedFirst(E e){
        Node<E> firstNode = first;
        Node<E> newNode = new Node<E>(null,e,firstNode);
        first = newNode;

        if(firstNode==null) {
            firstNode = newNode;
        } else {
            firstNode.privious = newNode;
        }
            size++;
    }
    //连接至最后的元素
    private void linkedLast(E e) {
        Node<E> lastNode = last;
        //生成新的节点
        Node<E> newNode = new Node<E>(lastNode,e,null);
        //新的赋值给last节点作为last
        last = newNode;
        if(lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
            size++;
    }


    public int size() {
        return size;
    }

    E unlink(Node<E> x){
        //解除对象节点的连接
        E element = x.data;
        Node<E> next = x.next;
        Node<E> privious = x.privious;
        if(privious == null){
            first = next;
        } else {
            privious.next = next;
            x.privious=null;
        }

        if(next==null){
            last = privious;
        } else {
            next.privious = privious;
            x.next = null;
        }
        x.data = null;
        size--;
        return element;
    }

    public boolean remove(Object obj){
        if(obj==null){
            //遍历节点，找到节点的data为null的节点
            for(Node<E> n = first;n!=null;n = n.next ) {
                if(n.data==null){
                    unlink(n);
                    return true;
                }
            }
        } else {
            for (Node<E> n = first;n!=null;n = n.next){
                if(obj.equals(n.data)){
                    unlink(n);
                    return true;
                }
            }
        }
        return false;
    }

    void checkIndex(int index) throws Exception {
        if(index>size&&index<0){
            throw new Exception("下标错误");
        }
    }

    Node<E> node(int index) throws Exception {
        checkIndex(index);
        //为了提高效率，这里采用二分法
        //注意这里的括号，先进行除以2（即移位1），在进行比较
        if (index < (size >> 1)) {
            //说明在前边，则从前到后进行遍历
            Node<E> n = first;
            for (int i = 0; i < index; i++)
                //下一个即是元素
                n = n.next;
                return n;
        } else {
            //反之在后边，从后边向前边遍历
            Node<E> n = last;
            for (int i = size - 1; i > index; i--)
                //上一个即是元素
                n = n.privious;
                return n;
        }
    }

}

class Node<E> {
    Node<E> privious;
    E data;
    Node<E> next;

    public Node(Node<E> privious, E data, Node<E> next) {
        this.privious = privious;
        this.data = data;
        this.next = next;
    }
}