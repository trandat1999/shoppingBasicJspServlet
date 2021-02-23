package dao.implement;

import java.util.List;

import dao.IOrderDAO;
import model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO{

	@Override
	public List<OrderModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> findOrderByUserID(long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> findOrderByAddressID(long addressID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(OrderModel order) {
		String sql="INSERT INTO orders (total, orderDate, userID, shipID, cartID, payID) VALUES (?,?,?,?,?,?)";
		long id=insert(sql, order.getTotal(),order.getOrderDate(),order.getUserID(),order.getShipID(), order.getCartID(), order.getPayID());
		order.setId(id);
	}

}
