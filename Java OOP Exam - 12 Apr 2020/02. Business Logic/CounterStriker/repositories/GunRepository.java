package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> model;

    public GunRepository() {
        this.model = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.model);
    }

    @Override
    public void add(Gun model) {
        this.model.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.model.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return this.model.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
