package dao.implement;

import java.util.List;

import dao.ISoldbookDAO;
import mapper.SoldbookMapper;
import model.CartModel;
import model.OrderModel;
import model.SoldbookModel;
import model.UserModel;

public class SoldbookDAO extends AbstractDAO<SoldbookModel> implements ISoldbookDAO {

	@Override
	public List<SoldbookModel> findAll() {
		String sql = "select * from soldbooks";
		return query(sql, new SoldbookMapper());
	}

	@Override
	public List<SoldbookModel> findSoldbookByCart(CartModel cart) {
		String sql = "select * from soldbooks where cartID=?";
		return query(sql, new SoldbookMapper(), cart.getId());
	}

	@Override
	public List<SoldbookModel> findSoldbookByOrder(OrderModel order) {
		String sql = "select * from soldbooks where orderID=?";
		return query(sql, new SoldbookMapper(), order.getId());
	}

	@Override
	public List<SoldbookModel> findSoldbookByUser(UserModel user) {
		String sql = "select * from soldbooks where userID=?";
		return query(sql, new SoldbookMapper(), user.getId());
	}

	@Override
	public void insert(SoldbookModel soldbook) {
		String sql = "insert into soldbooks(bookID,quantity,price,userID,orderID,cartID) values(?,?,?,?,?,?)";
		insert(sql, soldbook.getBookID(), soldbook.getQuantity(), soldbook.getPrice(), soldbook.getUserID(),
				soldbook.getOrderID(), soldbook.getCartID());
	}

}
