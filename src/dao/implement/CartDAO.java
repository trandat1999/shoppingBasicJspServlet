package dao.implement;

import dao.ICartDAO;
import model.CartModel;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO{

	@Override
	public void insert(CartModel cart) {
		String sql="insert into carts(created,userID) values(?,?)";
		long id=insert(sql, cart.getCreated(), cart.getUserID());
		cart.setId(id);
	}

}
