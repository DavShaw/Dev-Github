package es.codegym.telegrambot;

import java.util.HashMap;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "DavShawBot";
    // Nota: si se hará un bot público, ocultar el token del código fuente, hacer que lo tome desde otro archivo
    public static final String TOKEN = "6571332735:AAEMRFltMgnmxovDoKuZ8yVYp1Zt-wIIF9Y";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        User user = update.getMessage().getFrom();
        String bot_main_message = TelegramBotContent.getBotMainMessage(user.getUserName(), NAME);
        String user_current_message = update.getMessage().getText();

        // Enviar mensaje main si el mensaje es ["start", "iniciar", "on", "ayuda", "help"]
        if (user_current_message.matches("(?i)(/start|start|iniciar|/iniciar|/on|on|ayuda|/ayuda|help|/help)")) {
            sendTextMessageAsync(bot_main_message);
        }

        // Enviar mensaje main si el mensaje es ["1", "2", "3", "4"]
        else if (user_current_message.toLowerCase().matches("[0-9]")) {

            HashMap<String, String> map = new HashMap<>();
            map.put("1", "Hola, soy el desarrollador del bot. Me llamo David :D");
            map.put("2", "Trabajando en esta opcion...");
            map.put("3", "Trabajando en esta opcion...");
            map.put("4", "Adios, espero que te haya gustado el bot :D");

            String result = map.get(user_current_message);

            if (result != null) {
                sendTextMessageAsync(result);
            }
            else {
                sendTextMessageAsync("Opcion no valida");
            }

        }
    
        // Enviar un mensaje si el mensaje es ["me llamo"]
        else if (user_current_message.contains("me llamo")) {
            String msg = String.format("_Encantado de conocerte_ *@%s*, _yo soy_ *gato*", user.getUserName());
            sendTextMessageAsync(msg);
            sendTextMessageAsync("~Te contare un secreto, en realidad soy David, pero he hackeado a *Gato*~");
        }

    }

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        MyFirstTelegramBot bot = new MyFirstTelegramBot();

        telegramBotsApi.registerBot(bot);
    }
}