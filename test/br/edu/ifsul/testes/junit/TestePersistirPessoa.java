package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirPessoa {
    
    EntityManager em;

    public TestePersistirPessoa() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean erro = false;
        try {
            Pessoa obj = new Pessoa();
            obj.setNome("Teste 3");
            obj.setCpf("032.789.654-09");
            obj.setTelefone("(54)99253-3633");
            obj.setSenha("teste123");
            obj.setEmail("testedd@gmail.com");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            erro = true;
            e.printStackTrace();
        }
        // aqui verifico se o valor do erro continua falso oque indica que o teste passou
        Assert.assertEquals(false, erro);
    }

}