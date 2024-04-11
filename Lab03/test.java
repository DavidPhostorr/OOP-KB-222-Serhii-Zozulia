import java.util.ArrayList;
import java.util.List;

class Tests {
    public static void main(String[] args) {

        List<UserStory> userStories = new ArrayList<>();

        UserStory userStory1 = new UserStory(1, "Реалізувати реєстрацію користувачів", 3, new ArrayList<>());
        UserStory userStory2 = new UserStory(2, "Створити сторінку входу", 2, new ArrayList<>());
    
        userStories.add(userStory1);
        userStories.add(userStory2);
    
        userStory1.complete();
    
        Bug bug = Bug.createBug(1, "Помилка в аутентифікації", 1, userStory1);
    
        if (bug != null) {
            System.out.println(bug.toString());
        } else {
            System.out.println("Неможливо створити баг: не всі залежності виконані.");
        }
    }
}    

