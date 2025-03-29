package com.ejemplo.cajero;
import java.lang.*;
import org.junit.jupiter.api.Test;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Apply2Files {

    // Método que devuelve un valor booleano
    public boolean apply() {
        boolean apply = true;  // Inicializamos la variable
        return apply;  // Retornamos el valor
    }

    public static void main(String[] args) {
        Apply2Files obj = new Apply2Files();
        System.out.println(obj.apply());  // Imprime "true"
    }

    // Bloque estático para cargar la biblioteca dinámica
    static {
        try {
            // Cargar la biblioteca .dylib correctamente sin las comillas extras
            System.load("/usr/local/lib/mysqlrouter/libprotobuf-lite.24.4.0.dylib");
            System.out.println("Ejecutando librería correctamente.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error al cargar la librería: " + e.getMessage());
        }
    }
}
