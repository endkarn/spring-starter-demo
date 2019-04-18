package com.example.demo;

import com.example.demo.dto.Instance;
import io.jsondb.JsonDBTemplate;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonDBTest {

    String dbFileLocation = System.getProperty("user.dir");
    String baseScanPackage = "com.example.demo";
    JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFileLocation, baseScanPackage);

    @Test
    void firstTest() {
        jsonDBTemplate.createCollection(Instance.class);

    }

    @Test
    void insertTest() {
        Instance instance = new Instance();
//        instance.setId("11");
        instance.setHostname("karnawat");
        jsonDBTemplate.insert(instance);
    }

    @Test
    void findTest() {
        Instance instance = jsonDBTemplate.findById("11", Instance.class);
    }

    @Test
    void findByName() {
        String jxQuery = String.format("/.[hostname='%s']", "karnawat");
        List<Instance> instance = jsonDBTemplate.find(jxQuery, Instance.class);
    }

    @Test
    void removeById() {
//        jsonDBTemplate.
    }
}
