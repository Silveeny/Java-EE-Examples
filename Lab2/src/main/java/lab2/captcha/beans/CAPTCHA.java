package lab2.captcha.beans;

public class CAPTCHA {
    public String path;
    public String text;

    public CAPTCHA() {
    }

    public CAPTCHA(String path, String text) {
        this.path = path;
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}