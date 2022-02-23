package com.prueba.manomano.unittest;

import com.prueba.manomano.controller.ProductController;
import com.prueba.manomano.model.ProductResponseList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductControllerUnitTest.class);

    @Autowired
    private ProductController productController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        assertThat(productController).isNotNull();
    }

    @Test
    public void controllerShouldReturnOk() throws Exception {
        logger.info("Test controllerShouldReturnOk");
        ResponseEntity<ProductResponseList> response = restTemplate.getForEntity("http://localhost:" + port + "/products/1/34/?discountExpDate=2021-10-16T00:00:00", ProductResponseList.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    public void controllerShouldReturnBadRequest() throws Exception {
        logger.info("Test controllerShouldReturnBadRequest");
        ResponseEntity<ProductResponseList> response = restTemplate.getForEntity("http://localhost:" + port + "/products/1/34/?discountExpDate=", ProductResponseList.class);
        assertEquals(response.getStatusCode(),HttpStatus.BAD_REQUEST);
    }
}
