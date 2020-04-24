package by.epam.eventto;

import by.epam.eventto.collection.Gender;
import by.epam.eventto.dao.*;
import by.epam.eventto.entity.*;
import by.epam.eventto.entity.Event;
import by.epam.eventto.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EventtoApplication implements CommandLineRunner {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserDao userDao;
	@Autowired
	EventDao eventDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	MembersDao memDao;
	@Autowired
	UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(EventtoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

//	@Override
//	public void run(String... args) {
//
//		log.info("StartApplication...");
//
//		startCustomerApp();
//
//	}
//
//	// Tested with H2 database
//	void startCustomerApp() {
//		//User user = new User("dddddd@gmail.com", "Alex", "Shagal", (byte)20, "M", 150);
//		//User user1 = userDao.get("example1@gmail.com");
//		//userDao.delete("dddddd@gmail.com");
//		//log.info( user1 + " read!");
//		//userDao.create(user);
////		List<User> users = userDao.getAll();
////		users.forEach(u -> log.info(u));
////		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
////		Date date = new Date();
////		try {
////			date = ft.parse("2020-05-09");
////		}catch (ParseException e) {
////			log.info(e.getMessage());
////		}
////		Event event = new Event("example1@gmail.com", "uniq_vstrecha", "lalal", date, 1, 15);
////		//eventDao.create(event);
////		eventDao.delete(3L);
////		List<Event> events = eventDao.getAll();
////		events.forEach(u -> log.info(u));
//
////		List<User> users = userService.getData();
////		users.forEach(u -> log.info(u));
//		User user = userService.getEntity("fff@gmail.com");
//		userService.delete("fff@gmail.com");
//		log.info(user.toString());
//	}
}
