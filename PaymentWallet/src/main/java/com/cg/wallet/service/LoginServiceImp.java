package com.cg.wallet.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exceptions.LoginException;
import com.cg.wallet.util.WalletConstants;

@Service
public class LoginServiceImp implements LoginService{

	@Autowired
	private IWalletDao dao;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
	
	
	/*******************************************
	 * 
	 * @author 		: Sai Sumanth
	 * Method		: doLogin
     *Description	: This method login the user for the given details
	 * @param   	: userId 
	 * @param		: password
	 * @returns     : WalletAccount
	 * @throws		: LoginException if the userId is not there in database or if password doesnot match
     *                      	 
	 ********************************************/
	@Override
	public WalletAccount doLogin(String userId, String password)throws LoginException {
		WalletAccount user = dao.getWalletAccount(userId);
		logger.debug("doing login process");
		
		if (user != null && user.getPassword().contentEquals(password)){
			logger.info("User Authenticated for " + userId);
			return user;
		}
		throw new LoginException("You are not authenticated and authorized, Please Login");
	}
	
	/*******************************************
	 * 
	 * @author 		: Sai Sumanth
	 * Method		: encryptUser
     * Description	: This method encrypts the phonenumber, username and role into a string seperated by -
	 * @param   	: WalletAccount
	 * @returns     : String
	 * 
	 ********************************************/
	@Override
	public String encryptUser(WalletAccount user) {
		return encryptString(user.getPhoneNo())+"-" +encryptString(user.getUserName())+"-"
		      +encryptString(user.getRole());
	}
	
	
	/*******************************************
	 * 
	 * @author 		: Sai Sumanth
	 * Method		: encryptString
     * Description	: This method encrypts the given string by adding the a literal 
	 * @param   	: string
	 * @returns     : String
	 *                    	 
	 ********************************************/
	
	public String encryptString(String string) {
		char[] arr = string.toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		int character ;
		for (int idx=0; idx < arr.length; ++idx) {
			character = arr[idx]+WalletConstants.THREE;
			stringBuffer.append((char)character);
		}
		return stringBuffer.toString();
	}

	
	/*******************************************
	 * 
	 * @author 		: Sai Sumanth
	 * Method		: decryptString
     * Description	: This method decrypt the given string by subtracting literal from the string 
	 * @param   	: string  
	 * @returns     : String
	 *                      	 
	 ********************************************/
	
	public String decryptString(String string) {
		char[] arr = string.toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-WalletConstants.THREE;
			stringBuffer.append((char)ch);
		}
		return stringBuffer.toString();
	}
}
