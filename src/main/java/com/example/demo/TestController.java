package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
public class TestController {

    @GetMapping("/test")
    private String test() throws Exception {
        log.println("CHECK TEST API");

        try {
            URL url = new URL("http://103.13.31.63:8555/restaurant/api/restaurant/v1/bpm/dashboard/summary");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNEUxQkUyN0Q0QTI3OURGNjM4M0EyQUVEREE0RUZBQkMiLCJleHAiOjE1NDg1MTMwNTAsImlhdCI6MTU0NzkwODI1MH0.pq7juV50vA5MYbWmy4lJuQZXT8MbhBPaKBbRnU0MIaTwFzJZH9pTZbxne1brsmKMa2HAfldR-4wEWlCeiAkB8g");

            httpURLConnection.setDoOutput(true);

            String reqBody = "{\"property\":[],\"criteria\":{},\"orderBy\":{\"InvoiceDocument-id\":\"desc\"},\"pagination\":{\"limitItem\":50,\"currentPage\":1}}";

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(reqBody.getBytes());
            outputStream.flush();
            outputStream.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            return "TRUE";
        } catch (Exception ex) {
            log.println("SOME");
            return "FALSE";
        }
    }

    @GetMapping("monitor")
    private String echoMonitor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        URL jsonUrl = new URL("http://localhost:3000/sysinfo/metric");
        jsonUrl.openConnection().connect();
        Map map = mapper.readValue(jsonUrl, Map.class);
        JSONObject jsonObject = new JSONObject(map);

        String serviceName = jsonObject.getString("serviceName");
        double sysCpuLoad = jsonObject.getDouble("sysCpuLoad");
        double proCpuLoad = jsonObject.getDouble("proCpuLoad");
        double memTotal = jsonObject.getDouble("memTotal");
        double memFreeTotal = jsonObject.getDouble("memFreeTotal");
        double currentMemUse = jsonObject.getDouble("currentMemUse");
        double availableCore = jsonObject.getDouble("availableCore");
        String osName = jsonObject.getString("osName");
        String osVersion = jsonObject.getString("osVersion");
        String osArch = jsonObject.getString("osArch");
        JSONArray storage = jsonObject.getJSONArray("storage");

        int cpuPercentBlock = (int) sysCpuLoad / 10;
        int memPercentBlock = (int) currentMemUse / 10;
        String textCpuBlock = "";
        String textMemBlock = "";
        for (int i = 0; i <= 10; i++) {
            if (i <= cpuPercentBlock)
                textCpuBlock = textCpuBlock+"█";
            else
                textCpuBlock = textCpuBlock+"▒";

            if (i <= memPercentBlock)
                textMemBlock = textMemBlock+"█";
            else
                textMemBlock = textMemBlock+"▒";

        }

        for (int i = 0; i < storage.length(); i++) {
            JSONObject aStorage = storage.getJSONObject(i);

        }

        return jsonObject.getString("osArch");
    }


}
