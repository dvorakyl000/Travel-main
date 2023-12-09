package org.wecancodeit.gamelibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.gamelibrary.Models.*;
import org.wecancodeit.gamelibrary.Repositories.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private BoardGameRepository bRepository;

    @Resource
    private PublisherRepository pRepository;

    public Populator(BoardGameRepository bRepository, PublisherRepository pRepository) {
        this.bRepository = bRepository;
        this.pRepository = pRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        PublisherModel publisher1 = new PublisherModel("Salt Lake City, UT");
        pRepository.save(publisher1);

        PublisherModel publisher2 = new PublisherModel("Aspen, CO");
        pRepository.save(publisher2);

        PublisherModel publisher3 = new PublisherModel("Seattle, WA");
        pRepository.save(publisher3);

        PublisherModel publisher4 = new PublisherModel("Boston, MA");
        pRepository.save(publisher4);

        BoardGameModel game1 = new BoardGameModel(
                "Big Cottonwood Canyon",
                "Located in the Wasactch Mountains, this wilderness region offers a limitless range of recreation for outdoor enthusiasts.",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4a/aa/ab/big-cottonwood-canyon.jpg?w=1200&h=-1&s=1",
                publisher1);
        bRepository.save(game1);
        BoardGameModel game2 = new BoardGameModel(
                "DarkSide Ghost Tour",
                "Experience a thrill as you hear about the gruesome history that created these ghosts, and glance around, wondering where the wraiths will emerge from.",
                "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/74/7c/8b.jpg",
                publisher2);
        bRepository.save(game2);
         BoardGameModel game3 = new BoardGameModel(
                "Snoqualmie Falls and Seattle Winery Tour",
                "This Snoqualmie Falls and winery tour from Seattle takes you beyond the city to see the massive waterfall.",
                "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/08/39/c0/32.jpg",
                publisher3);
        bRepository.save(game3);
        BoardGameModel game4 = new BoardGameModel(
                "Beneath The Streets Underground History Tour",
                "Get to know Seattle's first established neighborhood, Pioneer Square, by walking its underground pathways as they existed in the 1890s in the company of a guide.",
                "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/71/17/c6.jpg",
                publisher3);
        bRepository.save(game4);
        BoardGameModel game5 = new BoardGameModel(
                "Natural History Museum of Utah",
                "As the Utah state museum of natural history, this top attraction provides an introduction to the science in Utah's remarkable landscape!",
                "https://www.architecturalrecord.com/ext/resources/archives/projects/portfolio/2012/01/images/Natural-History-Museum-Utah-650x400px.jpg?t=1450319024&width=696",
                publisher1);
        bRepository.save(game5);
         BoardGameModel game6 = new BoardGameModel(
                "Samuel Adams Brewery",
                "Join a tour group to learn about the brew process of our R&D brewhouse or dive into exclusive barrel-aged beers paired with local cheese.",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/9d/ba/3c/tour.jpg?w=1200&h=-1&s=1",
                publisher4);
        bRepository.save(game6);

    }

}
