package br.com.acqio.empresa.controller;

import br.com.acqio.empresa.util.JunitWiseUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpresaControllerTest {

    @Autowired
    public WebApplicationContext context;

    private MockMvc mvc;
    private ResultMatcher ok = MockMvcResultMatchers.status().isOk();
    private ResultMatcher bad = MockMvcResultMatchers.status().isBadRequest();
    private ResultMatcher notFound = MockMvcResultMatchers.status().isNotFound();
    private ResultMatcher created = MockMvcResultMatchers.status().isCreated();
    private ResultMatcher allowed = MockMvcResultMatchers.status().isMethodNotAllowed();

    private MockHttpServletRequestBuilder builder;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.context);
        this.mvc = builder.build();
    }

    @Test
    public void listAllCompaniesTest1() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa");
        this.mvc.perform(builder)
                .andExpect(this.ok);
    }

    @Test
    public void listAllCompaniesTest2() throws Exception {
        builder = MockMvcRequestBuilders.get("/emres");
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void listAllCompaniesTest3() throws Exception {
        builder = MockMvcRequestBuilders.get("/");
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void detailTest1() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa/1");
        this.mvc.perform(builder)
                .andExpect(this.ok);
    }

    @Test
    public void detailTest2() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa/@");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void detailTest3() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa/*");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void detailTest4() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa/-1");
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void registerTest1() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.created);
    }

    @Test
    public void registerTest2() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJsonWithBlankFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void registerTest3() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJsonWithMissingFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void registerTest4() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.allowed);
    }

    @Test
    public void registerTest5() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content("");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void updateTest1() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.ok);
    }

    @Test
    public void updateTest2() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/*")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void updateTest3() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/-1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void updateTest4() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJsonWithBlankFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void updateTest5() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.allowed);
    }

    @Test
    public void updateTest6() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void deleteTest1() throws Exception {
        builder = MockMvcRequestBuilders.delete("/empresa/1");
        this.mvc.perform(builder)
                .andExpect(this.ok);
    }

    @Test
    public void deleteTest2() throws Exception {
        builder = MockMvcRequestBuilders.delete("/empresa/-1");
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void deleteTest3() throws Exception {
        builder = MockMvcRequestBuilders.delete("/empresa/*");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void deleteTest4() throws Exception {
        builder = MockMvcRequestBuilders.delete("/empresa");
        this.mvc.perform(builder)
                .andExpect(this.allowed);
    }

}