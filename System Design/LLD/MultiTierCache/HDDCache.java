import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HDDCache<K, V> implements Cache<K, V> {
    Map<K, V> hddCache = new ConcurrentHashMap<>();

    public V get(K key) {
        return hddCache.get(key);
    }
    
    public void put(K key, V val) {
        hddCache.put(key, val);
    }
    
    public boolean containsKey(K key) {
        return hddCache.containsKey(key);
    }
    
    public void evict(K key) {
        hddCache.remove(key);
    }
}

