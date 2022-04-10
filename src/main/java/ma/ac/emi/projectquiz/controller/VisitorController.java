package ma.ac.emi.projectquiz.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ma.ac.emi.projectquiz.model.Message;
import ma.ac.emi.projectquiz.model.Quiz;

@Controller
public class VisitorController {
    
  @MessageMapping("/connect/{code}")
  @SendTo("/topic/{code}")
  public Message participate(@DestinationVariable String code,Message message) {
    System.out.println(code);
    return message;
  }

  @MessageMapping("/Quiz/{code}")
  @SendTo("/topic/Quiz/{code}")
  public Quiz sendQuiz(@DestinationVariable String code,Quiz quiz) {
    System.out.println(code);
    System.out.println(quiz.getName());
    return quiz;
  }

  @MessageMapping("/Quiz/{pin}/connect")
  @SendTo("/topic/Quiz/{pin}/connect")
  public String sendParticipation(@DestinationVariable String pin, String participation) {
    return participation;
  }

  @MessageMapping("/Player/{playerId}/score")
  @SendTo("/topic/Player/{playerId}/score")
  public String sendScore(@DestinationVariable String playerId, String score) {
    return score;
  }
  @MessageMapping("/Quiz/{pin}/question")
  @SendTo("/topic/Quiz/{pin}/question")
  public String sendQuestion(@DestinationVariable String pin, String question) {
    return question;
  }

  @MessageMapping("/Player/{playerId}/answer")
  @SendTo("/topic/Player/{playerId}/answer")
  public String sendAnswer(@DestinationVariable String playerId, String AnswerText) {
    return AnswerText;
  }
  
  @MessageMapping("/Players/{playerId}/acceptence")
  @SendTo("/topic/Players/{playerId}/acceptence")
  public String sendAcceptence(@DestinationVariable String playerId, String acceptence) {
    return acceptence;
  }

}
