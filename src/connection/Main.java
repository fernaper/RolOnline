/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import commons.GameObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.ChatPrivado;
import ventanas.Entrada;
import ventanas.Interfaz;
import ventanas.Perfil;
import ventanas.Server;

/**
 *
 * @author Fernando
 */
public class Main{

    /**
     *
     * @param args
     */
    public static List <GameObserver> observers;   
    
    /**
     *
     */
    public static final String version = "1.2.0 - Pre Alfa";
    public static GameServer servidor;
    public static GameClient client;
    public static String name;
    
    public static Interfaz interfaz;
    public static Entrada entrada;
    public static Server interfazServer;
    public static Perfil perfil; // Perfil abierto en cada momento
    //public static ChatPrivado conversacion;
    /**
     *  Mapa de ventanas de chat abiertas a la ventana
     */
    public static Map<String, ChatPrivado> ventanasChatAbiertas;
    
    public static List<String> jugadores;
    /**
     *  Mapa de Usuario a conversacion con el usuario
     */
    public static Map<String,String> usuarioChat;
    
    public static boolean desconectado;
    
    public static void main (String[] args) {
        observers = new ArrayList <GameObserver>();
        jugadores = new ArrayList <String>();
        ventanasChatAbiertas = new HashMap <>();
        usuarioChat = new HashMap <>();
        entrada = new Entrada();
        desconectado = false;
    }
    
    /*
        Comenzar cliente y servidor
    */  
    public static void startServer(int port){
        //GameServer c = new GameServer(port);
        //c.start();
                
        new Thread () {
            @Override
            public void run() {
                servidor = new GameServer(port);
                servidor.start();
            }
        }.start();
    }
    
    public static void startClient (String ip, int port, String name) {      
        new Thread () {
            @Override
            public void run () {
                try {
                    //try {
                    client = new GameClient(ip, port, name);
                    client.start();
                    /*} catch (Exception ex) {
                    System.err.println("Ha ocurrido un error mientras intentaba "
                    + "conectar con el servidor: " + ex.getMessage());
                    interfaz.mostrarMsg("Ha ocurrido un error mientras se intentaba "
                    + "establecer la conexión con el servidor");
                    }*/
                } catch (Exception ex) {
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                }
            }
        }.start();
    }
    
    /*
        Cuando se conecta un nuevo jugador
    */
    public static void darNombreCliente (String name) {       
        client.onNewClient(name);
    }
    
    public static void respuestaNombreCliente(String msg) {
        if (servidor != null) {
            jugadores.add(msg);
            servidor.respuestaNewClient(jugadores);
        }
    }
    
    public static void mostrarNewClient (List <String> jugadores) {
        Main.jugadores = jugadores;
        
//        new Thread () {
//            @Override
//            public void run () {
                //int i = 0;
                //while (interfaz == null) {
                    //if (i%1000 == 0)
                        //System.out.println("Esperando conexion, tiempo de espera: " + i/1000 + " segundos");
                    //i++;
                //}
                interfaz.cargarJugadores();
                //mostrarListaAuxiliarmente();
//            }
//        }.start();
    }
    
    private static void mostrarListaAuxiliarmente() {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.print(jugadores.get(i) + ' ');
        }
        System.out.println ("Fin lista");
    }
    
    /*
        Cuando se envia un nuevo mensaje público
    */
    public static void sendMsg(String msg) {
        servidor.onMsg(msg);
    }
    
    public static void msgCliente(String text) {
        client.onMsg(text);
    }  

    public static void mostrarMsg(String msg) {
        interfaz.mostrarMsg(msg);
    }
    
    public static void respuestaMsg (String msg) {
        if (servidor != null) {
            servidor.respuestaMsg(msg);
            servidor.log(msg);
        }
    }
    
    /*
        Cuando se envia un mensaje privado
    */
    public static void msgPrivateCliente(String msg, String emisor, String destinatario) {
        client.onPrivateMsg(msg,emisor,destinatario);
    }
    
    public static void respuestaPrivateMsg (String msg, String emisor, String destinatario) {
        if (servidor != null) {
            servidor.respuestaPrivateMsg(msg, emisor, destinatario);
            servidor.privateLog(msg, destinatario);
        }
    }
    
    public static void mostrarPrivateMsg(String msg, String emisor, String destinatario) {
        if (destinatario.equals(name)) {
            // Si la ventana de chat del receptor con el emisor está ya abierta
            if (ventanasChatAbiertas.containsKey(emisor)) {
                ventanasChatAbiertas.get(emisor).mostrarMsg(msg);
            } else {
                new Thread () {
                    public void run() {
                        // Si no esta ya abierta la ventana
                        // La abro
                        // Lo añado a la lista de ventanas abiertas
                        Main.ventanasChatAbiertas.put(emisor, new ChatPrivado(emisor));
                        // Cogemos toda la conversación guardada (si existe)
                        if (Main.usuarioChat.containsKey(emisor)) {
                            Main.ventanasChatAbiertas.get(emisor).log(Main.usuarioChat.get(emisor));
                        }
                        ventanasChatAbiertas.get(emisor).mostrarMsg(msg);            
                    }
                }.start();
            }
        }
    }

    /*
        Cuando se desconecta un cliente
    */
    public static void quit() {
        try {
            client.onDisconnectClient(name);
            //msgCliente("Server: Se ha desconectado " + name);
        } catch (Exception ex) {
            
        }
    }
    
    public static void respuestaQuit(String name) {
        if (servidor != null) {
            servidor.respuestaQuit(name);
            //servidor.log("Se ha desconectado " + name);
        }
    }
    
    public static void mostrarQuit (String name) {
        jugadores.remove(name);
        // Notificamos a los clientes quien se va en la tabla tambien
        interfaz.cargarJugadores();
    }

    public static void mostrarDisconnect(String name) {
        if (Main.name.equals(name)) {
            desconectado = true;
            try {
                client.disconnect();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mostrarQuit(name);
    }
}
