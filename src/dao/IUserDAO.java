package dao;

import java.util.List;

import model.UserModel;

public interface IUserDAO {
	void delele(Long id);
	boolean update(UserModel usermodel);
	boolean checkLogin(UserModel usermodel);
	boolean insert(UserModel usermodel);
	List<UserModel> findAll();
	List<UserModel> findUserById(long id);
}
