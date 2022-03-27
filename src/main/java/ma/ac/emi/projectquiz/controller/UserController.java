package ma.ac.emi.projectquiz.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.hashids.Hashids;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.projectquiz.model.Message;


@RestController
public class UserController {

    private AtomicLong atomicLong = new AtomicLong(1000000);
    private Hashids hashids = new Hashids("quiz id is my id");

    @PostMapping("v1/new-id2")
    public Message getQuizID(@RequestBody Message message) {
        String id = hashids.encode(atomicLong.incrementAndGet());
        return new Message("base", id, id,"new-id");
    }
    @CrossOrigin("http://localhost:19006")
    @GetMapping("v1/new-id")
    public Message getNewQuizID() throws InterruptedException {
        String id = hashids.encode(atomicLong.incrementAndGet());
        return new Message("base", id, id,"new-id");
    }
    
}
