package org.wecancodeit.gamelibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.gamelibrary.Models.*;
import org.wecancodeit.gamelibrary.Repositories.*;
import jakarta.annotation.Resource;

@Controller
public class BoardGameController {

    @Resource
    private BoardGameRepository repository;
    @Resource
    private PublisherRepository publisherRepository;

    public BoardGameController(BoardGameRepository repository, PublisherRepository publisherRepository) {
        this.repository = repository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/game/createGame/{publisherId}")
    public String CreateGame(@PathVariable long publisherId, Model model) {
        BoardGameDto dto = new BoardGameDto(0, publisherId, "", "", "");
        dto.setTitle("Create board Game");
        model.addAttribute("game", dto);
        return "editGameView";
    }

    @GetMapping("/game/editGame/{id}")
    public String editGame(@PathVariable long id, Model model) {
        BoardGameModel game = repository.findById(id).get();
        BoardGameDto dto = game.getDto();
        dto.setTitle("Edit board Game");
        model.addAttribute("game", dto);
        return "editGameView";
    }

    @PostMapping("/game/saveGame")
    public String submitForm(@ModelAttribute BoardGameDto dto, Model model) {
        BoardGameModel boardGame;
        PublisherModel publisher = publisherRepository.findById(dto.getPublisherId()).get();
        if (dto.getId() == 0) {
            boardGame = new BoardGameModel(dto.getName(), dto.getDescription(), dto.getImageUrl(), publisher);
        } else {
            boardGame = repository.findById(dto.getId()).get();
            boardGame.setDescription(dto.getDescription());
            boardGame.setImageUrl(dto.getImageUrl());
            boardGame.setName(dto.getName());
        }
        repository.save(boardGame);
        return "redirect:/publisher";
    }

    @GetMapping("/game/deletegame/{id}")
    public String deleteGame(@PathVariable long id, Model model) {
        repository.deleteById(id);
        return "redirect:/publisher";
    }
}
