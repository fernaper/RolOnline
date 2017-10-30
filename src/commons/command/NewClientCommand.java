/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.command;

import connection.Main;

/**
 *
 * @author Fernando
 */
public class NewClientCommand implements Command {
    private static final long serialVersionUID = 1L;
    
    private String msg;
    
    public NewClientCommand (String msg) {
        this.msg = msg;
    }

    @Override
    public void execute() {
        Main.respuestaNombreCliente(msg);
    }

    @Override
    public String helpText() {
        return "NEW CLIENT: Avisa al resto del nuevo cliente";
    }

    @Override
    public Command parse(String line) {
        if (line.trim().equalsIgnoreCase("client")) {
            return this;
        } else {
            return null;
        }
    }
    
}
