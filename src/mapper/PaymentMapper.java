package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.PaymentModel;

public class PaymentMapper implements RowMapper<PaymentModel> {

	@Override
	public PaymentModel mapRow(ResultSet result) {
		try {
			PaymentModel payment = new PaymentModel(result.getLong("id"), result.getDate("paid"),
					 result.getString("details"),result.getString("paymethod"));
			return payment;
		} catch (SQLException e) {
			return null;
		}
	}

}
