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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CajeroControllerIntegrationTest {
    @ExtendWith(MockitoExtension.class)
    public class CajeroServicio{
        @Mock
        private TransactionService transactionService;

        @injectMockito 
        private CajeroServicio cajeroServicio;

    }
    @LocalServerPort
    private int port; // Este campo contiene el puerto aleatorio asignado a la aplicación

    @Autowired
    private TestRestTemplate restTemplate; // Esto se usa para hacer las solicitudes HTTP en las pruebas

    @Test
    public void obtenerSaldoTest() {
        // Hacer la llamada a la API REST usando TestRestTemplate
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/saldo", String.class);

        // Verificar que el estado de la respuesta sea 200 (OK)
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar que el cuerpo de la respuesta contenga el saldo correcto
        assertEquals("{\"saldo\": 5000}", response.getBody());

        when(TransactionService).theReturn(monto);
        when(TransactionService).theReturn(saldo);
         double respuesta = CajeroServicio.saldoYmonto(5000);
         assertEquals("\"{\\\"saldo\\\": 5000}\"");
         

    }
}
