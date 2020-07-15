package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.*;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> model;

    public PlayerRepository() {
        this.model = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.model);
    }

    @Override
    public void add(Player model) {
        this.model.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return this.model.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return this.model.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
