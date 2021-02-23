package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookModel;

public class BookMapper implements RowMapper<BookModel> {

	@Override
	public BookModel mapRow(ResultSet result) {
		try {
			BookModel book = new BookModel(result.getLong("id"), result.getString("name"), result.getString("category"),
					result.getString("author"), result.getFloat("price"));
			return book;
		} catch (SQLException e) {
			return null;
		}
	}

}
