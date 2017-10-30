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
public class PrivateMsgCommand implements Command {
    private static final long serialVersionUID = 1L;
    
    private String msg;
    private String emisor;
    private String destinatario;
    
    public PrivateMsgCommand (String msg, String emisor, String destinatario) {
        this.msg = msg;
        this.emisor = emisor;
        this.destinatario = destinatario;
    }

    @Override
    public void execute() {
        Main.respuestaPrivateMsg(msg, emisor, destinatario);
    }

    @Override
    public String helpText() {
        return "MENSAJE PRIVADO: Envia un mensaje por el chat privado a alguien";
    }

    @Override
    public Command parse(String line) {
        if (line.trim().equalsIgnoreCase("private")) {
            return this;
        } else {
            return null;
        }
    }
    
}
