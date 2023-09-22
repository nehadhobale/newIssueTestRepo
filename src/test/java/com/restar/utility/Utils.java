package com.restar.utility;

import io.netty.handler.codec.json.JsonObjectDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

public class Utils {

    public static Properties getProperties(String name) throws IOException {
        File f1 = new File("src//test//resources//" +name+ "Data.properties");
        FileInputStream fs = new FileInputStream(f1);
        Properties pro = new Properties();
        pro.load(fs);
        return pro;
    }

    public static String decode(String encodedStr){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);
        String decodedString = new String(decodedBytes);
        return  decodedString;
    }

    public static String generateIssueNumber(){
        Random rand = new Random();
        int max=99999,min=9999;
       return String.valueOf(rand.nextInt(max-min+1+min));

    }


}
