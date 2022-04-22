/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static javax.swing.UIManager.getString;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author palazzolo_thomas
 */
public class JSonParser {

    public JSonParser() {

    }

    public String getToken(String username, String password) throws MalformedURLException, IOException {
        URL fileUrl = new URL("http://172.16.102.100/SaveStrings/getToken.php?username=" + URLEncoder.encode(username, StandardCharsets.UTF_8) + "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8));
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        String jsonString = content;
        JSONObject obj = new JSONObject(jsonString);
        JSONObject result = obj.getJSONObject("result");
        return result.getString("token");
        //return obj;

        //System.out.println(obj.getJSONObject("result"));
    }

    public void register(String username, String password) throws MalformedURLException, IOException {
        URL fileUrl = new URL("http://172.16.102.100/SaveStrings/register.php?username=" + URLEncoder.encode(username, StandardCharsets.UTF_8) + "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8));
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        String jsonString = content;
        JSONObject obj = new JSONObject(jsonString);

        //System.out.println(obj.getJSONObject("status"));
        String temp = obj.getString("status");
        if ("ok".equals(temp)) {
            System.out.println("Token:" + getToken(username, password));
        } else if ("error".equals(temp)) {
            System.out.println("Utente gia registrato");
            
        }
    }

    public void setString(String token) throws MalformedURLException, IOException {

        URL fileUrl = new URL("http://172.16.102.100/SaveStrings/setString.php?token=" + token + "&key=IDENTIFICATIVO&string=HELLO_WORLD");
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        String jsonString = content;
        JSONObject obj = new JSONObject(jsonString);
    }

    public String getString(String token) throws MalformedURLException, IOException {

        URL fileUrl = new URL("http://172.16.102.100/SaveStrings/getString.php?token=" + token + "&key=IDENTIFICATIVO&string=HELLO_WORLD");
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        String jsonString = content;
        JSONObject obj = new JSONObject(jsonString);
        JSONObject result = obj.getJSONObject("result");
        System.out.println(result.getString("string"));
        return result.getString("string");
        
        
    }

}
