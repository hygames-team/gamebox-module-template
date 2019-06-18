package co.hygames.gamebox.modules.template;

import co.hygames.gamebox.module.GameBoxModule;

public class ModuleTemplate extends GameBoxModule {
    TemplateLanguage templateLanguage;

    public void onEnable() {
        getGameBox().getLogger().info(getModuleData().getName() + " has been enabled!");
        this.templateLanguage = new TemplateLanguage(this);
        System.out.println(TemplateLanguage.Messages.EXAMPLE.get());
    }

    public void onDisable() {

    }
}
