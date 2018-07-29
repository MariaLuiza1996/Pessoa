/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoa.teste.junit;

import com.pessoa.jpa.EntityManagerUtil;
import com.pessoa.lib.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maria Luiza
 */
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    
    public TestePersistirPessoaFisica() {
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
    public void test(){
        boolean exception = false;
        try{
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("07989487609");
            pf.setEmail("marialuiza2015@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Maria Luiza da Silva Araujo");
            pf.setNomeUsuario("maria.araujo");
            pf.setRg("15118657");
            pf.setSenha("usuario");
            pf.setTelefone("(31)98567-1076");
            
           
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
