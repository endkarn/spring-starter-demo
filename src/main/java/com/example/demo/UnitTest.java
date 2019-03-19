package com.example.demo;

import com.example.demo.common.ApplicationConstant;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.Instance;
import io.jsondb.JsonDBTemplate;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class UnitTest {

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

    @Test
    void testStringFormat() throws Exception {
        String textToday = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String dbUser = ApplicationConstant.JDBC_USERNAME;
        String dbPassword = ApplicationConstant.JDBC_PASSWORD;
        String dbName = "erp";
        String dbBackupPath = File.separator + "opt" + File.separator + "ERPBackupSql" + File.separator + "sqldump-" + textToday;
        String command = String.format("mysqldump --user=%s --password=%s %s %s", dbUser, dbPassword, dbName, dbBackupPath);
        execCmd("echo karnawat");
//        System.out.println(command);
    }

    @Test
    void callCommandOverJava() {
        Runtime rt = Runtime.getRuntime();
        String commands = "docker --version";
        try {
            Process proc = rt.exec(commands);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String execCmd(String cmd) throws java.io.IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        java.io.InputStream is = proc.getInputStream();
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String val = "";
        if (s.hasNext()) {
            val = s.next();
        } else {
            val = "";
        }
        System.out.println(val);
        return val;
    }

    @Test
    public void testSubString(){
        String filename = "somethings.png";
        String subString = filename.substring(filename.lastIndexOf(".")+1);
    }


}
