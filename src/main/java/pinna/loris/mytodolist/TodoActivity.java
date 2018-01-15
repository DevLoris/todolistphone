package pinna.loris.mytodolist;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private Button empty_button;
    private Button validate_button;
    private EditText edit_text;
    private ListView lvMyListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        empty_button = (Button) findViewById(R.id.empty_button);
        empty_button.setOnClickListener(this);

        validate_button = (Button) findViewById(R.id.validate_button);
        validate_button.setOnClickListener(this);

        edit_text = (EditText) findViewById(R.id.editText);

        lvMyListView = (ListView)findViewById(R.id.lvMyListView);
        lvMyListView.setAdapter(new MySimpleArrayAdapter(getApplicationContext(), TodoList.getInstance().getElements()));
        lvMyListView.setOnItemClickListener(this);
        lvMyListView.setOnItemLongClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),position + " item",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button) {
            Button b = (Button) v;
            if( b == empty_button ) {
                Toast.makeText(getApplicationContext(),"Liste vidée",Toast.LENGTH_SHORT).show();
                TodoList.getInstance().clearDoneElements();
                lvMyListView.invalidateViews();
            }
            else if(b == validate_button) {

                Toast.makeText(getApplicationContext(),"Elément ajouté à la liste",Toast.LENGTH_SHORT).show();
                TodoList.getInstance().addTodo(edit_text.getText());
                edit_text.setText("");
                lvMyListView.invalidateViews();
            }
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        TodoList.getInstance().setDone(position);
        lvMyListView.invalidateViews();
        return false;
    }
}
