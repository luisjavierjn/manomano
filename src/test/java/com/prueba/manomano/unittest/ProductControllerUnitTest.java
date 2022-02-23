package com.prueba.manomano.unittest;


import com.prueba.manomano.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductControllerUnitTest.class);

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(productController).isNotNull();
    }

    @Test
    public void shouldReturnBadRequest() throws Exception {
        logger.info("Test shouldReturnBadRequest");
        this.mockMvc.perform(get("/products/1/34")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnNotFound() throws Exception {
        logger.info("Test shouldReturnNotFound");
        this.mockMvc.perform(get("/products/")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnOk() throws Exception {
        logger.info("Test shouldReturnNotFound");
        this.mockMvc.perform(get("/products/1/34?discountExpDate=2021-10-16T00:00:00")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequestBecauseDateTimeConversionFailed() throws Exception {
        logger.info("Test shouldReturnNotFound");
        this.mockMvc.perform(get("/products/1/34?discountExpDate=2021-10-16-00:00:00")).andDo(print()).andExpect(status().isBadRequest());
    }
}
