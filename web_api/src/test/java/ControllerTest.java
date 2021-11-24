//import PortfolioResource;
//import com.invest.portfolio.service.PortfolioModificationService;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.when;
//
//    @RunWith(SpringRunner.class)
//    @WebMvcTest(PortfolioResource.class)
//    public class ControllerTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @MockBean
//        private PortfolioModificationService portfolioService;
//
//        @Test
//        public void test() throws Exception {
//            when(portfolioService.test()).thenReturn("Тест пройден!");
//            this.mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/test"))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Тест пройден!")));
//        }
//
//}
