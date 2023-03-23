package enums;

public enum ErrorLabelEnum {
    NONE("", false),
    CORRECT_LOGIN_ERROR_PASS("шо вылезает при этой хуете", true),

    VOID_LOG_PASS("шо вылезает если пустые поля", true)
    ;
    String label;
    boolean isDisplayed;
    ErrorLabelEnum(String label, boolean isDisplayed) {
        this.label = label;
        this.isDisplayed = isDisplayed;
    }

    public String getLabel() {
        return label;
    }

    public boolean isDisplayed() {
        return isDisplayed;
    }
}
