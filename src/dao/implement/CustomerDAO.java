package dao.implement;

import java.util.List;

import dao.ICustomerDAO;
import mapper.CustomerMapper;
import model.CustomerModel;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO{

	@Override
	public List<CustomerModel> findByUserID(long id) {
		String sql="select * from customers where userID=?";
		return query(sql, new CustomerMapper(), id);
	}

	@Override
	public void insert(CustomerModel customer) {
		String sql="insert into customers(name,userID,addressID) values(?,?,?)";
		long id=insert(sql, customer.getName(), customer.getUserID(), customer.getAddressID());
		customer.setId(id);
	}

}
