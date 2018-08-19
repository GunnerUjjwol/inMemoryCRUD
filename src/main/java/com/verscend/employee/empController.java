package com.verscend.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class empController {

	public List<Employee> empList = new ArrayList<>();
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome";
	}

	@GetMapping(value = "showForm")
	public String showForm() {

		return "empForm";
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		empList.add(emp);
		return new ModelAndView("empView", "empList", empList);
	}

	@GetMapping("empView")
	public String viewEmp(Model m) {

		m.addAttribute("empList", empList);
		return "empView";

	}

	@RequestMapping("empUpdate")
	public String empUpdate(@RequestParam("id") int id, Model m) {
		m.addAttribute("emp", empList.get(id - 1));

		return "empUpdate";

	}

	@RequestMapping("saveUpdate")
	public String saveUpdate(@ModelAttribute("emp") Employee emp, Model m) {

		empList.set(emp.getId() - 1, emp);
		m.addAttribute("empList", empList);
		return "empView";

	}

	@RequestMapping("empDelete")
	public String empDelete(@RequestParam("id") int id, Model m) {
		empList.remove(id - 1);
		m.addAttribute("empList", empList);
		return "empView";
	}

	@ResponseBody
	@RequestMapping("empJson")
	public List<Employee> empJson()
	{
		return empList;
	}
	
}
