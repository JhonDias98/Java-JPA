package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		//Transient - está na memoria, mas não no Managed
		Conta conta = new Conta();
		conta.setTitular("Robson");
		conta.setAgencia(1234);
		conta.setNumero(123654);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
		
        em.getTransaction().begin();
        
        //Transient -> Maanged - pega a conta e faz a sicronização
        em.persist(conta);
        
        //Managed -> Removed - remove do banco de dados
        em.remove(conta);
        
        em.getTransaction().commit();
	}
}
