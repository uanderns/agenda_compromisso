package br.com.cotiinformatica.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //classe de configura��o do Spring
@EnableJpaRepositories(basePackages = { "br.com.cotiinformatica" })
@EnableTransactionManagement //Habilitar o uso de transa��es no banco de dados
public class JpaConfiguration {

	/*
	 * M�todo para configurar a conex�o com o banco de dados
	 * mapeada no arquivo /META-INF/persistence.xml 
	 */
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("conexao_mysql");
		
		return factoryBean;
	}
	
	/*
	 * M�todo para configurar o gerenciamento de transa��es do projeto no banco de dados
	 * @EnableTransactionManagement -> habilita o controle de transa��es e exige a configura��o abaixo
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		
		return transactionManager;
	}
	
}







