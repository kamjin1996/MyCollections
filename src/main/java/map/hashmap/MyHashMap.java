package map.hashmap;

import java.util.HashMap;

/**
 * @Auther: Kam
 * @Date: 下午 2:12 2018-10-21
 * @Description: 自己实现HashMap
 * @Version: 1.0
 */
public class MyHashMap {
    //底层数组加链表，而链表采用刚刚的MyLinkedList,或者jdk自带的都行，主要实现HashMap的基本操作
    //定义初始大小
    private static final int DEFUALT_INITCAP = 16;



}

//MyEntry
class MyEntry<K,V>{
    K key;
    V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}