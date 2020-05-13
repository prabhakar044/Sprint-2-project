package com.cg.wallet.service;


import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exceptions.LoginException;

public interface LoginService {
    public WalletAccount doLogin(String userId, String password)throws LoginException;
    public String encryptUser(WalletAccount user);
    
}
