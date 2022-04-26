package ma.ac.emi.projectquiz.mongodbTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ma.ac.emi.projectquiz.model.Quiz;
import ma.ac.emi.projectquiz.repository.QuizRepository;

@SpringBootTest
public class QuizSavingTest {

    @Autowired
    private QuizRepository quizRepository;

    @Test
    public void saveQuizAndRetreiveIt() {

        quizRepository.deleteAll();
        
        Quiz expectedQuiz = new Quiz("test", "desc", null);
        quizRepository.save(expectedQuiz);
        
        assertNotEquals(0, quizRepository.count());
        Quiz actualQuiz = quizRepository.findAll().get(0);
        assertEquals(expectedQuiz.getName(), actualQuiz.getName());
        assertEquals(expectedQuiz.getDescription(), actualQuiz.getDescription());

    }



    
}
