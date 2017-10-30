package commons;

import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public interface GameObserver {
    public void onGameStart();
    public void onGameOver();
    public void onError(String msg);
    public void onNewClient(String msg);
    public void onDisconnectClient(String name);
    public void onMsg(String msg);
    public void onPrivateMsg(String msg, String emisor, String destinatario);
    public void onChangeArea();
}
