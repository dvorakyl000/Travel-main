package org.wecancodeit.gamelibrary.Controllers;

import java.util.logging.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.wecancodeit.gamelibrary.Models.PublisherDto;
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.PublisherRepository;

import jakarta.annotation.Resource;


@Controller
public class PublisherController {

    @Resource
    private PublisherRepository repository;
    private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public PublisherController(PublisherRepository repository) {
        this.repository = repository;
    }

    @RequestMapping({ "", "/", "/publisher" })
    public String getAllPublishers(Model model) {
        LOGGER.log(Level.INFO, "My first Log Message");
        model.addAttribute("publishers", repository.findAll());
        return "displayPublishersView";
    }

    @GetMapping("/publisher/gameDetails/{id}")
    public String getPublisherDetails(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", repository.findById(id).get());
        return "gameDetailsView";
    }

    @GetMapping("/publisher/DeletePublisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/publisher";
    }

    @RequestMapping("/publisher/EditPublisher/{id}")
    public String editPublisher(@PathVariable Long id, Model model) {
        PublisherModel publisher = repository.findById(id).get();
        PublisherDto dto = new PublisherDto(publisher.getId(), publisher.getName());
        dto.setTitle("Edit Publisher");
        model.addAttribute("publisher", dto);
        return "editPublisherView";
    }

    @GetMapping("/publisher/create")
    public String createPublisher(Model model) {
        PublisherDto dto = new PublisherDto(0, "");
        dto.setTitle("Add new Publisher");
        model.addAttribute("publisher", dto);
        return "editPublisherView";
    }

    @PostMapping("/publisher/savePublisher")
    public String submitForm(@ModelAttribute PublisherDto dto, Model model) {
        PublisherModel publisher ;
        if (dto.getId() == 0) {
            publisher = new PublisherModel(dto.getName(), dto.getId());
        } else {
            publisher = repository.findById(dto.getId()).get();
            publisher.setName(dto.getName());
        }
        repository.save(publisher);
        return "redirect:/publisher";
    }

}
