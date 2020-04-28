package com.giantdwarf.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/events/form";
        }

        //db save 발생
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {
        //db에서 읽어왔다고 가정
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute("eventList", eventList); //model.addAttribute(eventList);

        return "/events/list";
    }


}
