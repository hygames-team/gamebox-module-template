package co.hygames.gamebox.modules.template;

import co.hygames.gamebox.exceptions.language.LanguageException;
import co.hygames.gamebox.language.GameBoxLanguage;
import co.hygames.gamebox.language.Language;
import co.hygames.gamebox.language.ModuleLanguage;
import co.hygames.gamebox.language.messages.Message;
import co.hygames.gamebox.module.GameBoxModule;

import java.util.List;
import java.util.Map;

public class TemplateLanguage extends ModuleLanguage {

    public TemplateLanguage(GameBoxModule module) {
        super(module);
    }

    @Override
    protected void loadMessages() {
        for (GameBoxLanguage.Messages message : GameBoxLanguage.Messages.values()) {
            try {
                loadMessage(message.getKey());
            } catch (LanguageException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void loadLists() {
        for (GameBoxLanguage.Lists list : GameBoxLanguage.Lists.values()) {
            try {
                loadList(list.getKey());
            } catch (LanguageException e) {
                e.printStackTrace();
            }
        }
    }

    public enum Messages implements Message<String> {
        EXAMPLE("example"),
        MESSAGE_IN_CATEGORY("categoryName.messageInCategory");

        static Language language;
        String key;

        Messages(String key) {
            this.key = key;
        }

        public String getKey() {
            return this.key;
        }

        @Override
        public String get() {
            return language.getMessage(key).get();
        }

        @Override
        public String resolve(Map<String, String> context) {
            return language.getMessage(key).resolve(context);
        }
    }

    public enum Lists implements Message<List<String>> {
        A_LIST("categoryName.aList");

        static Language language;
        String key;

        Lists(String key) {
            this.key = key;
        }

        public String getKey() {
            return this.key;
        }

        @Override
        public List<String> get() {
            return language.getMessageList(key).get();
        }

        @Override
        public List<String> resolve(Map<String, String> context) {
            return language.getMessageList(key).resolve(context);
        }
    }
}
