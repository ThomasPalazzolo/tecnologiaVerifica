/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author palazzolo_thomas
 */
public class CorrezioneVerifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String citta = s.nextLine();
        openStreet a = new openStreet();
        a.getPlaces(citta);
        System.out.println(a.getPlaces(citta));
        
        JSonParser jp = new JSonParser();
        jp.register("ciao200", "ciao200");
        jp.setString(jp.getToken("ciao200", "ciao200"));
        jp.getString(jp.getToken("ciao200", "ciao200"));
        
                
    }
    
}
