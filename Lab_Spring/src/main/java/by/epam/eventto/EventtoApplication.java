package by.epam.eventto;

import by.epam.eventto.collection.Gender;
import by.epam.eventto.dao.UserDao;
import by.epam.eventto.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class EventtoApplication implements CommandLineRunner {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(EventtoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");

		startCustomerApp();

	}

	// Tested with H2 database
	void startCustomerApp() {
		User user = new User("dddddd@gmail.com", "Alex", "Shagal", (byte)20, "M", 150);
		User user1 = userDao.get("example1@gmail.com");
		user1.setRating(230);
		user1.setGender("M");
		//userDao.delete("dddddd@gmail.com");
		log.info( user1 + " read!");
		//userDao.create(user);
		//test
		//List<User> users = userDao.getAll();
		//users.forEach(u -> log.info(u));
	}
}
