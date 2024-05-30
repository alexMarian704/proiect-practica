package com.project.practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "create-event";
    }

    @PostMapping
    public String addEvent(Event event, Model model) {
        if (eventRepository.findByName(event.getName()) != null) {
            model.addAttribute("error", "Exista deja un eveniment cu acest nume");
            return "create-event";
        }
        eventRepository.save(event);
        return "redirect:/events/create";
    }

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "list-events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable String id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        model.addAttribute("event", new Event());
        return "update-event";
    }

    @PostMapping("/update")
    public String updateEvent(Event event) {
        Event existingEvent = eventRepository.findByName(event.getName());
        if (existingEvent != null) {
            if (event.getTournament() != null && !event.getTournament().isEmpty()) {
                existingEvent.setTournament(event.getTournament());
            }
            if (event.getLocation() != null && !event.getLocation().isEmpty()) {
                existingEvent.setLocation(event.getLocation());
            }
            if (event.getStartTime() != null) {
                existingEvent.setStartTime(event.getStartTime());
            }
            if (event.getHome() != null && !event.getHome().isEmpty()) {
                existingEvent.setHome(event.getHome());
            }
            if (event.getAway() != null && !event.getAway().isEmpty()) {
                existingEvent.setAway(event.getAway());
            }
            eventRepository.save(existingEvent);
        }
        return "redirect:/events";
    }
}
