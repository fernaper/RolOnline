/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.responses;

import commons.GameObserver;
import connection.Main;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Fernando
 */
public class DisconnectResponse implements Response {
    private static final long serialVersionUID = 1L;
    
    private String name;

    public DisconnectResponse(String name) {
        this.name = name;
    }

    @Override
    public void run(GameObserver o) {
        // Informamos de la desconexión
        Calendar calendario = new GregorianCalendar();
        Main.mostrarMsg("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                    calendario.get(Calendar.MINUTE) +
                    "] Server: Se ha desconectado " + name);
        Main.mostrarDisconnect(name);
    }
    
}
