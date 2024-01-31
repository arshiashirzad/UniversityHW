import java.util.Date;
import java.text.SimpleDateFormat;
public class Message {
    private String sender;
    private String content;
    private String sentTime;
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        Date now = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
        String stringDate = DateFor.format(now);
        this.sentTime = stringDate;
    }
    @Override
    public String toString() {
        return sentTime + " - " + sender + ": " + content;
    }
}