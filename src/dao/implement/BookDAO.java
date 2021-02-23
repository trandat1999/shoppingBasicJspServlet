package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IBookDAO;
import mapper.BookMapper;
import model.BookModel;

public class BookDAO extends AbstractDAO<BookModel> implements IBookDAO{

	@Override
	public void delete(long id) {
		String sql = "delete from books where id = ?";
		update(sql, id);
	}

	@Override
	public boolean insert(BookModel bookModel) {
		String sql = "select * from books where name=? and author=?";
		String sql1 = "insert into books(name,category,author,price) values(?,?,?,?)";
		boolean tmp = true;
		List<BookModel> userlist = query(sql, new BookMapper(), bookModel.getName(), bookModel.getAuthor());
		if (!userlist.isEmpty()) {
			tmp = false;
		} else {
			insert(sql1, bookModel.getName(), bookModel.getCategory(), bookModel.getAuthor(), bookModel.getPrice());
			tmp = true;
		}
		return tmp;
	}

	@Override
	public boolean update(BookModel bookModel) {
		String sql = "select * from books where name=? and author=? and not id=?";
		String sql1="update books set name=?, category=?, author=?, price=? where id=?";
		boolean tmp = true;
		List<BookModel> booklist= query(sql, new BookMapper(), bookModel.getName(),bookModel.getAuthor(),bookModel.getId());
		if(!booklist.isEmpty()) {
			tmp=false;
		}else {
			update(sql1, bookModel.getName(),bookModel.getCategory(),bookModel.getAuthor(),bookModel.getPrice(),bookModel.getId());
			tmp=true;
		}
		return tmp;
	}

	@Override
	public List<BookModel> findAll() {
		String sql = "select * from books";
		return query(sql, new BookMapper());
	}

	@Override
	public List<BookModel> findBookById(long id) {
		String sql = "select * from books where id=?";
		return query(sql, new BookMapper(),id);
	}

	@Override
	public List<BookModel> findBookByName(String name) {
		String sql = "select * from books where name like ?";
		return query(sql, new BookMapper(),name);
	}

	@Override
	public List<BookModel> findBookByAuthor(String author) {
		String sql = "select * from books where author like ?";
		return query(sql, new BookMapper(),author);
	}

	@Override
	public List<BookModel> findBookByCategory(String category) {
		String sql = "select * from books where category like ?";
		return query(sql, new BookMapper(),category);
	}

	@Override
	public List<String> findAllCategory() {
		String sql="select distinct category from books";
		List<String> results = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				results.add(rs.getString("category"));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

}
