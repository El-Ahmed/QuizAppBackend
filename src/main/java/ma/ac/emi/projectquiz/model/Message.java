package ma.ac.emi.projectquiz.model;


public class Message {

    private String senderId;
    private String destinationId;
    private String content;
    private String reason;
    
    public Message() {}

    public Message(String senderId, String destinationId, String content, String reason) {
        this.senderId = senderId;
        this.destinationId = destinationId;
        this.content = content;
        this.reason = reason;
    }
    public String getReason() {
        return reason;
    }
    public String getSenderId() {
        return senderId;
    }
    public String getDestinationId() {
        return destinationId;
    }
    public String getContent() {
        return content;
    }
}
