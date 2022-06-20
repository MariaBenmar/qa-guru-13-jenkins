package guru.qa.hw13_8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonParseByJackson {
    ClassLoader classLoader = JsonParseByJackson.class.getClassLoader();

    @Test
    @DisplayName("Reading JSON by Jackson library")
    void jsonTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("about.json")) {
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(new InputStreamReader(is, UTF_8));
            ArrayList<String> list = om.convertValue(jsonNode.get("extra").get("recipe-maintainers"), ArrayList.class);
            assertThat(jsonNode.get("conda_build_version").asText()).isEqualTo("3.18.11");
            assertThat(jsonNode.get("extra").findValue("copy_test_source_files").asBoolean()).isEqualTo(true);
            assertThat(jsonNode.get("extra").findValue("final").asBoolean()).isEqualTo(true);
            assertThat(list).
                    containsAll(Arrays.asList("jakirkham", "pelson", "ocefpaf", "mingwandroid"));
        }
    }
}
