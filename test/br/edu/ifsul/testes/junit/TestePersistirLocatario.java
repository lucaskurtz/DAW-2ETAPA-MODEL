package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.Locatario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirLocatario {
    
    EntityManager em;

    public TestePersistirLocatario() {
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
            Locatario obj = new Locatario();
            obj.setNome("Bruno");
            obj.setCpf("025.175.320-44");
            obj.setTelefone("(54)99253-3633");
            obj.setEmail("bruno.aguiarsouza@gmail.com");
            obj.setRenda(900.00);
            obj.setLocalTrabalho("Teste");
            obj.setTelefoneTrabalho("(54)99253-3633");
            
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