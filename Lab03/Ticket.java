import java.util.ArrayList;
import java.util.List;

class Ticket{
    private int id;
    private String name;
    private int estimate;
    private boolean completed;

    public Ticket(int id, String name, int estimate){
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completed = false;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    
    public int getEstimate(){
        return estimate;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void complete(){
        completed = true;
    }
}

class UserStory extends Ticket{
    private List<UserStory> dependencies;
    
    public UserStory(int id, String name, int estimate, List<UserStory> dependencies){
        super(id,name,estimate);
        this.dependencies = dependencies;
    }

    public List<UserStory> getDependencies(){
        return new ArrayList<>(dependencies);
    }

    @Override
    public String toString(){
        return "[US ]" + getId() + "] " + getName();
    }
}

class Bug extends Ticket {
    private UserStory userStory;

    public Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }
}

class Sprint {
    private int capacity;
    private int ticketLimit;
    private List<Ticket> tickets;

    public Sprint(int capacity, int ticketLimit) {
        this.capacity = capacity;
        this.ticketLimit = ticketLimit;
        this.tickets = new ArrayList<>();
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || isOverCapacity(userStory.getEstimate()) || isTicketLimitReached()) {
            return false;
        }
        tickets.add(userStory);
        return true;
    }

    public boolean addBug(Bug bug) {
        if (bug == null || bug.isCompleted() || isOverCapacity(bug.getEstimate()) || isTicketLimitReached()) {
            return false;
        }
        tickets.add(bug);
        return true;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public int getTotalEstimate() {
        int totalEstimate = 0;
        for (Ticket ticket : tickets) {
            totalEstimate += ticket.getEstimate();
        }
        return totalEstimate;
    }

    private boolean isOverCapacity(int estimate) {
        return getTotalEstimate() + estimate > capacity;
    }

    private boolean isTicketLimitReached() {
        return tickets.size() >= ticketLimit;
    }
}