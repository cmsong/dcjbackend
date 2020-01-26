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
import com.revature.models.Users_Games;
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
	
//	@CrossOrigin(origins="*")
//	@GetMapping(value="/users/{username}/{password}")
//	public Users getUserByUsernameAndPassword(@PathVariable("username")String username,@PathVariable("password")String password) {
//		return us.getUserByUsernameAndPassword(username, password);
//	}
	
	@CrossOrigin(origins="*")
    @PostMapping(value="/users/login", consumes="application/json")
    public Users getUsersByUsernameAndPassword(@RequestBody Users users){
        String username= users.getUsername();
        String password= users.getPassword();
        return us.getUserByUsernameAndPassword(username,password);
    }
	
	@CrossOrigin(origins="*")
    @PutMapping(value="/users/games", consumes="application/json")
    public Users updateUsersGames(@RequestBody Users_Games ug) {
        System.out.println("got here successfully");
        Users u = us.getUsersByUsername(ug.getUsername()).get(0);
        System.out.println(u);
        List<Games> lg = us.getUsersByUsername(ug.getUsername()).get(0).getUg();
        lg.add(gs.getGameById(ug.getG_id()));
        u.setUg(lg);
        return us.updateUsers(u);
    }
	

	@CrossOrigin(origins="*")
    @PutMapping(value="/users/premium", consumes="application/json")
    public Users updateUsersBilling(@RequestBody Users change) {
        int month = java.time.LocalDate.now().getMonthValue();
        int day = java.time.LocalDate.now().getDayOfMonth();
        int year = java.time.LocalDate.now().getYear() + 1;
        String membership = month + "_" + day + "_" + year;
        change.getBilling().setMembership_date(membership);
        int b_id = change.getBilling().getB_id();
        Billing b = bs.getBillingById(b_id);
        b.setMembership_date(membership);
        bs.updateBilling(b);
        return us.updateUsers(change);
    }
}