import java.util.List;

public class Chunk {
    String ChunkId;
    byte[] data;

    Chunk(String chunkId, byte[] data) {
        this.ChunkId = chunkId;
        this.data = data;
    }
}

