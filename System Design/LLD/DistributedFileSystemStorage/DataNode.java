import java.util.HashMap;
import java.util.Map;

public class DataNode {
    String nodeId;
    Map<String, byte[]> storageSpace = new HashMap<>();

    DataNode(String nodeId) {
        this.nodeId= nodeId;
    }

    public void storeChunk(Chunk chunk) {
        storageSpace.put(chunk.ChunkId, chunk.data);
    }

    public boolean hasChunk(String chunkId) {
        return storageSpace.containsKey(chunkId);
    }

    public int getFreeSpace() {
        return 1000 - storageSpace.size();
    }
}
