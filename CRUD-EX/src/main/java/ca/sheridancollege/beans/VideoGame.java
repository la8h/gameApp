package ca.sheridancollege.beans;
 
//import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity 
public class VideoGame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int isbn;
	private String name;
	private double price;
	private String producer;
	private String category;
	
	 
	public VideoGame(int isbn, String name, double price, String producer) {
		this.isbn= isbn;
		this.name=name;
		this.price=price;
		this.producer=producer;
	}
	@Transient 
	private String[] categories = { "RPG", "Racing", "Action", "Strategy", "Horror"};

	
}
