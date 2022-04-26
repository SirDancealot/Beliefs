package ai.gr64.Mastermind.Game;


public enum Color {    
    RED(0),
    BLACK(1),
    GREEN(2),
    ORANGE(3),
    MAGENTA(4),
    CYAN(5);

    public final int value;
    private Color(int value) {
        this.value = value;
    }

    public static Color fromValue(int value) {
        switch (value) {
            case 0:
                return RED;
            case 1:
                return BLACK;
            case 2:
                return GREEN;
            case 3:
                return ORANGE;
            case 4:
                return MAGENTA;
            case 5:
                return CYAN;
        
            default:
                throw new Error("Value must be in range 0-5");
        }
    }

    public static String getColor(Color color) {
        switch (color) {
            case RED:
                return "DARKRED";
            case BLACK:
                return "BLACK";
            case GREEN:
                return "LAWNGREEN";
            case ORANGE:
                return "ORANGERED";
            case MAGENTA:
                return "DEEPPINK";
            case CYAN:
                return "CYAN";
        
            default:
                throw new Error("Value must be in range 0-5");
        }
        
    }
}
