package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CustomerModel;

public class CustomerMapper implements RowMapper<CustomerModel> {

	@Override
	public CustomerModel mapRow(ResultSet result) {
		try {
			CustomerModel customer = new CustomerModel(result.getLong("id"), result.getString("name"),
					result.getLong("userID"), result.getLong("addressID"));
			return customer;
		} catch (SQLException e) {
			return null;
		}
	}

}
