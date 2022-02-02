package Utils;

public class Commands {

    private boolean browserCommands,
        navigationCommands,
        switchCommands,
        waitCommands,
        webelementCommands;

    public Commands(boolean browserCommands, boolean navigationCommands, boolean switchCommands, boolean waitCommands, boolean webelementCommands) {
        this.browserCommands = browserCommands;
        this.navigationCommands = navigationCommands;
        this.switchCommands = switchCommands;
        this.waitCommands = waitCommands;
        this.webelementCommands = webelementCommands;
    }

    public boolean allFalse(){
        return (!browserCommands &&
                !navigationCommands &&
                !switchCommands &&
                !waitCommands &&
                !webelementCommands);
    }

    public boolean isBrowserCommands() {
        return browserCommands;
    }

    public void setBrowserCommands(boolean browserCommands) {
        this.browserCommands = browserCommands;
    }

    public boolean isNavigationCommands() {
        return navigationCommands;
    }

    public void setNavigationCommands(boolean navigationCommands) {
        this.navigationCommands = navigationCommands;
    }

    public boolean isSwitchCommands() {
        return switchCommands;
    }

    public void setSwitchCommands(boolean switchCommands) {
        this.switchCommands = switchCommands;
    }

    public boolean isWaitCommands() {
        return waitCommands;
    }

    public void setWaitCommands(boolean waitCommands) {
        this.waitCommands = waitCommands;
    }

    public boolean isWebelementCommands() {
        return webelementCommands;
    }

    public void setWebelementCommands(boolean webelementCommands) {
        this.webelementCommands = webelementCommands;
    }
}
