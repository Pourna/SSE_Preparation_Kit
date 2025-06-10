import java.util.Map;

public class DFSDemo {
    public static void main(String[] args) {
        Map<String, DataNode> nodes = Map.of(
                "Node1", new DataNode("Node1"),
                "Node2", new DataNode("Node2"),
                "Node3", new DataNode("Node3"));
        MetaDataServer metaDataServer = new MetaDataServer(nodes.values().stream().toList());

        byte[] fileData = "Hello this is a large distributed file  ".getBytes();
        Client client = new Client(metaDataServer, nodes);
        client.uploadFile("file.txt", fileData);
        byte[] downloaded = client.downloadFile("file.txt");
        System.out.println(new String(downloaded)); // should print original string
    }
}
