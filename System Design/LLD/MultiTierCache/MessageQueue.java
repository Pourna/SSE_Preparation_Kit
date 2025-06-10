public class MessageQueue <K, V> {
    enum Operation {PUT, DEMOTE, PROMOTE};
    public final K key;
    public final V value;
    public final Operation op;
    public final int targetTier;

    MessageQueue(K key, V value, Operation op, int targetTier) {
        this.key = key;
        this.value = value;
        this.op = op;
        this.targetTier = targetTier;
    }
}

