/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.responses;

import commons.GameObserver;
import connection.Main;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class NewClientResponse implements Response{
    private static final long serialVersionUID = 1L;
    
    private List <String> jugadores;

    public NewClientResponse(List <String> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public void run(GameObserver o) {
        Main.mostrarNewClient(jugadores);
    }
    
}
