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
public class ChatMsgCommand implements Command{
    private static final long serialVersionUID = 1L;
    
    private String msg;
    
    public ChatMsgCommand() {
        msg = "Texto de ejemplo";
    }
    
    public ChatMsgCommand (String msg) {
        this.msg = msg;
    }

    @Override
    public void execute() {
        Main.respuestaMsg(msg);
    }

    @Override
    public String helpText() {
        return "CHAT: Envia un mensaje por el chat principal";
    }

    @Override
    public Command parse(String line) {
        if (line.trim().equalsIgnoreCase("chat")) {
            return this;
        } else {
            return null;
        }
    }
    
}
