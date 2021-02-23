package model;

public class BookModel {
	private long id;
	private String name;
	private String category;
	private String author;
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookModel(long id, String name, String category, String author, float price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.author = author;
		this.price=price;
	}

	public BookModel(String name, String category, String author, float price) {
		super();
		this.name = name;
		this.category = category;
		this.author = author;
		this.price= price;
	}

	public BookModel() {
		super();
	}

}
