/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

/**
 *
 * @author Fernando
 */
public interface Observable <T> {
    public void addObserver (T o);
    public void removeObserver (T o);
}
