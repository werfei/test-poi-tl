package org.example;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        TestData testData = new TestData();
        testData.setList(new ArrayList<TestData.Item>());
        for (int i = 0; i < 10; i++) {
            TestData.Item item = new TestData.Item();
            item.setName("name_" + i);
            testData.getList().add(item);
        }
        XWPFTemplate template;
        try (InputStream inputStream = new FileInputStream("./template.docx")) {

            Configure config = Configure.builder()
                    .build();
            template = XWPFTemplate.compile(inputStream, config).render(testData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (OutputStream os = Files.newOutputStream(Paths.get("./result.docx"))) {
            template.writeAndClose(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
