package homework17.selenideTest;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import selenidePages.SelenideDownloadPage;
import selenidePages.SelenideUploadPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SelenideFileTest {

    @Test(description = "Work with files with Selenide")
    public void fileTest() {
        Configuration.downloadsFolder = "target/SelenideDownloads_2";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";

        open("/download");

        SelenideDownloadPage downloadPage = new SelenideDownloadPage();
        File file = downloadPage.downloadFile("some-file.txt");

        readFromFile(file);
        writeToFile(file);

        open("/upload");

        SelenideUploadPage uploadPage = new SelenideUploadPage();
        uploadPage.uploadFile(getFileToUpload(file));

    }

    public void readFromFile(File testFile) {
        try {
            Path path = Paths.get(String.valueOf(testFile));
            Thread.sleep(2000);
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(File testFile) {
        try {
            Path path = Paths.get(String.valueOf(testFile));
            Files.writeString(path, "\nAdded text 31-01-2022", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFileToUpload(File testFile) {
        Path path = Paths.get(String.valueOf(testFile));
        return new File(String.valueOf(path)).getAbsoluteFile();
    }


}
