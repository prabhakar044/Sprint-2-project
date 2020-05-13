package com.cg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.wallet.web.LoggerInterceptor;
import com.cg.wallet.web.LoginInterceptor;
import com.cg.wallet.entity.WalletAccount;

@SpringBootApplication
public class Sprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}
	
	@Autowired
	public LoginInterceptor loginInterceptor;
	
	@Autowired
	public LoggerInterceptor loggerInterceptor;
	
	@Bean(name="authenticatemap")
	public Map<String, WalletAccount> getAuthenticateMap(){
		return new HashMap<String, WalletAccount>();
	}

}
