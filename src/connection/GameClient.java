/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import commons.GameObserver;
import commons.Observable;
import commons.command.ChatMsgCommand;
import commons.command.Command;
import commons.command.DisconnectCommand;
import commons.command.NewClientCommand;
import commons.command.PrivateMsgCommand;
import commons.responses.Response;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.ChatPrivado;


/**
 *
 * @author Fernando
 */
public class GameClient implements Observable<GameObserver>,GameObserver {
    private String host;
    private int port;
    private String name;
    
    // Las notificaciones que manda el Servidor se reenvian a todos los Observadores:
    private List<GameObserver> observers;
    // La conexion al Servidor:
    private Connection connectioToServer;
    // Indica si el juego ha terminado:
    private boolean gameOver;
    // Indica si ha ocurrido algun error:
    private boolean errOccured;
    
    /*     
    *          LA CONSTRUCTORA DE LA CLASE GAMECLIENT
    */
	
    public GameClient(String host, int port, String name) throws Exception {
        // Inicializar los atributos y llamar a "connect" para establecer
        // la conexion con el Servidor:
        this.host = host;
        this.port = port;
        this.name = name;
        observers = new ArrayList<GameObserver>();

        connect();
    }
    
    /*
    *                   CONECTAR AL SERVIDOR
    */
    private void connect() throws Exception {
	try {
	// Creamos una conexion con el Servidor:
	connectioToServer = new Connection(new Socket(host, port));
	
	// Enviamos el string "Connect" para expresar su interes en jugar:
	connectioToServer.sendObject("Connect");
        
        // Enviamos el nombre del jugador
        connectioToServer.sendObject(name);

	// Leemos el primer objeto en la respuesta del Servidor:

	Object response = connectioToServer.getObject();
	// Si es una instancia de 'Exception' entonces lanzamos una excepcion,
	// porque eso significa que el Servidor ha rechazado la peticion:
	if (response instanceof Exception)
            throw (Exception) response;
        
        if (!((String)response).equals("OK"))
            throw new GameError("Respuesta no esperada del Servidor");
       
        //connectioToServer.sendObject(name);
        }
        catch(UnknownHostException ex) {
            System.exit(0);
        }
    }
    
    public void disconnect() throws Exception {
        connectioToServer.stop();
        if (Main.servidor == null) {
            System.exit(0);
        } else {
            Main.interfaz.dispose();

            for (ChatPrivado value : Main.ventanasChatAbiertas.values()) {
                value.dispose();
            }
            // No cierro la aplicación, el servidor sigue funcionando
        }
    }
    
    /*
     *             EL BUCLE PRINCIPAL DE GAMECLIENT
     */
    public void start() {
	
	// Creamos una instancia anonima de 'GameObserver' y la registramos
	// como Observador en 'GameClient':
	addObserver(this);
	
	// Esta instancia tiene que cambiar 'gameOver' a 'false' y cerrar la
	// conexion con el servidor en su metodo "onGameOver". Asi podemos
	// salir del bucle principal cuando termina el juego:
	
	gameOver = false;
	errOccured = false;
        
        if (Main.servidor != null)
            Main.darNombreCliente(name);
        
	while (!gameOver && !errOccured) {
            try {
                // Read a response:
                Response res = (Response) connectioToServer.getObject();			
                for (GameObserver o : observers) {
                    // Execute the response on the Observer 'o'.
                    // Mientras que el juego no haya terminado, leemos
                    // un 'Response' enviado por el Servidor y ejecutamos
                    // "res.run(o)" para cada Observador, para pasarle asi
                    // la notificacion correspondiente.
                    res.run (o);
                }

            } catch (ClassNotFoundException | IOException e) {
                if (!gameOver) {
                    errOccured = true;
                }
            }
	}
    }
    
    
    @Override
    public void onGameStart() { }

    @Override
    public void onGameOver() {
        try {
            gameOver = true;
            connectioToServer.stop();
        } catch (IOException e){}
    }

    @Override
    public void onError(String msg) { }

    @Override
    public void onMsg(String msg) {
        forwardCommand(new ChatMsgCommand(msg));
    }

    @Override
    public void onChangeArea() { }

    @Override
    public void addObserver(GameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GameObserver o) {
        observers.remove(o);
    }
    
    
    private void forwardCommand(Command cmd) {
        // If the game is over do nothing, otherwise
        // send the object 'cmd' to the Server:
        // ...
        if (gameOver)
            return;

        try {
            connectioToServer.sendObject (cmd);
        } catch (IOException e) {}
    }

    @Override
    public void onNewClient(String msg) {
        forwardCommand (new NewClientCommand(msg));
    }

    @Override
    public void onPrivateMsg(String msg, String emisor, String destinatario) {
        forwardCommand(new PrivateMsgCommand(msg, emisor, destinatario));
    }

    @Override
    public void onDisconnectClient(String name) {
        forwardCommand(new DisconnectCommand(name));
    }
    
}
