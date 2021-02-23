package dao;

import java.util.List;

import model.OrderModel;

public interface IOrderDAO {
	List<OrderModel> findAll();
	List<OrderModel> findOrderByUserID(long userID);
	List<OrderModel> findOrderByAddressID(long addressID);
	void insert(OrderModel order);
}
