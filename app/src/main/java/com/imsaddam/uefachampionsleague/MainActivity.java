package com.imsaddam.uefachampionsleague;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Group A", "Group B", "Group C", "Group D",
                "Group E", "Group F", "Group G", "Group H"};

        String country_names[] = {"Arsenal", "Ludogorets", "Basel", "PSG",
                "Napoli", "Beşiktaş", "Benfica", "Dynamo Kyiv", "Barcelona",
                "Manchester City", "Borussia Mgladbach", "Celtic", "Bayern München", "Atlético Madrid",
                "PSV", "Rostov", "Monaco", "CSKA Moskva", "Bayer Leverkusen",
                "Tottenham Hotspur", "Borussia Dortmund", "Real Madrid", "Sporting CP",
                "Legia Warszawa", "Leicester City", "København", "Porto", "Club Brugge",
                "Olympique Lyonnais", "Juventus", "Sevilla", "Dinamo Zagreb"};

        int Images[] = {R.drawable.arsenal, R.drawable.ludogorets,
                R.drawable.basel, R.drawable.psg, R.drawable.napoli,
                R.drawable.baskitas, R.drawable.befica, R.drawable.dynamokajiv,
                R.drawable.barcelona, R.drawable.mancity, R.drawable.borssuamaldag,
                R.drawable.celtic, R.drawable.bayrn, R.drawable.almadrid,
                R.drawable.psv, R.drawable.rostov, R.drawable.monaco,
                R.drawable.csk, R.drawable.leverkuson,
                R.drawable.totenham, R.drawable.dortmund, R.drawable.realmadrid,
                R.drawable.sprotingcp, R.drawable.lagiawarsiza, R.drawable.leicester,
                R.drawable.kabenhan, R.drawable.porto, R.drawable.brugge,
                R.drawable.lyon, R.drawable.juventus, R.drawable.sevilla,
                R.drawable.dinamozargab};


        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setImage(Images[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 4;
        }

        return list;
    }
}
