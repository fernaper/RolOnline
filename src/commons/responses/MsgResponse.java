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
public class MsgResponse implements Response{
    private static final long serialVersionUID = 1L;
    
    private String msg;

    public MsgResponse(String msg) {
        this.msg = msg;
    }
    
    @Override
    public void run(GameObserver o) {
        //o.onMsg(msg);
        Main.mostrarMsg(msg);
    }
    
}
