/**
* HomeController
*
* HomeController controls the layout and workflow of the pages of the webapp.
* All of this logic occurs after the user is logged in
*
* @author  Scott
* @version 0.1
* @since   2023-01-15 
* @status Super Done
*/

package com.scottfarsace.spring.npcgenerator.controllers;

import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.scottfarsace.spring.npcgenerator.models.Age;
import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.ArchetypeAppearance;
import com.scottfarsace.spring.npcgenerator.models.Background;
import com.scottfarsace.spring.npcgenerator.models.BasicNPC;
import com.scottfarsace.spring.npcgenerator.models.FirstName;
import com.scottfarsace.spring.npcgenerator.models.Goal;
import com.scottfarsace.spring.npcgenerator.models.LastName;
import com.scottfarsace.spring.npcgenerator.models.NPC;
import com.scottfarsace.spring.npcgenerator.models.Profession;
import com.scottfarsace.spring.npcgenerator.models.ProfessionAppearance;
import com.scottfarsace.spring.npcgenerator.models.Quirk;
import com.scottfarsace.spring.npcgenerator.models.Race;
import com.scottfarsace.spring.npcgenerator.models.RaceAppearance;
import com.scottfarsace.spring.npcgenerator.models.Sex;


import com.scottfarsace.spring.npcgenerator.services.AgeService;
import com.scottfarsace.spring.npcgenerator.services.ArchetypeService;
import com.scottfarsace.spring.npcgenerator.services.ArchetypeAppearanceService;
import com.scottfarsace.spring.npcgenerator.services.BackgroundService;
import com.scottfarsace.spring.npcgenerator.services.FirstNameService;
import com.scottfarsace.spring.npcgenerator.services.GoalService;
import com.scottfarsace.spring.npcgenerator.services.LastNameService;
import com.scottfarsace.spring.npcgenerator.services.LoginService;
import com.scottfarsace.spring.npcgenerator.services.NPCService;
import com.scottfarsace.spring.npcgenerator.services.ProfessionService;
import com.scottfarsace.spring.npcgenerator.services.ProfessionAppearanceService;
import com.scottfarsace.spring.npcgenerator.services.QuirkService;
import com.scottfarsace.spring.npcgenerator.services.RaceService;
import com.scottfarsace.spring.npcgenerator.services.RaceAppearanceService;

