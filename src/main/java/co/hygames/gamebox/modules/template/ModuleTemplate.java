package co.hygames.gamebox.modules.template;

import co.hygames.gamebox.module.GameBoxModule;

public class ModuleTemplate extends GameBoxModule {
    public void onEnable() {
        getGameBox().getLogger().info(getModuleData().getName() + " has been enabled!");
    }

    public void onDisable() {

    }
}
