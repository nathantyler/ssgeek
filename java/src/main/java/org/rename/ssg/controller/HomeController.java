package org.rename.ssg.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.rename.ssg.model.forum.ForumDao;
import org.rename.ssg.model.forum.ForumPost;
import org.rename.ssg.model.store.Product;
import org.rename.ssg.model.store.ProductDao;
import org.rename.ssg.model.store.ShoppingCart;
import org.rename.ssg.planet.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	private static Map<String, Double> methodsAndSpeed;

	@Autowired
	private ForumDao dao;
	
	@Autowired
	private ProductDao pDao;

	static {
		methodsAndSpeed = new HashMap<>();
		methodsAndSpeed.put("walking", Double.valueOf(3));
		methodsAndSpeed.put("car", Double.valueOf(100));
		methodsAndSpeed.put("bullet train", Double.valueOf(200));
		methodsAndSpeed.put("boeing 747", Double.valueOf(570));
		methodsAndSpeed.put("concorde", Double.valueOf(1350));
	}

	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}

	@RequestMapping("/alienWeightForm")
	public String displayAlienWeightForm() {
		return "alienWeightForm";
	}

	@RequestMapping("/alienAgeForm")
	public String displayAgeWeightForm() {
		return "alienAgeForm";
	}

	@RequestMapping("/driveTimeForm")
	public String displayDriveTimeForm() {
		return "driveTimeForm";
	}

	@RequestMapping("/alienWeight")
	public String displayAlienWeight(@RequestParam String name, @RequestParam(required = false) Double weight,
			ModelMap modelHolder) {
		double weightParam;
		if (weight == null)
			weightParam = 0;
		else
			weightParam = weight.doubleValue();
		Planet planet = new Planet(name.toLowerCase());
		modelHolder.put("planet", planet);
		modelHolder.put("yourWeight", Double.valueOf(weightParam));
		modelHolder.put("planetWeight", Double.valueOf(planet.getWeight(weightParam)));
		return "alienWeight";
	}

	@RequestMapping("/alienAge")
	public String displayAgeWeight(@RequestParam String name, @RequestParam(required = false) Double age,
			ModelMap modelHolder) {
		double ageParam;
		if (age == null)
			ageParam = 0;
		else
			ageParam = age.doubleValue();
		Planet planet = new Planet(name.toLowerCase());
		modelHolder.put("planet", planet);
		modelHolder.put("currentAge", age);
		modelHolder.put("planetAge", Double.valueOf(planet.getAge(ageParam)));
		return "alienAge";

	}

	@RequestMapping("/driveTime")
	public String displayDriveTime(@RequestParam String name, @RequestParam String method,
			@RequestParam(required = false) Double age, ModelMap modelHolder) {
		double ageParam;
		if (age == null)
			ageParam = 0;
		else
			ageParam = age.doubleValue();
		Planet planet = new Planet(name.toLowerCase());
		modelHolder.put("planet", planet);
		modelHolder.put("travelTime", Double.valueOf(planet.getDriveTime(methodsAndSpeed.get(method).doubleValue())));
		modelHolder.put("currentAge",
				Double.valueOf((ageParam + planet.getDriveTime(methodsAndSpeed.get(method).doubleValue()))));
		return "driveTime";
	}

	@RequestMapping("/forum")
	public String displayForumForm(Model model) {
		if (!model.containsAttribute("forumPost"))
			model.addAttribute("forumPost", new ForumPost());

		return "forum";
	}

	@RequestMapping(path = "/submitPost", method = RequestMethod.POST)
	public String submitPost(@Valid @ModelAttribute ForumPost forumPost, BindingResult result, RedirectAttributes ra) {
		if (result.hasFieldErrors()) {
			ra.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "forumPost", result);
			ra.addFlashAttribute("forumPost", forumPost);
			return "redirect:/forum";
		}

		forumPost.setDatePosted(LocalDateTime.now());
		dao.save(forumPost);
		ra.addFlashAttribute("successfulPost", "Post successfully created");

		return "redirect:/displayForum";

	}

	@RequestMapping("/displayForum")
	public String displayForumPosts(ModelMap modelMap) {
		List<?> posts = dao.getAllPosts();
		modelMap.addAttribute("posts", posts);

		return "displayForum";
	}
	
	@RequestMapping("/store")
	public String displayStore(ModelMap modelMap) {
		modelMap.addAttribute("products", pDao.getAllProducts());
		return "store";
	}
	
	@RequestMapping("/productDetails")
	public String displayProductDetail(@RequestParam(required = false) Long id, ModelMap modelMap) {
		modelMap.addAttribute("product", pDao.getProductById(id));
		return "productDetail";
	}
	
	@RequestMapping("/shoppingcart")
	public String displayShoppingCart() {
		
		return "displayShoppingCart";
	}
	
	@RequestMapping(path = "/addtocart", method = RequestMethod.POST)
	public String addToShoppingCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ShoppingCart cart;
		if (session.getAttribute("cart") == null) { 
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		} else
			cart = (ShoppingCart) session.getAttribute("cart");
		String quantity = request.getParameter("quantity");
		String productId = request.getParameter("productId");
		Product product = pDao.getProductById(new Long(productId));
		cart.addToCart(product, new Integer(quantity));
		
		return "redirect:/shoppingcart";
	}
}
