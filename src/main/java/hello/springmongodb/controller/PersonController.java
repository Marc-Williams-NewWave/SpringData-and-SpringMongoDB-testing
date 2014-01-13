package hello.springmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import hello.springmongodb.model.Person;
import hello.springmongodb.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPersonList(ModelMap model){
		model.addAttribute("personList", personService.listPerson());
		return "output";
	}
	
	@RequestMapping(value = "/person/profile", method = RequestMethod.GET)
	public String getPersonBio(Person person, ModelMap model){
		model.addAttribute("person", personService.specificUser(person));
		return "profile";
	}
	
	@RequestMapping(value = "/freshStart", method = RequestMethod.GET)
	public String freshStart(ModelMap model){
		personService.clearList();
		return "output";
	}
	
	
	@RequestMapping(value = "/person/save", method = RequestMethod.POST)
	public View createPerson(@ModelAttribute Person person, ModelMap model){
		if(StringUtils.hasText(person.getId()) /*|| personService.equals(person)*/){
			System.out.println("This user already exits");
			personService.updatePerson(person);
		} else {
			personService.addperson(person);
		}
		return new RedirectView("/HelloSpringWithMongoDB/person");
	}
	
	@RequestMapping(value = "/person/delete", method = RequestMethod.GET)
	public View deletePerson(@ModelAttribute Person person, ModelMap model){
		personService.deletePerson(person);
		return new RedirectView("/HelloSpringWithMongoDB/person");
	}
}
