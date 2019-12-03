package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;


import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirUnidadeCondominial {
    
    EntityManager em;

    public TestePersistirUnidadeCondominial() {
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
            UnidadeCondominial obj = new UnidadeCondominial();
            obj.setNumero("145");
            obj.setDescricao("teste teste teste teste teste teste");
            obj.setArea(125.20);
            obj.setNumeroQuarto(2);
            obj.setCondominio(em.find(Condominio.class, 1));
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