import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class SDDCache<K, V> implements Cache<K, V> {
    public final int capacity;
    public final Map<K, V> map;
    public final Queue<K> sddCache;
    public final BlockingQueue<MessageQueue<K,V>> messageQueues;

    SDDCache(int capacity, BlockingQueue<MessageQueue<K,V>> messageQueues) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.sddCache = new LinkedList<>();
        this.messageQueues = messageQueues;
    }

    public void evict(K key) {
        sddCache.remove(key);
        map.remove(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V val) {
        if(map.containsKey(key) && sddCache.size()>=capacity) {
            K evict = sddCache.poll();
            V evictVal = map.remove(evict);
            messageQueues.offer(new MessageQueue<>(evict, evictVal, MessageQueue.Operation.DEMOTE, 3));
        }
        map.put(key, val);
        sddCache.add(key);
    }
}

