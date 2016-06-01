package br.ufc.quixada.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;

//@ApplicationScoped
public class GeraParametrosDeSistema {
	
	private final String urlConnection = "jdbc:mysql://localhost/jornal";
	private final String user = "root";
	private final String passwd = "root";
	
	public GeraParametrosDeSistema(){}
	
	//@PostConstruct
	private void gerarParametrosBD(@Observes VRaptorInitialized initialized){
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(urlConnection, user, passwd);
			PreparedStatement ps = con.prepareStatement("");
			ps.addBatch("insert into papeis (descricao, nivel) values ('Leitor', 1000)");
			ps.addBatch("insert into papeis (descricao, nivel) values ('Jornalista', 2000)");
			ps.addBatch("insert into papeis (descricao, nivel) values ('Editor', 3000)");
			ps.addBatch("insert into usuarios (nome, email, login, senha) values ('Administrador do Sistema', 'admin@infojornal.com', 'admin', '91b4d142823f7d20c5f08df69122de43f35f057a988d9619f6d3138485c9a203')");
			ps.addBatch("insert into usuarios_papeis values(1,1)");
			ps.addBatch("insert into usuarios_papeis values(1,2)");
			ps.addBatch("insert into usuarios_papeis values(1,3)");
			ps.executeBatch();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO NO SQL: PARAMETROS JA CRIADOS");
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER DE CONEXAO COM BD NAO ENCONTRADO");
		}
	}
}
