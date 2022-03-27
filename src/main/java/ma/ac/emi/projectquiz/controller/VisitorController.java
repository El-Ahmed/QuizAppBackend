package ma.ac.emi.projectquiz.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ma.ac.emi.projectquiz.model.Message;

@Controller
public class VisitorController {
    
  @MessageMapping("/connect/{code}")
  @SendTo("/topic/public/{code}")
  public Message participate(@DestinationVariable String code,Message message) {
    return message;
  }

}
