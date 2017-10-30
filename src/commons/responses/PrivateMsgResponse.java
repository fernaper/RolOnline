/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.responses;

import commons.GameObserver;
import connection.Main;

/**
 *
 * @author Fernando
 */
public class PrivateMsgResponse implements Response{
    private static final long serialVersionUID = 1L;
    
    private String msg;
    private String emisor;
    private String destinatario;
    
    public PrivateMsgResponse (String msg, String emisor, String destinatario) {
        this.msg = msg;
        this.emisor = emisor;
        this.destinatario = destinatario;
    }

    @Override
    public void run(GameObserver o) {
        Main.mostrarPrivateMsg(msg, emisor, destinatario);
    }
    
}
