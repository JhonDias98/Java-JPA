package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Danilo");
		conta.setNumero(1425);
		conta.setAgencia(658654);
		conta.setSaldo(1000.0);

		//Aparti daqui a conta passa a está como Managed
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		//Após fecahr a transação, passa a ser Detached
		
		//Para voltar a ser a Managed é necessario iniciar outro EntityManager
		EntityManager em2 = emf.createEntityManager();
		conta.setSaldo(450.0);
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}