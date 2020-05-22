package guild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, Player> getRoster() {
        return roster;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity)
            this.roster.put(player.getName(), player);
    }

    public boolean removePlayer(String name) {
        return this.roster.remove(name, this.roster.get(name));
    }

    public void promotePlayer(String name) {
        if (this.roster.containsKey(name))
            this.roster.get(name).setRank("Member");
    }

    public void demotePlayer(String name) {
        if (this.roster.containsKey(name))
            this.roster.get(name).setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> save = new ArrayList<>();

        this.roster =
                this.roster.entrySet().stream()
                        .filter(s -> {

                            if (s.getValue().getClazz().equals(clazz)) {

                                save.add(s.getValue());
                                return false;

                            }

                            return true;
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Player[] arrayRemove = new Player[save.size()];
        for (int i = 0; i < save.size(); i++)
            arrayRemove[i] = save.get(i);

        return arrayRemove;

    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder().append(System.lineSeparator());

        sb.append(String.format("Players in the guild: %s:", this.getName())).append(System.lineSeparator());

        this.roster.values().forEach(s -> sb.append(s.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
