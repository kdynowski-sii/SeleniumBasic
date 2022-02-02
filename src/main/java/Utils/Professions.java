package Utils;

public class Professions {
    private boolean manual, automation, other;

    public Professions(boolean manual, boolean automation, boolean other) {
        this.manual = manual;
        this.automation = automation;
        this.other = other;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isAutomation() {
        return automation;
    }

    public void setAutomation(boolean automation) {
        this.automation = automation;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }
}
