package dao;

import java.util.List;

import model.CustomerModel;

public interface ICustomerDAO {
	List<CustomerModel> findByUserID(long id);
	void insert(CustomerModel customer);
}
