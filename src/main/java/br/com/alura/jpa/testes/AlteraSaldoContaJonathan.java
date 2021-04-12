package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaJonathan {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        Conta contaJonathan = em.find(Conta.class, 3L);
        
        em.getTransaction().begin();
        contaJonathan.setTitular("Matheus");
        em.getTransaction().commit();
	}
}