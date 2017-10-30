/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.command;

import connection.Connection;
import connection.Main;

/**
 *
 * @author Fernando
 */
public class DisconnectCommand implements Command {
    private static final long serialVersionUID = 1L;
    
    private String name;

    public DisconnectCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        Main.respuestaQuit(name);
    }

    @Override
    public String helpText() {
        return "DISCONNECT: Informa a todos de que se ha desconectado un cliente.";
    }

    @Override
    public Command parse(String line) {
        if (line.trim().equalsIgnoreCase("disconnect")) {
            return this;
        } else {
            return null;
        }
    }
    
}
