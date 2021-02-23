package dao.implement;

import java.util.List;

import dao.IUserDAO;
import mapper.UserMapper;
import model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public void delele(Long id) {
		String sql = "delete from users where id = ?";
		update(sql, id);
	}

	@Override
	public boolean checkLogin(UserModel usermodel) {
		String sql = "select * from users where username=? and password=?";
		boolean tmp = false;
		List<UserModel> userlist = query(sql, new UserMapper(), usermodel.getUsername(), usermodel.getPassword());
		if (!userlist.isEmpty()) {
			usermodel.setPosition(userlist.get(0).getPosition());
			usermodel.setId(userlist.get(0).getId());
			tmp = true;
		}
		return tmp;
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		return query(sql, new UserMapper());
	}

	@Override
	public boolean insert(UserModel usermodel) {
		String sql = "select * from users where username=? or email=?";
		String sql1 = "insert into users(username,password,email,position) values(?,?,?,?)";
		boolean tmp = true;
		List<UserModel> userlist = query(sql, new UserMapper(), usermodel.getUsername(), usermodel.getEmail());
		if (!userlist.isEmpty()) {
			tmp = false;
		} else {
			long id=insert(sql1, usermodel.getUsername(), usermodel.getPassword(), usermodel.getEmail(), usermodel.getPosition());
			usermodel.setId(id);
			tmp = true;
		}
		return tmp;
	}

	@Override
	public List<UserModel> findUserById(long id) {
		String sql = "select * from users where id=?";
		return query(sql, new UserMapper(), id);
	}

	@Override
	public boolean update(UserModel usermodel) {
		String sql = "select * from users where username=? and email=? and not id=?";
		String sql1 = "update users set username=?, password=?, email=?, position=? where id=?";
		boolean tmp = true;
		List<UserModel> booklist = query(sql, new UserMapper(), usermodel.getUsername(), usermodel.getEmail(),
				usermodel.getId());
		if (!booklist.isEmpty()) {
			tmp = false;
		} else {
			update(sql1,usermodel.getUsername(), usermodel.getPassword(), usermodel.getEmail(),
					usermodel.getPosition(), usermodel.getId());
			tmp = true;
		}
		return tmp;
	}

}