@Controller
public class HomeController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private NPCService npcService;

	@Autowired
	private FirstNameService firstNameService;

	@Autowired
	private LastNameService lastNameService;

	@Autowired
	private AgeService ageService;

	@Autowired
	private RaceService raceService;
	
	@Autowired
	private ArchetypeService archetypeService;
	
	@Autowired
	private ProfessionService professionService;

	@Autowired
	private BackgroundService backgroundService;
	
	@Autowired
	private QuirkService quirkService;

	@Autowired
	private ArchetypeAppearanceService archetypeAppearanceService;

	@Autowired
	private ProfessionAppearanceService professionAppearanceService;

	@Autowired
	private RaceAppearanceService raceAppearanceService;
	
	@Autowired
	private GoalService goalService;
	
	private Random random = new Random();

	// NPC Gallery
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Set so this displays "Hello <name>"
		model.addAttribute("loggedUser", loginService.findById(userId));

		// Set so all NPC's associated with this user are displayed
		model.addAttribute("npcs", npcService.findByUser(loginService.findById(userId)));
		return "home.jsp";
	}
	// Sort by NameAsc
	@GetMapping("/home/nameasc")
	public String homeSortByNameAsc(HttpSession session, Model model) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Set so this displays "Hello <name>"
		model.addAttribute("loggedUser", loginService.findById(userId));

		// Set so all NPC's associated with this user are displayed
		model.addAttribute("npcs", npcService.findByCreatorSortedNameAscending(loginService.findById(userId)));
		return "home.jsp";
	}
	
	// Sort by RaceAsc
	@GetMapping("/home/raceasc")
	public String homeSortByRaceAsc(HttpSession session, Model model) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Set so this displays "Hello <name>"
		model.addAttribute("loggedUser", loginService.findById(userId));

		// Set so all NPC's associated with this user are displayed
		model.addAttribute("npcs", npcService.findByCreatorSortedRaceAscending(loginService.findById(userId)));
		return "home.jsp";
	}
	
	// Sort by CrAsc
	@GetMapping("/home/crasc")
	public String homeSortByCrAsc(HttpSession session, Model model) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Set so this displays "Hello <name>"
		model.addAttribute("loggedUser", loginService.findById(userId));

		// Set so all NPC's associated with this user are displayed
		model.addAttribute("npcs", npcService.findByCreatorSortedCrAscending(loginService.findById(userId)));
		return "home.jsp";
	}

	// Manual Generated NPC:
	// Create
	@GetMapping("/manualnpc/new")
	public String newNPC(@ModelAttribute("newNPC") NPC newNPC, Model model, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Why do we do this?
		// I forgot to add a "hidden input in the JSP file, which sets the userId as the
		// NPC creator ID
		model.addAttribute("thisUser", loginService.findById(userId));
		return "newmanualnpc.jsp";
	}

	// Create
	@PostMapping("/manualnpc/new")
	public String addNPC(@Valid @ModelAttribute("newNPC") NPC newNPC, BindingResult result, Model model,
			HttpSession session) {
		// Check for POST errors
		// TODO: Report error back to the client
		if (result.hasErrors()) {
			return "newmanualnpc.jsp";
		}

		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Set up parts not automatically filled in by JSPs
		newNPC.setCreator(loginService.findById(userId));
		newNPC.setCreatedAt();
		newNPC.setUpdatedAt();

		// Actually create the NPC in the database
		npcService.createNpc(newNPC);

		return "redirect:/home";
	}

	// Read
	@GetMapping("/npc/{id}/view")
	public String viewNPC(@PathVariable Long id, Model model, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Why do we set this?
		model.addAttribute("thisUser", loginService.findById(userId));

		// Set so this NPC is displayed
		model.addAttribute("aNPC", npcService.getOneNPC(id));
		return "viewnpc.jsp";
	}

	// Update
	@GetMapping("/npc/{id}/edit")
	public String editOneNPC(@PathVariable Long id, Model model, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Validate that id is owned by user
		NPC thisNPC = npcService.getOneNPC(id);
		if (userId != thisNPC.getCreator().getId()) { // check user is creator
			return "redirect:/home";
		}

		// Set so this NPC is displayed
		model.addAttribute("aNPC", npcService.getOneNPC(id));

		return "editnpc.jsp";
	}

	@PutMapping("/npc/{id}/edit")
	public String editNPC(@Valid @ModelAttribute("aNPC") NPC editNPC, BindingResult result, @PathVariable Long id,
			HttpSession session) {
		// Check for PUT errors
		// TODO: Report error back to the client
		if (result.hasErrors()) {
			return "editnpc.jsp";
		}

		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Validate that id is owned by user
		NPC thisNPC = npcService.getOneNPC(id);
		if (userId != thisNPC.getCreator().getId()) { // check user is creator
			return "redirect:/home";
		}

		// Set up parts not automatically filled in by JSPs
		editNPC.setCreator(loginService.findById(userId));
		editNPC.setUpdatedAt();

		npcService.updateNPC(editNPC);
		return "redirect:/home";
	}

	@GetMapping("/npc/{id}/delete")
	@DeleteMapping("/npc/{id}/delete")
	public String deleteNPC(@PathVariable Long id, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// Validate that id is owned by user
		NPC thisNPC = npcService.getOneNPC(id);
		if (userId != thisNPC.getCreator().getId()) { // check user is creator
			return "redirect:/home";
		}

		// Delete the NPC from the database
		npcService.deleteNPC(id);

		return "redirect:/home";
	}

	// Auto Generated NPC:
	// Create
	@GetMapping("/newbasicnpc/new")
	public String newBasicNPC(@ModelAttribute("newBasicNPC") BasicNPC newBasic, Model model, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		// I forgot to add a "hidden input in the JSP file, which sets the userId as the
		// NPC creator ID
		model.addAttribute("thisUser", loginService.findById(userId));
		return "newbasicnpc.jsp";
	}

	@PostMapping("/newbasicnpc/new")
	public String addNPC(@Valid BasicNPC newBasic, HttpSession session) {

		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// Generate Race if not provided
		Optional<Race> selectRace;
		if (newBasic.getRace().equals("Auto")) {
			// Query the DB for a random race
			selectRace = raceService.findRandom();
		} else {
			selectRace = raceService.findBySymbolName(newBasic.getRace());
		}

		// If we don't find it, redirect back
		if(!selectRace.isPresent())
			return "redirect:/"; // Something very wrong has occured

		Race race = selectRace.get();
		newBasic.setRace(race.getSymbolName());

		// Generate Age from race
		Long raceId = race.getId();
		Age age;
	
		Optional<Age> selectAge = ageService.findByRace(raceId);
		if(!selectAge.isPresent())
			return "redirect:/"; // Something very wrong has occured

		age = selectAge.get();

		long maturationAge = age.getMaturationAge();
		long lifeSpan = age.getLifespan();

		int outAge = (int)(random.nextInt((int)(lifeSpan - maturationAge)) + maturationAge);
		newBasic.setAge(outAge);

		// Generate Name:
		// Gets parameters for retrieving an optional first/last name
		Sex sex = newBasic.getSex();
		Optional<Archetype> selectArchetype = archetypeService.findBySymbolName(newBasic.getArchetype());
		if(!selectArchetype.isPresent())
			return "redirect:/"; // Something very wrong has occured

		Archetype archetype = selectArchetype.get();

		// Generate First Name
		String firstName;
		Optional<FirstName> optionalFirstName1 = firstNameService.findName(sex, race, archetype);

		if (optionalFirstName1.isPresent()) {
			firstName = optionalFirstName1.get().getName();
		} else {
			Optional<FirstName> optionalFirstName2 = firstNameService.findName(sex, race);
			if (optionalFirstName2.isPresent()) {
				firstName = optionalFirstName2.get().getName();
				
			} else {
				firstName = "defaultFirst";
			}
		}

		// Generate Last Name
		String lastName;
		Optional<LastName> optionalLastName1 = lastNameService.findName(race, archetype);

		if (optionalLastName1.isPresent()) {
			lastName = optionalLastName1.get().getName();
		} else {
			Optional<LastName> optionalLastName2 = lastNameService.findName(race);
			if (optionalLastName2.isPresent()) {
				lastName = optionalLastName2.get().getName();
			} else {
				lastName = "defaultLast";
			}
		}

		// Combines First and Last Name
		newBasic.setName(firstName + " " + lastName);
		
		//Generate Profession:
		// profession takes newBasic's archetype and sex, which have already been instantiated above
		double cr = newBasic.getChallengeRating();
		if(cr == 0)
			cr = random.nextInt(10);

		newBasic.setChallengeRating(cr);

		String profession;
		Optional<Profession> optionalProfession1 = professionService.findProfession(archetype, cr, sex);

		if (optionalProfession1.isPresent()) {
			profession = optionalProfession1.get().getEnglishName();
		} else {
			Optional<Profession> optionalProfession2 = professionService.findProfession(archetype, cr);
			if (optionalProfession2.isPresent()) {
				profession = optionalProfession2.get().getEnglishName();
			} else {
				profession = "defaultProfession";
			}
		}
		
		newBasic.setProfession(profession);

		// Backgrounds
		String background;

		// Generate Background
		// Background takes newBasic's archetype which has already been instantiated.
		// It can also take profession, but they haven't been added to the table yet.
		Optional<Background> optionalBackground1 = backgroundService.findBackground(archetype);
		
		if (optionalBackground1.isPresent()) {
			background = optionalBackground1.get().getBackground();
		} else {
			background = "DefaultBackground";
		}

		newBasic.setBackground(background);

		// Quirks
		String quirk;
		Optional<Quirk> optionalQuirk1 = quirkService.findQuirk(archetype);
		
		if (optionalQuirk1.isPresent()) {
			quirk = optionalQuirk1.get().getQuirk();
		} else {
			quirk = "DefaultQuirk";
		}
		
		newBasic.setQuirks(quirk);

		// Goals
		String goal;
		Optional<Goal> optionalGoal = goalService.findGoal(archetype);
		
		if (optionalGoal.isPresent()) {
			goal = optionalGoal.get().getGoal();
		} else {
			goal = "Default Goal";
		}

		newBasic.setMotivation(goal);

		// Appearance
		String raceApperance;
		String archetypeAppearance;
		
		Optional<RaceAppearance> optionalRacialApperance = raceAppearanceService.findRaceAppearance(race);
		if (optionalRacialApperance.isPresent()) {
			raceApperance = optionalRacialApperance.get().getRaceAppearance();
		} else {
			raceApperance = "An unassuming " + newBasic.getRace().toString();	
		}
		
		Optional<ArchetypeAppearance> optionalArchetypalApperance = archetypeAppearanceService.findArchetypeAppearance(archetype);
		if (optionalArchetypalApperance.isPresent()) {
			archetypeAppearance = optionalArchetypalApperance.get().getArchetypeAppearance();
		} else {
			archetypeAppearance = "What you'd expect a " + archetype + " to look like, I guess? What were you expecting?";
		}
		
		newBasic.setAppearance(raceApperance + " " + archetypeAppearance);
		
		return "autonpc.jsp";
	}

	@GetMapping("/autonpc/new")
	public String autoNPC(@ModelAttribute("basicNPC") BasicNPC basicNPC, Model model, HttpSession session) {
		// Check to see if a user is logged in
		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;
		// Used for NPC Creator
		model.addAttribute("thisUser", loginService.findById(userId));
		return "autonpc.jsp";
	}

	@PostMapping("/autonpc/new")
	public String newAutoNPC(BasicNPC basicNPC, HttpSession session) {

		Object possibleId = session.getAttribute("userId");
		if (possibleId == null) {
			return "redirect:/"; // sends back if no one is logged in
		}

		// This is the logged-in user's id
		Long userId = (Long) possibleId;

		NPC newNPC = new NPC();

		newNPC.setName(basicNPC.getName());
		newNPC.setAge(basicNPC.getAge());
		newNPC.setMoralAlignment(basicNPC.getMoralAlignment());
		newNPC.setRace(basicNPC.getRace());
		newNPC.setSex(basicNPC.getSex());
		newNPC.setArchetype(basicNPC.getArchetype());
		newNPC.setChallengeRating(basicNPC.getChallengeRating());
		newNPC.setSocialAlignment(basicNPC.getSocialAlignment());
		newNPC.setProfession(basicNPC.getProfession());
		newNPC.setAppearance(basicNPC.getAppearance());
		newNPC.setQuirks(basicNPC.getQuirks());
		newNPC.setBackground(basicNPC.getBackground());
		newNPC.setMotivation(basicNPC.getMotivation());

		newNPC.setCreator(loginService.findById(userId));
		newNPC.setCreatedAt();
		newNPC.setUpdatedAt();

		// Actually create the NPC in the database
		npcService.createNpc(newNPC);

		return "redirect:/home";
	}
}
