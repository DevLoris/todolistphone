package pinna.loris.mytodolist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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


        TodoItem item = values.get(position);

        View rowView = inflater.inflate(  R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.layout_text);
        Button button = (Button) rowView.findViewById(R.id.important);
        textView.setText(item.getText());

        if(item.getDone())
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        button.setVisibility(item.getDetails() ? View.VISIBLE : View.INVISIBLE);
        Log.d("TAG", "visib" + item.getDetails());

        if(item.getImportant()) {
            textView.setTextColor(Color.RED);
            textView.setTypeface(null, Typeface.BOLD);
        }
        else
            textView.setTextColor(Color.BLACK);

        return rowView;
    }
}