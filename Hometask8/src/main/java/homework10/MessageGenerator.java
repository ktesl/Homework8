package homework10;

public class MessageGenerator {
    public static String createInfoMessage(String message, Object... args) {
        String formattedMessage = String.format(message + " %s", args);
        return "INFO: " + formattedMessage;
    }

    public static String createErrorMessage(String message, Object... args) {
        String formattedMessage = String.format(message + ", %d", args);
        return "ERROR: " + formattedMessage;
    }

    public static void main(String[] args) {
        String infoMessage = createInfoMessage("Запуск додатку. Версія", "1.0");
        String errorMessage = createErrorMessage("Файл не знайдено", 404);

        System.out.println(infoMessage);
        System.out.println(errorMessage);
    }
}
