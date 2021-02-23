package dao;

import java.util.List;

import model.BookModel;

public interface IBookDAO {
	void delete(long id);
	boolean insert(BookModel bookModel);
	boolean update(BookModel bookModel);
	List<BookModel> findAll();
	List<BookModel> findBookById(long id);
	List<BookModel> findBookByName(String name);
	List<BookModel> findBookByAuthor(String name);
	List<BookModel> findBookByCategory(String category);
	List<String> findAllCategory();
}
