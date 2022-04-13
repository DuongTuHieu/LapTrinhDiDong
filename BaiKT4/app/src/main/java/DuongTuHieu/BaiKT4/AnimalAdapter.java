package DuongTuHieu.BaiKT4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, int layout, List<Animal> animalList) {
        this.context = context;
        this.layout = layout;
        this.animalList = animalList;
    }

    public AnimalAdapter(MainActivity mainActivity, int activity_animal_adapter, ArrayList<Animal> arrayList) {
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView tvten = (TextView) view.findViewById(R.id.tvTen);
        TextView tvmota = (TextView) view.findViewById(R.id.tvMoTa);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);

        Animal animal = animalList.get(i);

        tvten.setText(animal.getTen());
        tvmota.setText(animal.getMoTa());
        imageView.setImageResource(animal.getHinh());

        return view;
    }
}