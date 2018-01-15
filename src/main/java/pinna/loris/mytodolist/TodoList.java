package pinna.loris.mytodolist;

import java.util.ArrayList;

public class TodoList {
    private static volatile TodoList instance = null;

    private ArrayList<TodoItem> elements = new ArrayList<>();

    private TodoList() {
        super();
    }

    /**
     * Méthode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static TodoList getInstance() {
        if (TodoList.instance == null) {
            synchronized(TodoList.class) {
                if (TodoList.instance == null) {
                    TodoList.instance = new TodoList();
                }
            }
        }
        return TodoList.instance;
    }

    public void addTodo(CharSequence text) {
        this.elements.add(new TodoItem(text));
    }

    public ArrayList<TodoItem> getElements() {
        return elements;
    }

    public void clearElements() {
        elements.clear();
    }

    public void setImportant(int index) {
        this.elements.get(index).setImportant(! this.elements.get(index).getImportant());
    }
}
