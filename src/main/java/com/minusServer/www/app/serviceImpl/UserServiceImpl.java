package com.minusServer.www.app.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.UserRepository;
import com.minusServer.www.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		byte[] salt = null;
		byte[] password = null;
		String pass = new String(user.getPassword());
		try {
			salt = generateSalt();
			user.setSalt(salt);
			password = hashPassword(pass, salt);
			user.setPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void delete(User u) {
		userRepository.delete(u);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return salt;
	}

	@Override
	public byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String algorithm = "PBKDF2WithHmacSHA1";
		int derivedKeyLength = 160;
		int iterations = 1000;

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

		return f.generateSecret(spec).getEncoded();
	}

	@Override
	public boolean autenticate(String loginPassword, byte[] databasePassword, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] hashedAttemptedPassword = hashPassword(loginPassword, salt);

		return Arrays.equals(hashedAttemptedPassword, databasePassword);
	}

	@Override
	public User login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		User user = userRepository.findByUsername(username);
		
		if(autenticate(password, user.getPassword(), user.getSalt())){
			return user;
		} else {
			return null;
		}
	}



}
