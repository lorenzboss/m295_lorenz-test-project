package ch.lorenz.lorenz.podcast;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalService {

    private final PodcastRepository repository;

    public PortalService(PodcastRepository repository) {
        this.repository = repository;
    }

    public List<Podcast> getPodcast() {
        return repository.findByOrderById();
    }

    public void savePodcast(Podcast podcast) {
        repository.save(podcast);
    }


}
