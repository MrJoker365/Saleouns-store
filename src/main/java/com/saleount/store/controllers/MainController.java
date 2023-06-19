package com.saleount.store.controllers;

import com.saleount.store.models.Post;
import com.saleount.store.models.Users;
import com.saleount.store.repo.PostRepository;
import com.saleount.store.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		if (principal == null) {
			model.addAttribute("name", "Ім'я відсутнє"); // тимчасово
			System.out.println("нуль");
		}else {
			model.addAttribute("name", principal.getName());
			System.out.println(principal.getName());
		}
		return "index";
	}

	@GetMapping("/log_in")
	public String log_in(Model model, Principal principal) {
		if (principal == null) {
			return "sign_in";
		}else {
			return "logout";
		}
	}


	// List

	@Autowired
	private PostRepository postRepository;

//	@Autowired
//	private UsersRepository usersRepository;


	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		return "list";
	}




	@GetMapping("/create_an_ad")
	public String create_an_ad(Model model) {

		model.addAttribute("newPost", new Post());

		return "create_an_ad";
	}

	@PostMapping("/create_an_ad")
	public String create_an_ad_Post(@ModelAttribute("newPost") Post post, Principal principal) {

		post.setUsername(principal.getName());
		postRepository.save(post);

		return "redirect:/list?newPost";
	}



	// Log in


	// Sign up

//	@GetMapping("/sign_up")
//	public String sign_up(Model model) {
//
//		return "sign_up";
//	}
//
//	@PostMapping("/sign_up")
//	public String post_Sign_up (@RequestParam String username, @RequestParam String email,
//								@RequestParam String password, Model model){
//
//		Users users = new Users(username,email,password );
//		usersRepository.save(users);
//		return "redirect:/";
//	}


}
