package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;

import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirMensalidades {
    
    EntityManager em;

    public TestePersistirMensalidades() {
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
            Mensalidades obj = new Mensalidades();
            obj.setValor(1000.0);
            obj.setVencimento(Calendar.getInstance());
            obj.setValorPagamento(1000.0);
            obj.setDataPagamento(Calendar.getInstance());
            obj.setAluguel(em.find(Aluguel.class, 5));
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