package ca.sheridancollege.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.VideoGame;

@Repository
public interface VideoGameRepository extends CrudRepository<VideoGame, Integer> {

	public List<VideoGame> findByIsbn(int isbn);
	//public List<VideoGame> findByPriceLessThan(double price);
	//public List<VideoGame> findByPriceLessThanAndGenre(double price, String genre);
	public List<VideoGame> findByOrderByNameAsc();
}
