package mapper;

import java.sql.ResultSet;

import model.OrderModel;

public class OrderMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet result) {
		try {
			OrderModel order = new OrderModel(result.getLong("id"), result.getFloat("total"),
					result.getDate("orderDate"), result.getLong("userID"), result.getLong("shipID"),
					result.getLong("cartID"), result.getLong("payID"));
			return order;
		} catch (Exception e) {
			return null;
		}
	}

}
