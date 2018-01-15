package pinna.loris.mytodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MySimpleArrayAdapter extends ArrayAdapter<TodoItem> {
    private final Context context;
    private final ArrayList<TodoItem> values;
    public MySimpleArrayAdapter(Context context, ArrayList<TodoItem> values) {
        super(context,  R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(  R.layout.rowlayout, parent, false);

        TodoItem item = values.get(position);

        TextView textView = (TextView) rowView.findViewById(R.id.layout_text);
        textView.setText(item.getText());

        if(item.getImportant())
            textView.setTextColor(Color.RED);
        else
            textView.setTextColor(Color.BLACK);

        return rowView;
    }
}