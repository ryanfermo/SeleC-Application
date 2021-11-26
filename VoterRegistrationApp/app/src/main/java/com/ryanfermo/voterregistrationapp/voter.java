package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

public class voter extends AppCompatActivity implements View.OnClickListener{
    ImageButton back, submit, candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7, candidate8, candidate9, candidate10, candidate111, candidate112,candidate113,candidate114;
    TextView C1, C2, C3, C4, P1, P2, P3, P4,C5, C6, C7, C8, P5, P6, P7, P8,C9, C10, C11, C12, P9, P10, P11, P12,C13,C14,P13,P14;
    String president = "", vicepresident = "",secretary="",treasurer="",auditor="",pro="",representative="";
    Integer PA,PB,VPA,VPB,SA,SB,TA,TB,OA,OB,PRA,PRB,RA,RB;
    DatabaseReference votes;
    DatabaseReference candidate,candidate12,candidate13,candidate14,can5,can6,can7,can8,can9,can10,can11,can12,can13,can14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter);
        votes = FirebaseDatabase.getInstance().getReference().child("Votes");
        C1 = (TextView) findViewById(R.id.textView10);
        C2 = (TextView) findViewById(R.id.textView12);
        C3 = (TextView) findViewById(R.id.textView13);
        C4 = (TextView) findViewById(R.id.textView14);
        P1 = (TextView) findViewById(R.id.textView);
        P2 = (TextView) findViewById(R.id.textView3);
        P3 = (TextView) findViewById(R.id.textView5);
        P4 = (TextView) findViewById(R.id.textView6);
        C5 = (TextView) findViewById(R.id.namesecretary);
        C6 = (TextView) findViewById(R.id.namesecretary1);
        C7 = (TextView) findViewById(R.id.nametreasurer);
        C8 = (TextView) findViewById(R.id.nametreasurer1);
        P5 = (TextView) findViewById(R.id.partysecretary);
        P6 = (TextView) findViewById(R.id.partysecretary1);
        P7 = (TextView) findViewById(R.id.partytreasurer);
        P8 = (TextView) findViewById(R.id.partytreasurer1);
        C9 = (TextView) findViewById(R.id.nameauditor);
        C10 = (TextView) findViewById(R.id.nameauditor1);
        C11 = (TextView) findViewById(R.id.namepro);
        C12 = (TextView) findViewById(R.id.namepro1);
        P9 = (TextView) findViewById(R.id.partyauditor);
        P10 = (TextView) findViewById(R.id.partyauditor1);
        P11 = (TextView) findViewById(R.id.partypro);
        P12 = (TextView) findViewById(R.id.partypro1);
        C13 = (TextView) findViewById(R.id.namerep);
        C14 = (TextView) findViewById(R.id.namerep1);
        P13 = (TextView) findViewById(R.id.partyrep);
        P14 = (TextView) findViewById(R.id.partyrep1);
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(this);

        submit = (ImageButton) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        candidate1 = (ImageButton) findViewById(R.id.candidate1);
        candidate1.setOnClickListener(this);

        candidate2 = (ImageButton) findViewById(R.id.candidate2);
        candidate2.setOnClickListener(this);

        candidate3 = (ImageButton) findViewById(R.id.candidate3);
        candidate3.setOnClickListener(this);

        candidate4 = (ImageButton) findViewById(R.id.candidate4);
        candidate4.setOnClickListener(this);

        candidate5 = (ImageButton) findViewById(R.id.candidate5);
        candidate5.setOnClickListener(this);

        candidate6 = (ImageButton) findViewById(R.id.candidate6);
        candidate6.setOnClickListener(this);

        candidate7 = (ImageButton) findViewById(R.id.candidate7);
        candidate7.setOnClickListener(this);

        candidate8 = (ImageButton) findViewById(R.id.candidate8);
        candidate8.setOnClickListener(this);

        candidate9 = (ImageButton) findViewById(R.id.candidate9);
        candidate9.setOnClickListener(this);

        candidate10 = (ImageButton) findViewById(R.id.candidate10);
        candidate10.setOnClickListener(this);

        candidate111 = (ImageButton) findViewById(R.id.candidate11);
        candidate111.setOnClickListener(this);

        candidate112 = (ImageButton) findViewById(R.id.candidate12);
        candidate112.setOnClickListener(this);

        candidate113 = (ImageButton) findViewById(R.id.candidate13);
        candidate113.setOnClickListener(this);

        candidate114 = (ImageButton) findViewById(R.id.candidate14);
        candidate114.setOnClickListener(this);


        candidate=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
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

        candidate12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate2");
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

        candidate13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate3");
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

        candidate14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate4");
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


        can5=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate5");
        can5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C5.setText(name);
                    P5.setText(party);
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

        can6=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate6");
        can6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
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

        can7=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate7");
        can7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C7.setText(name);
                    P7.setText(party);
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

        can8=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate8");
        can8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C8.setText(name);
                    P8.setText(party);
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

        can9=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        can9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C9.setText(name);
                    P9.setText(party);
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

        can10=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        can10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C10.setText(name);
                    P10.setText(party);
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

        can11=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        can11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C11.setText(name);
                    P11.setText(party);
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

        can12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        can12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C12.setText(name);
                    P12.setText(party);
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

        can13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate13");
        can13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C13.setText(name);
                    P13.setText(party);
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

        can14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate14");
        can14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C14.setText(name);
                    P14.setText(party);
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
    public void onBackPressed() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
               SignOut();
                break;
            case R.id.submit:
                submit();
                break;

            case R.id.candidate1:
                candidate1();
                break;
            case R.id.candidate2:
                candidate2();
                break;
            case R.id.candidate3:
                candidate3();
                break;
            case R.id.candidate4:
                candidate4();
                break;
            case R.id.candidate5:
                candidate5();
                break;
            case R.id.candidate6:
                candidate6();
                break;
            case R.id.candidate7:
                candidate7();
                break;
            case R.id.candidate8:
                candidate8();
                break;
            case R.id.candidate9:
                candidate9();
                break;
            case R.id.candidate10:
                candidate10();
                break;
            case R.id.candidate11:
                candidate11();
                break;
            case R.id.candidate12:
                candidate12();
                break;
            case R.id.candidate13:
                candidate13();
                break;
            case R.id.candidate14:
                candidate14();
                break;
        }
    }

    private void SignOut() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();
    }

    private void candidate4() {
        candidate4.setImageResource(R.drawable.voted);
        vicepresident ="VicePresident B";
        VPB=1;
        VPA=0;
        candidate13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate3");
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

    }

    private void candidate3() {
        candidate3.setImageResource(R.drawable.voted);
        vicepresident ="VicePresident A";
        VPA=1;
        VPB=0;
        candidate14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate4");
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
    }

    private void candidate2() {
        candidate2.setImageResource(R.drawable.voted);
        president = "President B";
        PB=1;
        PA=0;
        candidate=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
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
    }

    private void candidate1() {
        candidate1.setImageResource(R.drawable.voted);
        president = "President A";
        PA=1;
        PB=0;
        candidate12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate2");
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
    }


    private void candidate6() {
        candidate6.setImageResource(R.drawable.voted);
        secretary= "Secretary B";
        SB=1;
        SA=0;
        can5=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate5");
        can5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C5.setText(name);
                    P5.setText(party);
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
    }

    private void candidate5() {
        candidate5.setImageResource(R.drawable.voted);
        secretary = "Secretary A";
        SA=1;
        SB=0;
        can6=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate6");
        can6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
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
    }


    private void candidate8() {
        candidate8.setImageResource(R.drawable.voted);
        treasurer= "Treasurer B";
        TB=1;
        TA=0;
        can7=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate7");
        can7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C7.setText(name);
                    P7.setText(party);
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
    }

    private void candidate7() {
        candidate7.setImageResource(R.drawable.voted);
        treasurer = "Treasurer A";
        TA=1;
        TB=0;
        can8=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate8");
        can8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C8.setText(name);
                    P8.setText(party);
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
    }



    private void candidate10() {
        candidate10.setImageResource(R.drawable.voted);
        auditor= "Auditor B";
        OB=1;
        OA=0;
        can9=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        can9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C9.setText(name);
                    P9.setText(party);
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
    }

    private void candidate9() {
        candidate9.setImageResource(R.drawable.voted);
        auditor = "Auditor A";
        OA=1;
        OB=0;
        can10=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        can10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C10.setText(name);
                    P10.setText(party);
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
    }



    private void candidate12() {
        candidate112.setImageResource(R.drawable.voted);
        pro= "PRO B";
        PRB=1;
        PRA=0;
        can11=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        can11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C11.setText(name);
                    P11.setText(party);
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
    }

    private void candidate11() {
        candidate111.setImageResource(R.drawable.voted);
        pro = "PRO A";
        PRA=1;
        PRB=0;
        can12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        can12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C12.setText(name);
                    P12.setText(party);
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
    }



    private void candidate14() {
        candidate114.setImageResource(R.drawable.voted);
        representative= "Representative B";
        RB=1;
        RA=0;
        can13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate13");
        can13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C13.setText(name);
                    P13.setText(party);
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
    }

    private void candidate13() {
        candidate113.setImageResource(R.drawable.voted);
        representative = "Representative A";
        RA=1;
        RB=0;
        can14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate14");
        can14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
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


    private void submit() {
        if (president.isEmpty() || vicepresident.isEmpty()) {
            Toast.makeText(voter.this, "No votes are submitted", Toast.LENGTH_LONG).show();
        } else {

            AlertDialog.Builder builder =new AlertDialog.Builder(voter.this);
            builder.setMessage("Are you sure you want to submit your vote? You won't be able to undo changes after.")
                    .setPositiveButton("submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            votes voted = new votes(president,vicepresident,PA,PB,VPA,VPB,secretary,treasurer,SA,SB,TA,TB,auditor,pro,OA,OB,PRA,PRB,representative,RA,RB);
                            votes.push().setValue(voted);
                            Toast.makeText(voter.this, "Votes are submitted", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(voter.this, done.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Back",null);
            AlertDialog alert=builder.create();
            alert.show();

        }
    }

}