import util.AnagramChecker;
import service.AnagramService;
import service.AnagramServiceImpl;

public class Main {
    public static void main(String[] args) {
        AnagramService anagramService = new AnagramServiceImpl();
        AnagramChecker checker = new AnagramChecker(anagramService);
        checker.run();
    }
}

