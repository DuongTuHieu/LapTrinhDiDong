package DuongTuHieu.BaiKT4;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Animal> arrayList;
    AnimalAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new AnimalAdapter(this, R.layout.activity_animal_adapter,arrayList);
        listView.setAdapter(adapter);
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.lvanimal);
        arrayList = new ArrayList<>();

        arrayList.add(new Animal("Octopus","8 tentacled monster",R.drawable.octopus));
        arrayList.add(new Animal("Pig","Delicious in rolls",R.drawable.pig));
        arrayList.add(new Animal("Sheep","Great for jumpers",R.drawable.sheep));
        arrayList.add(new Animal("Rabbit","Nice in a stew",R.drawable.rabbit));
        arrayList.add(new Animal("Snake.png","Great for shoes",R.drawable.snake));
        arrayList.add(new Animal("Spider","Nice in a stew",R.drawable.spider));
    }
}