package dao;

import java.util.List;

import model.CartModel;
import model.OrderModel;
import model.SoldbookModel;
import model.UserModel;

public interface ISoldbookDAO {
	List<SoldbookModel> findAll();
	List<SoldbookModel> findSoldbookByCart(CartModel cart);
	List<SoldbookModel> findSoldbookByOrder(OrderModel order);
	List<SoldbookModel> findSoldbookByUser(UserModel user);
	void insert(SoldbookModel soldbook);
}
