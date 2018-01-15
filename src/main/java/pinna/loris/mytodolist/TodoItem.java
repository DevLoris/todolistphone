package pinna.loris.mytodolist;

public class TodoItem {
    private CharSequence text;
    private Boolean important;

    public TodoItem(CharSequence text, Boolean important) {
        this.text = text;
        this.important = important;
    }

    public TodoItem(CharSequence text) {
        this.text = text;
        this.important = false;
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

}
