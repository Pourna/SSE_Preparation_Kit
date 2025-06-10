import java.util.List;

public class FileMetaData {
    String FileName;
    long FileSize;
    List<String> chunkIds;
    FileMetaData(String fileName, long fileSize, List<String> chunkIds) {
        this.FileName = fileName;
        this.FileSize = fileSize;
        this.chunkIds = chunkIds;
    }
}
