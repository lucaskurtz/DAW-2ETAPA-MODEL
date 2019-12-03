package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;

import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirAluguel {
    
    EntityManager em;

    public TestePersistirAluguel() {
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
            Aluguel obj = new Aluguel();
            obj.setValor(1000.0);
            obj.setInicioContrato(Calendar.getInstance());
            obj.setFimContrato(Calendar.getInstance());
            obj.setDiaVencimento(2);
            obj.setLocatario(em.find(Locatario.class, 6));
            obj.setUc(em.find(UnidadeCondominial.class, 6));
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