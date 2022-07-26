package guru.qa.config;

import com.codeborne.selenide.conditions.webdriver.Url;
import org.aeonbits.owner.Config;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;


public interface TypeConfig extends Config {

    @Key("integer")
    Integer getInteger();

    @Key("double")
    Double getDouble();

    @Key("boolean")
    Boolean getBoolean();

    @Key("enum")
    Browser getEnum();

    @Key("url")
    URL getUrl();

    @Key("file")
    File getFile();


//    @Key("path")
//    Path getPath();

//    @Key("byte")
//    Byte[] getByte();
}
