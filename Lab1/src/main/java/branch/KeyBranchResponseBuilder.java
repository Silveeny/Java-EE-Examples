package branch;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;

public class KeyBranchResponseBuilder {

    private static final String REPO_FILE_NAME = "D:\\11 - Syncthing\\Java Tehnologies\\Lab1\\src\\main\\java\\branch\\repository.txt";
    private static final String REPO_DELIMITATOR = "->";
    private Map<String, String> contents = new TreeMap<>();


    public KeyBranchResponseBuilder() {}

    public void updateRepoFile(int value, String key) {
        try {
            FileWriter fw = new FileWriter(this.REPO_FILE_NAME,true);
            String ts = Timestamp.from(Instant.now()).toString();
            for (int i = 0; i < value; i++) {
                fw.write(key + this.REPO_DELIMITATOR + ts + "\n");
            }
            fw.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void updateRepoFileUnsafe(int value, String key) {
        this.updateRepoFile(value, key);
    }

    public synchronized void updateRepoFileSafely(int value, String key) {
        this.updateRepoFile(value, key);
    }



    public String getHtmlSortedContent() {
        this.loadRepoFile();

        String htmlBody = "<body>";
        for (Map.Entry<String, String> entry : contents.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();

            htmlBody += "<h1>" + value + "->" + key + "</h1>";
        }
        htmlBody += "</body>";

        return "<html><head></head>" + htmlBody + "</html>";
    }

    private void loadRepoFile() {
        String line = null;
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(this.REPO_FILE_NAME));
            while ((line = bufferreader.readLine()) != null) {
                String[] parts = line.split(this.REPO_DELIMITATOR);
                contents.put(parts[1], parts[0]);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
