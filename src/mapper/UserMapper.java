package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet result) {
		try {
			UserModel user = new UserModel(result.getLong("id"), result.getString("username"),
					result.getString("password"), result.getString("email"), result.getString("position"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
