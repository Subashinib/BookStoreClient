package mappers;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import database.BookDetails;

public class BooksMapper {

	// convert Book Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(BookDetails bd) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start().append("id", bd.getBookId())
				.append("surname", bd.getSurname()).append("first_name", bd.getFirstName())
				.append("title", bd.getTitle()).append("price", bd.getPrice()).append("onSale", bd.getOnSale())
				.append("calendar_year", bd.getYear()).append("description", bd.getDescription())
				.append("inventory", bd.getInventory());

		return builder.get();
	}

	// convert DBObject Object to Books
	// take special note of converting ObjectId to String
	public static BookDetails toBook(DBObject doc) {

		BookDetails bd = new BookDetails();
		bd.setBookId((String) doc.get("id"));
		bd.setSurname((String) doc.get("surname"));
		bd.setFirstName((String) doc.get("first_name"));
		bd.setTitle((String) doc.get("title"));
		bd.setPrice(Float.valueOf((String) doc.get("price")));
		bd.setOnSale(Boolean.valueOf((String) doc.get("onSale")));
		bd.setYear(Integer.valueOf((String) doc.get("calendar_year")));
		bd.setDescription((String) doc.get("description"));
		bd.setInventory(Integer.valueOf((String) doc.get("inventory")));
		return bd;
	}
}
