package ac.ucr.b55634.hw2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Node {
    private String name;
    private Boolean opinion;
    private Boolean isPublished;
    private Set<Node> friends;

    public Node(String name) {
        this.name = name;
        opinion = false;
        isPublished = false;
        friends = new HashSet<>();
    }

    public void add(Node friend) {
        if (friends.add(friend)) {
            friend.add(this);
        }
    }

    public String getName() {
        return name;
    }

    public Boolean isPublished() {
        return isPublished;
    }

    /**
     * Retorna la opinión sin importar si es publicada o no
     * @return true si es verdadera
     */
    public Boolean getOpinion() {
        return opinion;
    }

    public void opinionPositive() {
        opinion = true;
    }

    public Boolean getPublishedOpinion() {
        if (isPublished) {
            return opinion;
        } else return false;
    }

    /**
     * Marca la opinión como publicada si estas es verdadera
     */
    public void publish() {
        if (opinion)
            isPublished = true;
    }

    public boolean reviewOpinion() {
        // Recorrer la lista usando streams y lambda
        long opinion = new ArrayList<>(friends).stream()
                .filter(Node::getPublishedOpinion)
                .count();

        if ((opinion * 100 / friends.size()) >= 50) {
            opinionPositive();
        }
        return this.opinion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node param = (Node) obj;
            if (name == null && param.name == null) return true;
            if (name == null) return false;
            return name.equalsIgnoreCase(param.name);

        } else return false;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase(Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
