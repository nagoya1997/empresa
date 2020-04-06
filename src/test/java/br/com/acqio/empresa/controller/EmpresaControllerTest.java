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
    public void listAllCompaniesTest() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa");
        this.mvc.perform(builder)
                .andExpect(this.ok);

        builder = MockMvcRequestBuilders.get("/emres");
        this.mvc.perform(builder)
                .andExpect(this.notFound);

        builder = MockMvcRequestBuilders.get("/");
        this.mvc.perform(builder)
                .andExpect(this.notFound);

    }

    @Test
    public void detailTest() throws Exception {
        builder = MockMvcRequestBuilders.get("/empresa/1");
        this.mvc.perform(builder)
                .andExpect(this.ok);

        builder = MockMvcRequestBuilders.get("/empresa/@");
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.get("/empresa/*");
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.get("/empresa/-1");
        this.mvc.perform(builder)
                .andExpect(this.notFound);
    }

    @Test
    public void registerTest() throws Exception {
        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.created);

        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJsonWithBlankFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJsonWithMissingFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.post("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.postEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.allowed);

        builder = MockMvcRequestBuilders.post("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content("");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void updateTest() throws Exception {
        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.ok);

        builder = MockMvcRequestBuilders.put("/empresa/*")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.put("/empresa/-1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.notFound);

        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJsonWithBlankFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJsonWithMissingFields());
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.put("/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JunitWiseUtil.putEmpresaEntityJson());
        this.mvc.perform(builder)
                .andExpect(this.allowed);

        builder = MockMvcRequestBuilders.put("/empresa/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("");
        this.mvc.perform(builder)
                .andExpect(this.bad);
    }

    @Test
    public void deleteTest() throws Exception {
        builder = MockMvcRequestBuilders.delete("/empresa/1");
        this.mvc.perform(builder)
                .andExpect(this.ok);

        builder = MockMvcRequestBuilders.delete("/empresa/-1");
        this.mvc.perform(builder)
                .andExpect(this.notFound);

        builder = MockMvcRequestBuilders.delete("/empresa/*");
        this.mvc.perform(builder)
                .andExpect(this.bad);

        builder = MockMvcRequestBuilders.delete("/empresa");
        this.mvc.perform(builder)
                .andExpect(this.allowed);
    }


}