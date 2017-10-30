package commons.responses;

import commons.GameObserver;

/**
 *
 * @author Fernando
 */
public interface Response extends java.io.Serializable {	
    public void run(GameObserver o);
}
