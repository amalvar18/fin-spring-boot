package com.finomyr.finomyrapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.finomyr.finomyrapp.tax.repo.TaxationRepository;

@RunWith(SpringRunner.class)
// @SpringBootTest
/*@WebMvcTest
ContextConfiguration(classes = Applica)*/
public class FinomyrAppApplicationTests {

    /*@Autowired
     MockMvc mockMvc;*/

    @MockBean
    TaxationRepository taxationRepository;

    @Test
    public void contextLoads() throws Exception {

        /*Mockito.when(taxationRepository.findByAssetClassAndActiveTrue("Equity"))
                .thenReturn(Collections.emptySet());
        
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/admin/taxation"))
                .andReturn();
        
        System.out.println(mvcResult.getResponse());*/

        Mockito.verify(taxationRepository).findByAssetClassAndActiveTrue("Equity");
    }

}
