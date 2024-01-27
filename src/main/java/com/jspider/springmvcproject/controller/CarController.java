package com.jspider.springmvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspider.springmvcproject.pojo.AdminPOJO;
import com.jspider.springmvcproject.pojo.CarPOJO;
import com.jspider.springmvcproject.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;

	@GetMapping("/home")
//this anotation is can be used to indicate the controller class is accept the web request that invkoing the get method ba
//based on its url pattern
	public String HomePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";
	}

	@GetMapping("/add")
	public String addPage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Add";
			}

			return "Add";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";

	}

	@PostMapping("/add")
//this annotation it can be used to aindicated the controler class is  accept the request invoking the post methid method
//based on its url pattern
	public String AddCarDetails(@RequestParam String name, @RequestParam String brand, @RequestParam String fuielType,
			@RequestParam long price, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo = service.addCarDetails(name, brand, fuielType, price);
			// success
			if (pojo != null) {
				map.addAttribute("msg", "data inserted succesfully");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				return "Add";
			}
			map.addAttribute("msg", "data not inserted");
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
			return "Add";

		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";
	}

	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (cars != null) {
				map.addAttribute("cars", cars);
			}
			map.addAttribute("car details or record not present");
			return "Remove";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";
	}

	@PostMapping("/remove")
//request param =it can be used to fetach the value of parameter based on itsa name  it present inside the query
	public String removeCarDeatils(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo = service.removeCarDetails(id);
			List<CarPOJO> cars = service.findAllCars();
			if (cars != null) {
				map.addAttribute("msg", "record remove succesgfuuly");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			map.addAttribute("msg", "record does not found");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";
	}

	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();

			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";

	}

	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo = service.searchCarDetails(id);
			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";

			}
			List<CarPOJO> cars = service.findAllCars();

			map.addAttribute("cars", cars);
			map.addAttribute("msg", "record does not found");
			return "Update";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";
	}

	@PostMapping("/updateCar")
	public String UpdateCarDetails(@RequestParam int id, @RequestParam String name, @RequestParam String brand,
			@RequestParam String fuielType, @RequestParam long price, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo = service.updateCarDetails(id, name, brand, fuielType, price);

			if (pojo != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", "data  updated succesfully");
				map.addAttribute("cars", cars);
				return "Update";
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "record not update");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";

	}

	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";

	}

	@PostMapping("/search")
	public String SearchCarDetails(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo = service.searchCarDetails(id);
			// Success
			if (pojo != null) {
				map.addAttribute("car", pojo);
				map.addAttribute("msg", "car data found successfully");
				return "Search";
			}
			// Failure
			map.addAttribute("msg", "car data not found");
			return "Search";
		}
		map.addAttribute("msg", "session is inactive login");
		return "Login";

	}
}

/*
 * @Getmapping this anootion it can be used to indicated the conroller can be
 * accpet the request that invkes the get method based on its url pattern
 * 
 * @postmaping this annotion it can be uesd to indicates the controoler can be
 * accept the request that invokes tthe most method baed on its url pattern
 * 
 * @Autowird theses anntation itv can be used to maked the property or
 * construtor foor the fdependacy inject map it is the implicit object for the
 * modelmap class whic id alread initalixe and ready for the uesd adAttrint()
 * this is non sttaic method which ids prredsnt inside the model map class it is
 * the overloaed method which accept two argument first argument is string
 * consider as the key of the attribute n and second is teh object that consider
 * as the value of the attribute it can be used to send all required attribyte
 * to the view pages and these all required atribute are ad in the view pages
 * using get attribyt method
 * 
 * @session attribut it canb be used to access the attribut for seesion created
 * for the specific object
 * 
 */
