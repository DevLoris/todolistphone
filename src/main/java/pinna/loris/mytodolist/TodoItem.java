package pinna.loris.mytodolist;

public class TodoItem {
    private CharSequence text;
    private Boolean important;
    private Boolean done;
    private Boolean details;

    public TodoItem(CharSequence text, Boolean important) {
        this.text = text;
        this.important = important;
        this.done = false;
        this.details = false;
    }

    public TodoItem(CharSequence text) {
        this.text = text;
        this.important = false;
        this.done = false;
        this.details = false;
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getDetails() {
        return details;
    }

    public void setDetails(Boolean details) {
        this.details = details;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

}
