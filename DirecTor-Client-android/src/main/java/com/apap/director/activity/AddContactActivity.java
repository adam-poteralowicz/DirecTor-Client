package main.java.com.apap.director.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import main.java.com.apap.director.R;

/**
 * Created by Adam on 2016-10-09.
 */
public class AddContactActivity extends Activity {
    EditText newContactName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_view);

        newContactName = (EditText) findViewById(R.id.newContactName);
        newContactName.setHint("CONTACT NAME");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.addContactButton) {
            Intent selectedIntent = new Intent(AddContactActivity.this, AuthUserActivity.class);
            selectedIntent.putExtra("newContactName", newContactName.getText());
            startActivityForResult(selectedIntent, 0013);
        }
    }
}
