import java.io.ByteArrayOutputStream;
import java.util.*;

public class Client {
    MetaDataServer metaDataServer;
    Map<String, DataNode> dataNodes;

    Client(MetaDataServer metaDataServer, Map<String, DataNode> dataNodes) {
        this.metaDataServer = metaDataServer;
        this.dataNodes = dataNodes;
    }

    public void uploadFile(String fileName, byte[] data) {
        List<String> chunkIds = new ArrayList<>();
        int chunkSize = 1000;
        for(int i=0; i<data.length; i+=chunkSize) {
            int end = Math.min(data.length, i+chunkSize);
            byte[] chunkData = Arrays.copyOfRange(data, i, end);
            String chunkId = UUID.randomUUID().toString();
            chunkIds.add(chunkId);

            Chunk chunk = new Chunk(chunkId, chunkData);
            List<DataNode> targetNodes = metaDataServer.pickNodesForChunk(chunkId);

            for(DataNode node : targetNodes) {
                dataNodes.get(node.nodeId).storeChunk(chunk);
            }
        }
        metaDataServer.registerFile(fileName, chunkIds, fileName.length());
    }

    public byte[] downloadFile(String fileName) {
        FileMetaData metaData = metaDataServer.getFile(fileName);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        for(String chunkId : metaData.chunkIds) {
            for(DataNode nodeId : metaDataServer.getChunkLocation(chunkId)) {
                if(nodeId.hasChunk(chunkId)) {
                    output.writeBytes(nodeId.storageSpace.get(chunkId));
                }
            }
        }
        return output.toByteArray();
    }
}
