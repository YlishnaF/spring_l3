package com.fadeeva.spring_l3;

import com.fadeeva.spring_l3.model.BookEntity;
import com.fadeeva.spring_l3.repository.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringL3Application {

	public static void main(String[] args) {

 SpringApplication.run(SpringL3Application.class, args);
//		BooksRepository booksRepository = context.getBean(BooksRepository.class);
//		BookEntity book = new BookEntity();
//		book.setId(1L);
//		book.setName("война и мир");
//		booksRepository.save(book);
//		BookEntity foundBooks = booksRepository.findById(1L);
//		foundBooks.ifPresent(it-> System.out.println(it));
//		Iterable<BookEntity> entities = booksRepository.findAll();
//		for (BookEntity i:entities){
//			System.out.println(i.getName());

		}
//		DataSource dataSource = context.getBean(DataSource.class);
//		try(Connection connection = dataSource.getConnection()) {
//			try (Statement statement = connection.createStatement()){
//				statement.execute("create table if not exists books(id bigint, name varchar(512))");
//
//			}
//			try (Statement statement = connection.createStatement()){
//				statement.execute("insert into users(name) values('война и мир')");
//				statement.execute("insert into users(name) values('этот безумный мир')");
//				statement.execute("insert into users(name) values('девять')");
//
//			}
//			try  (Statement statement = connection.createStatement()){
//				ResultSet resultSet = statement.executeQuery("select id, name from users");
//				while (resultSet.next()){
//					System.out.println(resultSet.getInt("id"));
//					System.out.println(resultSet.getString("name"));
//				}
//			}
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
	}


