/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                


        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Oliot:");
        for (Player player : players) {
            System.out.println(player);
        }   
    }
  
}