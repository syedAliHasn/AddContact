package com.google.alihassan.contact;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.TooManyListenersException;


public class MainActivity extends ActionBarActivity {

    EditText name, phone, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameTxt);
        phone = (EditText) findViewById(R.id.phoneTxt);
        email = (EditText) findViewById(R.id.emailTxt);
        address = (EditText) findViewById(R.id.addressTxt);

        final Button addButton = (Button) findViewById(R.id.addBtn);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tbSpc = tabHost.newTabSpec("Contact");
        tbSpc.setContent(R.id.newContactTab);
        tbSpc.setIndicator("New Contact");
        tabHost.addTab(tbSpc);

        TabHost.TabSpec tbSpec2 = tabHost.newTabSpec("ContactList");
        tbSpec2.setContent(R.id.listTab);
        tbSpec2.setIndicator("Contact List");
        tabHost.addTab(tbSpec2);


        /*Contact Name EventHandler
        Here you go
        * */
        name.addTextChangedListener(new TextWatcher()

        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                addButton.setEnabled(!name.getText().toString().trim().isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Contact Name input field ends here





         /*Add Button Event Handler
        * */
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Your contact is saved sucessfully", Toast.LENGTH_SHORT).show();

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

