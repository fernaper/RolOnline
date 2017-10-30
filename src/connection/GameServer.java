/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import commons.responses.Response;
import commons.GameObserver;
import commons.command.*;
import commons.responses.ChangeAreaResponse;
import commons.responses.DisconnectResponse;
import commons.responses.ErrorResponse;
import commons.responses.GameOverResponse;
import commons.responses.GameStartResponse;
import commons.responses.MsgResponse;
import commons.responses.NewClientResponse;
import commons.responses.PrivateMsgResponse;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import ventanas.Server;

/**
 *
 * @author Fernando
 */
public class GameServer implements GameObserver {
    
    private int port;
    private int numOfConnectedPlayers;
    private List<Connection> clients;
    /*
     *  Mapa de nombre del cliente a su conexión
     */
    private Map<String,Connection> nombresClientes;
    
    volatile private ServerSocket server;
    volatile private boolean stopped;
    private String lastPlayer;
    
    
    GameServer(int port) {
        this.port = port;
        this.clients = new ArrayList<Connection>();
        this.nombresClientes = new HashMap<> ();
        this.numOfConnectedPlayers = 0;
        
        Main.interfazServer = new Server ();
        // Añadimos observador
        Main.observers.add(this);
    }

    void start() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            throw new GameError("No se pudo iniciar el servidor en el puerto " + port + " (" + e.getMessage() + ")");
        }

        // Indicamos que el juego no ha terminado, ya que estamos a punto de
        // empezar:
        stopped = false;

        /*                    EL BUCLE DEL SERVIDOR

           Esperamos a que un Cliente se conecte, y pasamos el Socket 
           correspondiente a "handleRequest" para responder a su peticion:

         */
        while (!stopped) {
            try {
                // 1. Accept a connection into a Socket 's'.
                Socket s = server.accept();
                
                // Call "handleRequest(s)" to handle the request.
                // "log" a corresponding message.
                if (handleRequest(s)) {
                    Calendar calendario = new GregorianCalendar();
                    log ("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                        calendario.get(Calendar.MINUTE) +
                        "] Se ha conectado: " + lastPlayer);
                } else {
                    Calendar calendario = new GregorianCalendar();
                    log ("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                        calendario.get(Calendar.MINUTE) +
                        "] Connection Refused: Se ha intentado conectar un cliente.");
                }
            } catch (IOException e) {
                if (!stopped) {
                    log("Error mientras se esperaba para la conexion: " + e.getMessage());
                }
            }
        }
    }
    
    public void log (String msg) {
        javax.swing.JTextArea area = Main.interfazServer.cogerInfo();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Show the message in "infoArea", use "invokeLater".
                area.append(msg + "\n");
            }
        });
        
        Main.interfazServer.guardarInfo(area);
    }
    
    public void privateLog (String msg, String destinatario) {
        javax.swing.JTextArea area = Main.interfazServer.cogerInfo();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Show the message in "infoArea", use "invokeLater".
                area.append("Mensaje privado a " + destinatario
                        + ">> " + msg + "\n");
            }
        });
        
        Main.interfazServer.guardarInfo(area);
    }
    
    private boolean handleRequest (Socket s) {        
        try {
            Connection c = new Connection(s);

            // The first thing we should receive from a Client is a String with
            // the text "Connect":
            Object clientRequest = c.getObject();

            if (!(clientRequest instanceof String) && !((String) clientRequest).equalsIgnoreCase("Connect")) {
                c.sendObject(new GameError("Respuesta inválida"));
                c.stop();
                return false;
            }
            //1.
            clientRequest = c.getObject();
            if (!(clientRequest instanceof String) || Main.jugadores.contains((String)clientRequest)) {
                c.sendObject(new GameError("Respuesta inválida"));
                c.stop();
                return false;
            }
            this.lastPlayer = (String)clientRequest;
            
            // 2. Increase the number of players:
            numOfConnectedPlayers++;

            // and add the Client to the list of Clients:
            clients.add(c);
            
            // Añadimos el cliente al mapa
            nombresClientes.put((String) clientRequest, c);

            // 3. Enviar el string "OK" al Cliente
            c.sendObject("OK");
            
            // 4. Cogemos el nombre del jugador
            //String namePlayer = (String)c.getObject();
            
            // 5. Invocar a "startClientListener" para iniciar una hebra con la
            // que recibir los comandos del Cliente:          
            startClientListener(c);

        } catch (IOException | ClassNotFoundException _e) {}
        return true;
    }
    
    /*
    *               RECIBIR COMANDOS DEL CLIENTE
    */
    private void startClientListener(final Connection c) {
        // Iniciamos una hebra para ejecutar el bucle de abajo mientras
        // el juego no haya terminado y el Servidor no haya sido parado:

        Thread t = new Thread() {

            @Override
            public void run() {
                while (!stopped) {	
                    try {
                        Command cmd;
                        // 1. Read a Command.
                        cmd = (Command) c.getObject();                        
                        // 2. Execute the command.
                        cmd.execute ();
                    } catch (ClassNotFoundException | IOException e) {
                        if (!stopped) {
                            //System.err.println ("Error");
                            // Stop the game (not the Server).
                            //desconectarClientes();
                            //stopped = true;
                            return; // Termino esta hebra
                        }
                    }
                }
            };
        };
        t.start();
    }
    
    public void desconectarClientes () {    
//        for (Connection c: clients) {
//            try {
//                c.stop();
//                log ("Cliente desconectado");
//            } catch (IOException e) { }
//        }
        {
            Calendar calendario = new GregorianCalendar();
            Main.respuestaMsg("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                        calendario.get(Calendar.MINUTE) + "] Server: El servidor ha sido cerrado");
        }
        for (Map.Entry<String, Connection> entry : nombresClientes.entrySet()) {
            String key = entry.getKey();
            Connection value = entry.getValue();
            forwardNotification (new DisconnectResponse(key));
            
            try {
                value.stop();
                Calendar calendario = new GregorianCalendar();
                    log ("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                    calendario.get(Calendar.MINUTE) + "] Se ha desconectado: " +
                        key);
            } catch (IOException ex) {
                
            }
        }
        
        clients.clear();
        numOfConnectedPlayers = 0;
    }
    
    public void pararServidor () {
        stopped = true;
        
        try {
            server.close();
        } catch (IOException e) { }
    }
    
    public void respuestaMsg (String msg) {
        forwardNotification(new MsgResponse(msg));
    }
    
    public void respuestaPrivateMsg (String msg, String emisor, String destinatario) {
        forwardNotification (new PrivateMsgResponse(msg, emisor, destinatario));
    }
    
    public void respuestaNewClient (List <String> jugadores) {
        forwardNotification (new NewClientResponse(jugadores));
    }
    
    public void respuestaQuit(String name) {
        try {
            forwardNotification (new DisconnectResponse(name));
            
            numOfConnectedPlayers--;
            
            Calendar calendario = new GregorianCalendar();
            log ("[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                    calendario.get(Calendar.MINUTE) + "] Se ha desconectado: " +
                    name);
            
            nombresClientes.get(name).stop();
            clients.remove(nombresClientes.get(name));
            nombresClientes.remove(name);
        } catch (IOException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void forwardNotification(Response r) {
        // Call "c.sendObject(r)" for each Client connection 'c'.
        for (Connection c: clients) {
            try {
                c.sendObject(r);
            } catch (IOException e) {}
        }
    }
    
    @Override
    public void onGameStart() {
        forwardNotification(new GameStartResponse());
    }

    @Override
    public void onGameOver() {
        forwardNotification(new GameOverResponse());
    }

    @Override
    public void onError(String msg) {
        forwardNotification(new ErrorResponse(msg));
    }

    @Override
    public void onMsg(String msg) {
        forwardNotification(new MsgResponse(msg));
    }

    @Override
    public void onChangeArea() {
        forwardNotification(new ChangeAreaResponse());
    }

    @Override
    public void onNewClient(String msg) {
        forwardNotification(new NewClientResponse(Main.jugadores));
    }

    @Override
    public void onPrivateMsg(String msg, String emisor, String destinatario) {
        forwardNotification(new PrivateMsgResponse(msg, emisor, destinatario));
    }

    @Override
    public void onDisconnectClient(String name) {
        forwardNotification (new DisconnectResponse(name));
    }
}
