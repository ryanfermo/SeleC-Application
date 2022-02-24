package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class advocacy extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawer;
    Toolbar toolbar;
    ImageButton candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7, candidate8, candidate9, candidate10, candidate111, candidate112,candidate113,candidate114;
    TextView C1, C2, C3, C4, P1, P2, P3, P4,C5, C6, C7, C8, P5, P6, P7, P8,C9, C10, C11, C12, P9, P10, P11, P12,C13,C14,P13,P14;
    DatabaseReference candidate,candidate12,candidate13,candidate14,can5,can6,can7,can8,can9,can10,can11,can12,can13,can14;
    NavigationView navigationView;
    FirebaseUser currentuUser;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advocacy);

        C1 = (TextView) findViewById(R.id.name1);
        C2 = (TextView) findViewById(R.id.name2);
        C3 = (TextView) findViewById(R.id.name3);
        C4 = (TextView) findViewById(R.id.name4);
        C5 = (TextView) findViewById(R.id.name5);
        C6 = (TextView) findViewById(R.id.name6);
        C7 = (TextView) findViewById(R.id.name7);
        C8 = (TextView) findViewById(R.id.name8);
        C9 = (TextView) findViewById(R.id.name9);
        C10 = (TextView) findViewById(R.id.name10);
        C11 = (TextView) findViewById(R.id.name11);
        C12 = (TextView) findViewById(R.id.name12);
        C13 = (TextView) findViewById(R.id.name13);
        C14 = (TextView) findViewById(R.id.name14);
        P1 = (TextView) findViewById(R.id.advocacy1);
        P2 = (TextView) findViewById(R.id.advocacy2);
        P3 = (TextView) findViewById(R.id.advocacy3);
        P4 = (TextView) findViewById(R.id.advocacy4);
        P5 = (TextView) findViewById(R.id.advocacy5);
        P6 = (TextView) findViewById(R.id.advocacy6);
        P7 = (TextView) findViewById(R.id.advocacy7);
        P8 = (TextView) findViewById(R.id.advocacy8);
        P9 = (TextView) findViewById(R.id.advocacy9);
        P10 = (TextView) findViewById(R.id.advocacy10);
        P11 = (TextView) findViewById(R.id.advocacy11);
        P12 = (TextView) findViewById(R.id.advocacy12);
        P13 = (TextView) findViewById(R.id.advocacy13);
        P14 = (TextView) findViewById(R.id.advocacy14);

        candidate1 = (ImageButton) findViewById(R.id.candidate1);
        candidate2 = (ImageButton) findViewById(R.id.candidate2);
        candidate3 = (ImageButton) findViewById(R.id.candidate3);
        candidate4 = (ImageButton) findViewById(R.id.candidate4);
        candidate5 = (ImageButton) findViewById(R.id.candidate5);
        candidate6 = (ImageButton) findViewById(R.id.candidate6);
        candidate7 = (ImageButton) findViewById(R.id.candidate7);
        candidate8 = (ImageButton) findViewById(R.id.candidate8);
        candidate9 = (ImageButton) findViewById(R.id.candidate9);
        candidate10 = (ImageButton) findViewById(R.id.candidate10);
        candidate111 = (ImageButton) findViewById(R.id.candidate11);
        candidate112 = (ImageButton) findViewById(R.id.candidate12);
        candidate113 = (ImageButton) findViewById(R.id.candidate13);
        candidate114 = (ImageButton) findViewById(R.id.candidate14);

        mAuth = FirebaseAuth.getInstance();
        currentuUser = mAuth.getCurrentUser();
        updateNavHeader();
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        candidate = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
        candidate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C1.setText(name);
                    P1.setText(advocacy);
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

        candidate12 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate2");
        candidate12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C2.setText(name);
                    P2.setText(advocacy);
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

        candidate13 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate3");
        candidate13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C3.setText(name);
                    P3.setText(advocacy);
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

        candidate14 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate4");
        candidate14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C4.setText(name);
                    P4.setText(advocacy);
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

        can5 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate5");
        can5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy= dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C5.setText(name);
                    P5.setText(advocacy);
                    Picasso.get().load(image).into(candidate5);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can6 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate6");
        can6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(advocacy);
                    Picasso.get().load(image).into(candidate6);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can7 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate7");
        can7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C7.setText(name);
                    P7.setText(advocacy);
                    Picasso.get().load(image).into(candidate7);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can8 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate8");
        can8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C8.setText(name);
                    P8.setText(advocacy);
                    Picasso.get().load(image).into(candidate8);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can9 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        can9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C9.setText(name);
                    P9.setText(advocacy);
                    Picasso.get().load(image).into(candidate9);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can10 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        can10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C10.setText(name);
                    P10.setText(advocacy);
                    Picasso.get().load(image).into(candidate10);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can11 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        can11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", advocacy);
                    Log.d("image", image);
                    C11.setText(name);
                    P11.setText(advocacy);
                    Picasso.get().load(image).into(candidate111);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can12 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        can12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C12.setText(name);
                    P12.setText(advocacy);
                    Picasso.get().load(image).into(candidate112);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can13 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate13");
        can13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C13.setText(name);
                    P13.setText(advocacy);
                    Picasso.get().load(image).into(candidate113);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can14 = FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate14");
        can14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String advocacy = dataSnapshot.child("advocacy").getValue().toString().replace("\\n", "\n");
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("advocacy", advocacy);
                    Log.d("image", image);
                    C14.setText(name);
                    P14.setText(advocacy);
                    Picasso.get().load(image).into(candidate114);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.appvoter:
                Intent intent=new Intent(advocacy.this,advocacy.class );
                startActivity(intent);
                finish();
                break;
            case R.id.votingsec:
                Intent intent1=new Intent(advocacy.this,voter.class );
                startActivity(intent1);
                finish();
                break;
            case R.id.signout:
                Signout();
                break;
        }
        return true;
    }

    private void Signout() {
        Toast.makeText(advocacy.this, "Signed out Successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(advocacy.this,MainActivity.class );
        startActivity(intent);
        finish();
    }

    public void updateNavHeader(){
        navigationView=findViewById(R.id.nav_view);
        View HeaderView=navigationView.getHeaderView(0);
        TextView navUserName= HeaderView.findViewById(R.id.nav_username);
        ImageView imageview = (ImageView) HeaderView.findViewById(R.id.nav_imageView);
        imageview.setImageResource(R.drawable.selecprofile);
        navUserName.setText(currentuUser.getEmail());
    }
    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();
    }
}