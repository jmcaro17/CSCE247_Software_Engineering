package singleton;

public enum Difficulty {
    EASY("txt/three.txt"),
    MEDIUM("txt/four.txt"),
    HARD("txt/five.txt");

    public final String fileName;

    private Difficulty(String fileName) {
        this.fileName = fileName;
    }
}
