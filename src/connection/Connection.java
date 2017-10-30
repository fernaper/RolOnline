/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Fernando
 */
public class Connection {
        private volatile ObjectInputStream in;
	private volatile ObjectOutputStream out;
	private volatile Socket s;

	public Connection(Socket s) throws IOException {
            // Almacenamos los Streams de entrada y salida en atributos:
            this.s = s;
            this.out = new ObjectOutputStream(s.getOutputStream());
            this.in = new ObjectInputStream(s.getInputStream());		
	}

	public void sendObject(Object r) throws IOException {	
            // Enviamos un objeto:
            out.writeObject(r);
            out.flush();
            out.reset();
	}

	public Object getObject() throws IOException, ClassNotFoundException {		
            // Recibimos un objeto:
            return in.readObject();
	}

	public void stop() throws IOException {		
            // Cerramos el Socket:
            s.close();
		
	}
}
