package homework15;

import org.testng.annotations.Test;
import pageObjects.DownloadPage;
import pageObjects.MainPage;
import pageObjects.UploadPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileTest extends BaseTest {

    Path path = Paths.get("target/download/some-file.txt");

    @Test(description = "Download file")
    public void downloadFileTest() {

        MainPage mainPage = new MainPage(driver);
        DownloadPage downloadPage = openApp()
                .goToDownloadPage()
                .downloadFile();
        readFromFile();
        writeToFile();
    }

    @Test(description = "Upload file")
    public void uploadFileTest() {

        MainPage mainPage = new MainPage(driver);
        UploadPage uploadPage = openApp()
                .goToUploadPage()
                .selectFile(getFileToUpload())
                .submitUpload();
    }

    public void readFromFile() {
        try {
            Thread.sleep(2000);
            List<String> lines = Files.readAllLines(path.toAbsolutePath());
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile() {
        try {
           Files.writeString(path, "\nAdded text 01", StandardOpenOption.APPEND);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public File getFileToUpload() {
        return new File(String.valueOf(path)).getAbsoluteFile();
    }

}
