package com.invest.controller.stock;

import com.invest.operations.domain.Currency;
import com.invest.operations.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;


//@RunWith(SpringRunner.class)
//@SpringBootTest

@WebMvcTest(controllers = StockResource.class)
public class StockResourceTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public StockService stockService;

    @Test
    public void test() throws Exception {
        System.out.println(stockService);
        Mockito.when(this.stockService.getAllCurrencies()).thenReturn(Collections.singletonList(new Currency("Test", "Test")));

        mockMvc.perform(MockMvcRequestBuilders.get("stock/currency/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
