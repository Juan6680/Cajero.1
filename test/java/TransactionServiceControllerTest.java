
package com.ejemplo.cajero.cajeroIntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class TransactionServiceControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCrearTransaccion() {
        Monto monto = new Monto(5000);
        Saldo saldo = new Saldo(1000);

        webTestClient.post()
                .uri("/api/monto")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(monto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.monto").isEqualTo(5000);

        webTestClient.post()
                .uri("/api/saldo")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(saldo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.saldo").isEqualTo(1000);
    }

    @Test
    void obtenerTransaccion() {
        webTestClient.get()
                .uri("/api/monto")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.monto").exists();

        webTestClient.get()
                .uri("/api/saldo")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.saldo").exists();
    }

    @Test
    void borrarTransaccion() {
        Monto monto = delete(monto);
        webTestClient.delete()
                .uri("/api/monto")
                .exchange()
                .expectStatus().isNoContent();

        webTestClient.delete()
                .uri("/api/saldo")
                .exchange()
                .expectStatus().isNoContent();


    }
}
