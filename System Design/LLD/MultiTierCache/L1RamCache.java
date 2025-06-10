import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class L1RamCache<K, V> implements Cache<K, V> {
    public final int capacity;
    public final Map<K, V> map;
    public final Queue<K> lru;
    public final BlockingQueue<MessageQueue<K, V>> messageQueues;

    L1RamCache(int capacity, BlockingQueue<MessageQueue<K,V>> queue) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.lru = new LinkedList<>();
        this.messageQueues = queue;
    }

    public V get(K key) {
        if(map.containsKey(key)) {
            lru.remove(key);
            lru.add(key);
            return map.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) {
            lru.remove(key);
        } else if(map.size()>=capacity) {
            K evict = lru.poll();
            V evictVal = map.remove(evict);
            messageQueues.offer(new MessageQueue<>(evict, evictVal, MessageQueue.Operation.DEMOTE, 2));
        }
        lru.add(key);
        map.put(key, value);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }
    
    public void evict(K key) {
        lru.remove(key);
        map.remove(key);
    }
}

