package ca.sheridancollege.controllers;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.VideoGame;
import ca.sheridancollege.repositories.VideoGameRepository;

@Controller
public class HomeController {
	
	@Autowired
	public VideoGameRepository gameRepo;
	
	@GetMapping("/deletelink/{id}")
	public String deleteGame(@PathVariable int id) {
		gameRepo.deleteById(id);
	//	model.addAttribute("games", gameRepo.findAll());
		//	return "viewGames.html";
		
		//can add this line instead above 2 lines also can delete model 
		return "redirect:/viewGames";		
		
	}
	
	@PostMapping("/editGame")
	public String modifyGame(@ModelAttribute VideoGame videogame) {
		gameRepo.save(videogame);
		return "redirect:/viewGames";
		//return "addGame.html";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("games", new ArrayList<VideoGame>());
		return "search.html";
	}
	
	@GetMapping("/searchIsbn")
	public String searchISBN(@RequestParam int isbn, Model model) {
		model.addAttribute("games", gameRepo.findByIsbn(isbn));
	//	model.addAttribute("games", gameRepo.findByOrderByTitleAsc());
		return "search.html";
	}
	
	
	
	
	@GetMapping("/editlink/{id}")
	public String editGame(@PathVariable int id, Model model) {
	Optional <VideoGame>  game   = gameRepo.findById(id);
	if (game.isPresent()) {
		VideoGame selectedGame = game.get();	
		model.addAttribute("videoGame", selectedGame);
		return "editGame.html";
	}else {
		return "redirect:/viewGames";	
	}
	}
	
	//private List<VideoGame> da = new ArrayList<VideoGame>();
	/*
	@GetMapping("/editLink/{id}")
	public String editLink(Model model, @PathVariable int id){
		if (.findById(id).size()>0) {
			Videogame game = vgRepository.findById(id).get(0);
			model.addAttribute("videogame", game);
			return"editGame.html";
			}else {
				return"redirect:/";
				}
				*/
	
	@GetMapping("/")
    public String goAddGame(Model model) {
	model.addAttribute("videoGame", new VideoGame());
	return "addGame.html";
	}
	
	@GetMapping("/add")
	public String doAddGame(Model model, @ModelAttribute VideoGame videoGame) {
		gameRepo.save(videoGame);
//		da.add(videoGame); //Add the game to your list
		model.addAttribute("videoGame", new VideoGame());
		return "addGame.html";
	}
	
	@GetMapping("/viewGames")
	public String goViewGame(Model model) {
		model.addAttribute("games", gameRepo.findAll());   
	//	model.addAttribute("games", gameRepo.findByOrderByNameAsc());
	//	model.addAttribute("games", da); //Get your list of games
		return "viewGames.html";
	}
	
	
	
	}



