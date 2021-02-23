package dao;

import java.util.List;

import model.AddressModel;

public interface IAddressDAO {
	List<AddressModel> findByUserID(long id);
	boolean insert(AddressModel bookModel);
}
