package commons;

/*
 * Author: Fernando
 **/
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class getIp {
    List <URL> urls;
    
	private String publicIP = "<No es posible resolver la direccion IP>";
 
    public getIp() {
        boolean exit = false;
        
        initUrls();
        
        Iterator it = urls.iterator();
        
        while (!exit && it.hasNext()) {
                    
            try {
                //URL whatismyip = new URL("http://checkip.amazonaws.com");
                BufferedReader in = new BufferedReader(new InputStreamReader(((URL)it.next()).openStream()));
                publicIP = in.readLine();
                in.close();
                exit = true;
            } catch (IOException ex) {
                Logger.getLogger(getIp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getPublicIP () {
        return publicIP;        
    }

    private void initUrls() {
        urls = new ArrayList<URL>();
        try {
            urls.add (new URL ("https://api.ipify.org"));
            urls.add (new URL("http://checkip.amazonaws.com"));
            urls.add (new URL("http://myexternalip.com/raw"));
            //urls.add (new URL ("error"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(getIp.class.getName()).log(Level.INFO, null, ex);
        }
    }
}