package guru.qa.hw13_8;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideTest {

 /*   static  {
        Configuration.fileDownload = FileDownloadMode.PROXY;
    } */

    @Test
    void downloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File file = $("#raw-url").download();
        try (InputStream is = new FileInputStream(file)) {
            byte[] fileContent = is.readAllBytes();
            String asString = new String(fileContent, UTF_8);
            assertThat(asString).contains("Contributions to JUnit 5");
        }
    }

    @Test
    void uploadTest() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        //$("input[type='file']").uploadFile(new File("/Users/mariabenavidesmartines/IdeaProjects/qa-guru-9/src/test/resources/photo_girls.jpg"));
        $("input[type='file']").uploadFromClasspath("files/photo_girls.jpg");

    }
}
