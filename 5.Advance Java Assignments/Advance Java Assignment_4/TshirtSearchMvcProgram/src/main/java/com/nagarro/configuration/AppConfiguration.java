package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;

import com.nagarro.dao.TshirtDao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoImplementation.TshirtDaoImp;
import com.nagarro.daoImplementation.UserDaoImp;
import com.nagarro.service.ReadFilesService;
import com.nagarro.serviceImplementation.ReadFilesServiceImpl;
import com.nagarro.serviceImplementation.TshirtSearchServiceImpl;
import com.nagarro.serviceImplementation.UserServiceImpl;

/**
 * 
 * Creating Beans for classes.
 *
 */
public class AppConfiguration {

	/**
	 * Creating UserDao Class Bean using Bean annotation.
	 * 
	 * @return UserDaoImp class object.
	 */
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}

	/**
	 * Creating UserServiceImpl Class Bean using Bean annotation.
	 * 
	 * @return UserServiceImpl class object.
	 */
	@Bean
	public UserServiceImpl getUserService() {
		return new UserServiceImpl();
	}

	/**
	 * Creating TshirtDao Class Bean using Bean annotation.
	 * 
	 * @return TshirtDaoImp class object.
	 */
	@Bean
	public TshirtDao getTshirtDao() {
		return new TshirtDaoImp();
	}

	/**
	 * Creating TshirtSearchServiceImpl Class Bean using Bean annotation.
	 * 
	 * @return TshirtSearchServiceImpl class object.
	 */
	@Bean
	public TshirtSearchServiceImpl getTshirtSearchService() {
		return new TshirtSearchServiceImpl();
	}

	/**
	 * Creating ReadFilesService Class Bean using Bean annotation.
	 * 
	 * @return ReadFilesServiceImpl class object.
	 */
	@Bean
	public ReadFilesService readDirectory() {
		return new ReadFilesServiceImpl();
	}
}