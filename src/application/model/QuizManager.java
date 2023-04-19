package application.model;

import java.util.List;

import javafx.collections.ObservableList;

public interface QuizManager {
    
    /**
     * Creates a new quiz with the given parameters and returns the unique ID of the quiz.
     * @param question the quiz question
     * @param option1 option 1 of the quiz
     * @param option2 option 2 of the quiz
     * @param option3 option 3 of the quiz
     * @param option4 option 4 of the quiz
     * @param correctAns the correct answer to the quiz
     * @param quizName the name of the quiz
     * @param endMins the duration of the quiz in minutes
     * @return the unique ID of the quiz
     */
    String createQuiz(String question, String option1, String option2, String option3, String option4, String correctAns, String quizName, long endMins);

    /**
     * Returns a list of all the quizzes.
     * @return a list of all the quizzes
     */
    ObservableList<Quiz> getQuizzes();

    /**
     * Returns the quiz with the specified ID.
     * @param quizId the ID of the quiz to fetch
     * @return the quiz with the specified ID, or null if no such quiz exists
     */
    Quiz fetchQuizById(String quizId);

    /**
     * Returns a list of all the students who have taken the specified quiz.
     * @param quiz the quiz to get attendance for
     * @return a list of all the students who have taken the quiz
     */
    List<String> getQuizAttendance(Quiz quiz);

    /**
     * Returns the analytics for the specified quiz.
     * @param quizId the ID of the quiz to get analytics for
     * @return the analytics for the specified quiz, or null if no such quiz exists
     */
    QuizAnalytics getQuizAnalytics(String quizId);
}
