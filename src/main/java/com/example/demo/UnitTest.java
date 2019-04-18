package com.example.demo;

import com.example.demo.common.ApplicationConstant;
import com.example.demo.dto.ContactModel;
import com.example.demo.dto.KeyMapModel;
import com.example.demo.dto.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class UnitTest {

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

    @Test
    public void testDifOfLocalDateFormat(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    @Test
    public void testForEachBreakIf(){
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("index counter = "+i);
            if(i==5){
                System.out.println("check 5");
                break;
            }if(i==7){
                System.out.println("check 7");
                break;
            }
        }
    }

    @Test
    void testAnnotation(){
        System.out.println(concatString("mytext",null));
    }

    @Test
    void testContainFalseCase() throws Exception{
        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(true);
        booleanList.add(true);
        booleanList.add(false);
        booleanList.add(true);
        booleanList.add(false);
        for(int i = 0 ; i < booleanList.size() ; i++){
            System.out.println(booleanList.get(i));
            if (!booleanList.get(i)) {
                throw new Exception("false");
            }
        }
    }

    private String concatString(String s1 ,@NotNull String s2){
        return s1 + s2;
    }

    @Test
    void integerCanBeNegative(){
        int a = -5;
        int b = 10;
        int c = a+b;
        System.out.println(c);
    }

    @Test
    void replaceStringTest(){
        String baseText = "Hello world my name is karnawat";
        String replacedText = baseText.replace("karnawat","endkarn");
        System.out.println(baseText);
        System.out.println(replacedText);
    }

    @Test
    void replacementInHashmap(){
        String baseText = "hello %T01 , my name is %T02";

        HashMap<String,String> textMappingSet = new HashMap<>();
        textMappingSet.put("%T01","world");
        textMappingSet.put("%T02","karnawat");

        System.out.println(baseText);
        for(HashMap.Entry<String,String> textMapping : textMappingSet.entrySet()){
            baseText = baseText.replace(textMapping.getKey(),textMapping.getValue());
            System.out.println(baseText);
        }
    }

    @Test
    void replacementInKeyMapClass(){
        String baseText = "hello ${T01} , my name is ${T02}";

        List<KeyMapModel> keyMapModels = new ArrayList<>();
        keyMapModels.add(new KeyMapModel("${T01}","world"));
        keyMapModels.add(new KeyMapModel("${T02}","karnawat"));

        System.out.println(baseText);
        for(KeyMapModel textMapping : keyMapModels){
            baseText = baseText.replace(textMapping.getKey(),textMapping.getMap());
            System.out.println(baseText);
        }
    }

    @Test
    void checkPlusByNegativeDate(){
        Timestamp appointDate = Timestamp.valueOf(LocalDateTime.now());
        int sentDayOff = -2;
        LocalDateTime dayed = appointDate.toLocalDateTime().plusDays(sentDayOff);
        System.out.println(appointDate);
        System.out.println(dayed.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Test
    void reflextionTest() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, JsonProcessingException, ClassNotFoundException {
        UserModel userModel = new UserModel("karnawat","wongudom",new ContactModel("0876541091","endkarn0@gmail.com"));
        Map<String, Object> mappedObject = new ObjectMapper().convertValue(userModel, Map.class);

        Object output = JsonPath.read(mappedObject, "$.contact.email");

        System.out.println(output);


//        Class thisClass = Class.forName("UserModel");

    }

    @Test
    void testDateInThai(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        SimpleDateFormat simpleDateFormatTH = new SimpleDateFormat("EEEE ที่ dd เดือน MMMM พ.ศ. yyyy", new Locale("th","TH"));
        String dateTimeText = simpleDateFormatTH.format(timestamp);
        System.out.println(dateTimeText);
    }


}
