package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.SoldbookModel;

public class SoldbookMapper implements RowMapper<SoldbookModel> {

	@Override
	public SoldbookModel mapRow(ResultSet result) {
		try {
			SoldbookModel soldbook = new SoldbookModel(result.getLong("id"), result.getLong("bookID"),
					result.getInt("quantity"), result.getFloat("price"), result.getLong("userID"),
					result.getLong("orderID"), result.getLong("cartID"));
			return soldbook;
		} catch (SQLException e) {
			return null;
		}
	}

}
