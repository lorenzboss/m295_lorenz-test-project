package ch.lorenz.lorenz.podcast;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PodcastController {

    private final PortalService portalService;

    public PodcastController(PortalService portalService) {
        this.portalService = portalService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/i")
    public String world(@RequestParam(value = "name", defaultValue = "my friend") String name, @RequestParam(value = "surname", defaultValue = "you're the boss") String surname) {
        return "Hello " + name + " " + surname;
    }


    @GetMapping("/api/podcast")
    public ResponseEntity<List<Podcast>> getPodcast() {
        return new ResponseEntity<>(portalService.getPodcast(), HttpStatus.OK);
    }

    @PostMapping("/api/one                                             podcast")
    public ResponseEntity<Podcast> createOnePodcast(
            @RequestBody Podcast podcast) {
        portalService.savePodcast(podcast);
        return new ResponseEntity<>(podcast , HttpStatus.CREATED);
    }

    @PostMapping("/api/podcasts")
    public ResponseEntity<List<Podcast>> createManyPodcast(
            @RequestBody List<Podcast> podcast) {
        for (Podcast p : podcast) {
            portalService.savePodcast(p);
        }
        return new ResponseEntity<>(podcast ,HttpStatus.CREATED);
    }





}
