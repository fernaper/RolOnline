/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.command;

/**
 *
 * @author Fernando
 */
public interface Command extends java.io.Serializable {
    /**
    * Executes the command.
    * 
    * <p>
    * Ejecuta el comando.
    * 
    */
    public void execute();

    /**
     * Generates a help text that describes the command.
     * 
     * <p>
     * Genera un texto de ayuda que describe el comando.
     * 
     * @return Help text.
     *         <p>
     *         Texto de ayuda.
     */
    public String helpText();

    /**
     * Parses an input string, and returns an instance of a corresponding
     * command.
     * 
     * <p>
     * Analiza un string de entrada y devuelve una instancia del comando
     * correspondiente.
     * 
     * @param line
     * @return
     */
    public Command parse(String line);
}
