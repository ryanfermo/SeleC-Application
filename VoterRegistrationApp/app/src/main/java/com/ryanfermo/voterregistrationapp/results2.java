package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class results2 extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{
    ImageButton back, candidate1, candidate2, candidate3, candidate4, next;
    TextView C1, C2, C3, C4, P1, P2, P3, P4;
    TextView OA, OB, PRA, PRB;
    DatabaseReference votes,votes2,votes3,votes4;
    DatabaseReference candidate,candidate12,candidate13,candidate14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);
        C1 = (TextView) findViewById(R.id.textView10);
        C2 = (TextView) findViewById(R.id.textView12);
        C3 = (TextView) findViewById(R.id.textView13);
        C4 = (TextView) findViewById(R.id.textView14);
        P1 = (TextView) findViewById(R.id.textView);
        P2 = (TextView) findViewById(R.id.textView3);
        P3 = (TextView) findViewById(R.id.textView5);
        P4 = (TextView) findViewById(R.id.textView6);

        OA=(TextView)findViewById(R.id.OA);
        OB=(TextView)findViewById(R.id.OB);
        PRA=(TextView)findViewById(R.id.PRA);
        PRB=(TextView)findViewById(R.id.PRB);

        candidate1 = (ImageButton) findViewById(R.id.candidate1);
        candidate2 = (ImageButton) findViewById(R.id.candidate2);
        candidate3 = (ImageButton) findViewById(R.id.candidate3);
        candidate4 = (ImageButton) findViewById(R.id.candidate4);
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(this);
        next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(this);
        candidate= FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        candidate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C1.setText(name);
                    P1.setText(party);
                    Picasso.get().load(image).into(candidate1);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        candidate12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C2.setText(name);
                    P2.setText(party);
                    Picasso.get().load(image).into(candidate2);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        candidate13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C3.setText(name);
                    P3.setText(party);
                    Picasso.get().load(image).into(candidate3);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        candidate14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C4.setText(name);
                    P4.setText(party);
                    Picasso.get().load(image).into(candidate4);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        votes = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map=(Map<String, Object>)ds.getValue();
                    Object pb=map.get("ob");
                    int pValue=Integer.parseInt(String.valueOf(pb));
                    count+=pValue;
                    Log.d("Sum",String.valueOf(count));
                    OB.setText(String.valueOf(count));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes2 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count2 = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object pa=map.get("oa");
                    int pValue=Integer.parseInt(String.valueOf(pa));
                    count2+=pValue;
                    Log.d("Sum",String.valueOf(count2));
                    OA.setText(String.valueOf(count2));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes3 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes3.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count3 = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpb=map.get("prb");
                    int pValue=Integer.parseInt(String.valueOf(vpb));
                    count3+=pValue;
                    Log.d("Sum",String.valueOf(count3));
                    PRB.setText(String.valueOf(count3));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes4 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes4.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count4 = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpa=map.get("pra");
                    int pValue=Integer.parseInt(String.valueOf(vpa));
                    count4+=pValue;
                    Log.d("Sum",String.valueOf(count4));
                    PRA.setText(String.valueOf(count4));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

    }

    public void onBackPressed() {
        Intent new_intent = new Intent(this, results1.class);
        this.startActivity(new_intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent new_intent = new Intent(this, results1.class);
                this.startActivity(new_intent);
                finish();
                break;
            case R.id.next:
                Intent new_intents = new Intent(this, results3.class);
                this.startActivity(new_intents);
                finish();
                break;
        }
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.pop_menu1);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.admin_register:
                Toast.makeText(this, "Register Section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,registered.class));
                finish();
                return true;
            case R.id.admin_update:
                Toast.makeText(this, "Update Section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,content.class));
                return true;
            case R.id.admin_result:
                Toast.makeText(this, "Results Section", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.pop_menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
}