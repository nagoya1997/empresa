package br.com.acqio.empresa.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Test
    void findByRazaoSocial() {
    }

    @Test
    void findByNomeFantasia() {
    }

    @Test
    void findByRazaoSocialAndNomeFantasia() {
    }
}