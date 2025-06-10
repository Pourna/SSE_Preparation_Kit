import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MultiTierCacheDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<MessageQueue<String, String>> messageQueues = new LinkedBlockingQueue<>();

        L1RamCache<String, String> l1RamCache = new L1RamCache<>(2, messageQueues);
        SDDCache<String, String> sddCache = new SDDCache<>(2, messageQueues);
        HDDCache<String, String> hddCache = new HDDCache<>();

        l1RamCache.put("A","Apple");
        l1RamCache.put("B", "Banana");
        l1RamCache.put("C", "Cherry");
        l1RamCache.put("D", "Date");

        Thread.sleep(1000);
        l1RamCache.put("E", "Elderberry");
        Thread.sleep(1000);

        String key = "A";
        String value = l1RamCache.get(key);
        if(value==null) {
            value = sddCache.get(key);
            if(value!=null) {
                l1RamCache.put(key, value);
                System.out.println("Promoting to L1 from L2 Key: "+ key);
            } else {
                value = hddCache.get(key);
                if(value!=null){
                    l1RamCache.put(key, value);
                    System.out.println("Promoting to L1 from L3 Key: "+ key);
                }
            }
        }

        System.out.println("Final L1 contains A? " + l1RamCache.containsKey("A"));
        System.out.println("Final L2 contains A? " + sddCache.containsKey("A"));
        System.out.println("Final L3 contains A? " + hddCache.containsKey("A"));
     }
}
