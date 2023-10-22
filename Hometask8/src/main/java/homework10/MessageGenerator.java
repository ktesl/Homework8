package homework10;

public class MessageGenerator {
    public static String createInfoMessage(String message, Object... args) {
        String formattedMessage = String.format(message, args);
        return "INFO: " + formattedMessage;
    }

    public static String createErrorMessage(String message, Object... args) {
        String formattedMessage = String.format(message, args);
        return "ERROR: " + formattedMessage;
    }

    public static void main(String[] args) {
        String infoMessage = createInfoMessage("Запуск додатку. Версія %s", "1.0");
        String errorMessage = createErrorMessage("Файл не знайдено, %d", 404);

        System.out.println(infoMessage);
        System.out.println(errorMessage);
    }
}
