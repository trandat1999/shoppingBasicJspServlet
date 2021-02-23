package dao.implement;

import java.util.List;

import dao.IAddressDAO;
import model.AddressModel;

public class AddressDAO extends AbstractDAO<AddressModel> implements IAddressDAO{

	@Override
	public List<AddressModel> findByUserID(long id) {
		return null;
	}

	@Override
	public boolean insert(AddressModel bookModel) {
		String sql="insert into address(country,city,streets) values(?,?,?)";
		long id=insert(sql, bookModel.getCountry(),bookModel.getCity(), bookModel.getStreets());
		bookModel.setId(id);
		return true;
	}
	

}
