package guru.qa.hw13_16;

import guru.qa.config.Browser;
import guru.qa.config.TypeConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class TypeTest {

    @Test
    public void testInteger() {
        System.setProperty("integer", "10");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(10);
    }

    @Test
    public void testDouble() {
        System.setProperty("double", "10.10");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(10.10);
    }

    @Test
    public void testBoolean() {
        System.setProperty("boolean", "true");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getBoolean()).isEqualTo(true);
    }

    @Test
    public void testEnum() {
        System.setProperty("enum", "CHROME");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.CHROME);
    }

    @Test
    public void testFile() {
        System.setProperty("file", "photo_girls.jpg");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getFile()).hasFileName("photo_girls.jpg");
    }

    @Test
    public void testUrl() {
        System.setProperty("url", "https://github.com");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getUrl()).hasHost("github.com").hasProtocol("https");
    }

/*    @Test
    public void testPath() {
        System.setProperty("path", String.valueOf("resources/files/photo_girls.jpg"));

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());

       assertThat(config.getPath()).hasContent("resources/files/photo_girls.jpg");
    }

    @Test
    public void testByte() {
        System.setProperty("byte", "h,e,l,l,o");

        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getByte()).containsOnly();
    }
    */

}
