import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetaDataServer {

    Map<String, FileMetaData> fileMetaDataMap = new HashMap<>();
    Map<String, List<DataNode>> chunkToNodesMap = new HashMap<>();
    List<DataNode> dataNodes;

    MetaDataServer(List<DataNode> dataNodes) {
        this.dataNodes = dataNodes;
    }

    public void registerFile(String filename, List<String> chunkIds, long fileSize) {
        FileMetaData fileMetaData = new FileMetaData(filename, fileSize, chunkIds);
        fileMetaDataMap.put(filename, fileMetaData);
        for (String chunk:chunkIds) {
            chunkToNodesMap.put(chunk, pickNodesForChunk(chunk));
        }
    }

    public FileMetaData getFile(String fileName) {
        return fileMetaDataMap.get(fileName);
    }

    public List<DataNode> getChunkLocation(String chunk) {
        return chunkToNodesMap.get(chunk);
    }

    public List<DataNode> pickNodesForChunk(String chunk) {
        return dataNodes.stream().filter(d->d.getFreeSpace()>0).collect(Collectors.toList());
    }
}
