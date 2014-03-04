package com.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author : Georgy Gobozov
 * @created : 11.04.13
 */
public class Main {


    public static void main(String[] args) throws IOException {

        //deleteUser(2);
        createuser();

    }

    public static void createuser() throws IOException{

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8080/users/create");

        StringEntity input = new StringEntity("[{user: {\n" +
                "userId: 4,\n" +
                "login: \"user4\",\n" +
                "password: \"user4\",\n" +
                "email: \"user4@mail.ru\"\n" +
                "}}]");


        input.setContentType("application/json");
        post.setEntity(input);

        HttpResponse response = client.execute(post);

        int code = response.getStatusLine().getStatusCode();
        System.out.println("code = " + code);

        if ( code != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }


        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

    }


    public static void deleteUser(int id) throws IOException {

        HttpClient client = new DefaultHttpClient();
        HttpDelete delete = new HttpDelete("http://localhost:8080/users/" + id);
        HttpResponse response = client.execute(delete);

        int code = response.getStatusLine().getStatusCode();
        System.out.println("code = " + code);

        if ( code != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }


        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }



    }

}
