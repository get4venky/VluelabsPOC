package com.support;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.support.controller.view.MainController;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void generateScheduleTest() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }
    @Test
  public void generateScheduleTest3() throws Exception{
    	mvc.perform(get("/")).andExpect(status().isBadRequest());
    }
    @Test
    public void generateScheduleTest2() throws Exception{
      	mvc.perform(get("/")).andExpect(status().isNoContent());
      }
    
    

}
