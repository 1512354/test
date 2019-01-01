package com.example.lenovo.smarttravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BookingInforActivity extends AppCompatActivity implements View.OnClickListener {

    PopularActivityModel popularActivityModel;
    Button btnPayNow;
    TextView txttitle,txtPrice,txtDate,txtTypeticket,txtQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_infor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Pay");
        String title = toolbar.getTitle().toString();
        btnPayNow = (Button)findViewById(R.id.btnPayNow);
        txttitle = (TextView) findViewById(R.id.txtTitle);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtTypeticket = (TextView) findViewById(R.id.txtTypeTicket);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity);
        btnPayNow.setOnClickListener(this);

        popularActivityModel = new PopularActivityModel();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            popularActivityModel = extras.getParcelable("activityModel");
            txttitle.setText(popularActivityModel.getTitle());
            txtDate.setText("Date selected: 22/02/2019");
            txtPrice.setText("Price: đ "+popularActivityModel.getPrice());
            txtTypeticket.setText("Type Ticket: Adult");
            txtQuantity.setText("Quantity: 2");
        }
        //Toast.makeText(this, ""+title, Toast.LENGTH_SHORT).show();






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }//onOptionItemSelected


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnPayNow:
                Toast.makeText(this, "Pay Successfully!"  , Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

    }//Onclick



}
