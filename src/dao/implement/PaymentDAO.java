package dao.implement;

import java.util.List;

import dao.IPaymentDAO;
import mapper.PaymentMapper;
import model.PaymentModel;

public class PaymentDAO extends AbstractDAO<PaymentModel> implements IPaymentDAO{

	@Override
	public List<PaymentModel> findAll() {
		String sql="select * from payment";
		return query(sql, new PaymentMapper());
	}

	@Override
	public List<PaymentModel> findPaymentByOrderID(long orderID) {
		String sql="select * from payment where id=?";
		return query(sql, new PaymentMapper(), orderID);
	}

	@Override
	public void insert(PaymentModel payment) {
		String sql="insert into payment(paid,details,paymethod) values(?,?,?)";
		payment.setId(insert(sql, payment.getPaid(), payment.getDetails(), payment.getPaymethod()));
		
	}

}
