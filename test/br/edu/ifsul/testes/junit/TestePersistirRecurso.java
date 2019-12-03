package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Recurso;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirRecurso {
    
    EntityManager em;

    public TestePersistirRecurso() {
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
            Recurso obj = new Recurso();
            obj.setDescricao("Teste 2");
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