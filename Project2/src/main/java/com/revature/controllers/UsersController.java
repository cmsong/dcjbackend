package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Billing;
import com.revature.models.Games;
import com.revature.models.Users;
import com.revature.services.BillingService;
import com.revature.services.GamesService;
import com.revature.services.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService us;
	
	@Autowired
	GamesService gs;
	
	@Autowired
	BillingService bs;
	@CrossOrigin(origins="*")
    @PostMapping(value="/users", consumes="application/json")
    public Users createUsers(@RequestBody Users users) {
        System.out.println(users);
        Billing b = new Billing("Not Premium");
        bs.createBilling(b);
        users.setBilling(b);
        return us.createUsers(users);
    }
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/users/search")
	public List<Users> getUsersByUsername(@RequestParam(required=false)String username){
		return us.getUsersByUsername(username);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/users")
	public List<Users> allUsers(){
		return us.allUsers();
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(value="/users", consumes="application/json")
	public Users updateUsers(@RequestBody Users change) {
		return us.updateUsers(change);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/users/{username}/{password}")
	public Users getUserByUsernameAndPassword(@PathVariable("username")String username,@PathVariable("password")String password) {
		return us.getUserByUsernameAndPassword(username, password);
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(value="/users/games", consumes="application/json")
	public Users updateUsersGames(@RequestParam String username, @RequestParam int g_id) {
		Users u = us.getUsersByUsername(username).get(0);
		System.out.println(u);
		List<Games> lg = us.getUsersByUsername(username).get(0).getUg();
		lg.add(gs.getGameById(g_id));
		u.setUg(lg);
		return us.updateUsers(u);
	}
}