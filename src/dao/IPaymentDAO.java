package dao;

import java.util.List;

import model.PaymentModel;

public interface IPaymentDAO {
	List<PaymentModel> findAll();
	List<PaymentModel> findPaymentByOrderID(long orderID);
	void insert(PaymentModel payment);
}
