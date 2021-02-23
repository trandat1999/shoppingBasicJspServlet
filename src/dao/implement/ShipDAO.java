package dao.implement;

import dao.IShipDAO;
import model.ShipModel;

public class ShipDAO extends AbstractDAO<ShipModel> implements IShipDAO {

	@Override
	public void insert(ShipModel shipmodel) {
		String sql="insert into ships(details,date,addressID) values(?,?,?)";
		long id=insert(sql, shipmodel.getDetails(),shipmodel.getDate(),shipmodel.getAddressID());
		shipmodel.setId(id);
	}

}
