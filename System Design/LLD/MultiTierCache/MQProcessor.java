import java.util.concurrent.BlockingQueue;

public class MQProcessor<K, V> implements Runnable {
    BlockingQueue<MessageQueue<K, V>> queue;
    SDDCache<K, V> sddCache;
    HDDCache<K, V> hddCache;

    MQProcessor(BlockingQueue<MessageQueue<K,V>> queue, SDDCache<K, V> sddCache, HDDCache<K,V> hddCache) {
        this.queue = queue;
        this.sddCache = sddCache;
        this.hddCache = hddCache;
    }

    public void run(){
        while(true) {
            try {
                MessageQueue<K, V> msg = queue.take();
                if(msg.op== MessageQueue.Operation.DEMOTE) {
                    if(msg.targetTier==2) {
                        sddCache.put(msg.key, msg.value);
                        System.out.println(msg.key+" : "+msg.value+" Demoted to SDD Cache");
                    } else if(msg.targetTier==3) {
                        hddCache.put(msg.key, msg.value);
                        System.out.println(msg.key+" : "+msg.value+" Demoted to HDD Cache");
                    }
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

