import java.util.*;

class Message {
    private String text;
    private User from;
    private User to;
    public Message(User from, User to, String text){ this.from = from; this.to = to; this.text = text; }
    public String toString(){ return "From " + from.getName() + " to " + to.getName() + ": " + text; }
}

class User {
    private String name;
    private List<Message> inbox = new ArrayList<>();
    public User(String name){ this.name = name; }
    public String getName(){ return name; }
    public void sendMessage(User to, String text){
        Message m = new Message(this, to, text);
        to.receive(m);
    }
    public void receive(Message m){ inbox.add(m); System.out.println("Delivered: " + m); }
}

public class SocialDemo {
    public static void main(String[] args){
        User u1 = new User("Anya");
        User u2 = new User("Vikram");
        u1.sendMessage(u2, "Hey! How are you?");
        u2.sendMessage(u1, "I'm good, thanks!");
    }
}

