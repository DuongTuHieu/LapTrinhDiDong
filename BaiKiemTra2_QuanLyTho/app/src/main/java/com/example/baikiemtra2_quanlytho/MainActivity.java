package com.example.baikiemtra2_quanlytho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Bức tranh quê","Còn mãi hương quê",
            "Tình Quê"
    };

    String[] subtitle ={
            "Quê hương đẹp mãi trong tôi\n" +
                    "Dòng sông bên lỡ bên bồi uốn quanh\n" +
                    "Cánh cò bay lượn chòng chành\n" +
                    "Đàn bò gặm cỏ đồng xanh mượt mà\n" +
                    "\n" +
                    "Sáo diều trong gió ngân nga\n" +
                    "Bình yên thanh đạm chan hòa yêu thương\n" +
                    "Bức tranh đẹp tựa thiên đường\n" +
                    "Hồn thơ trỗi dậy nặng vương nghĩa tình.","Tóc dài em xõa ngang vai\n" +
            "Bóng quê hương đổ dặm dài phía sau\n" +
            "Bến sông đợi một nhịp cầu\n" +
            "Thênh thang đồng lúa một màu ngát xanh\n" +
            "\n" +
            "Yêu quê tình mãi ngọt lành\n" +
            "Du dương khúc hát thanh bình ngân nga\n" +
            "Điệu hò xứ Huế vang xa\n" +
            "Gửi tình em với quê nhà đợi mong\n" +
            "\n" +
            "Hè sang Phượng trổ sắc hồng\n" +
            "Người ơi ước hẹn tình nồng không phai!",
            "Tôi về tìm lại tuổi thơ\n" +
                    "Tìm trong câu hát ầu ơ ví dầu\n" +
                    "Tìm về đồng ruộng nương dâu\n" +
                    "Dòng sông bến nước cây cầu gốc đa\n" +
                    "\n" +
                    "Tôi về tìm lại hôm qua\n" +
                    "Hồn nhiên thơ mộng nô đùa rong chơi\n" +
                    "Tuổi thơ ngày ấy đâu rồi\n" +
                    "Bao nhiêu ký ức dần trôi ùa về\n" +
                    "\n" +
                    "Chẳng nơi nào đẹp bằng quê\n" +
                    "Nhà tranh vách lá tạm che nghèo nàn\n" +
                    "Nhưng mà tình nghĩa chứa chan\n" +
                    "Chở che đùm bọc cơ hàn sớt chia\n" +
                    "\n" +
                    "Phồn hoa đô thị ngoài kia\n" +
                    "Ồn ào náo nhiệt xa lìa tình thân\n" +
                    "Bôn ba xuôi ngược bụi trần\n" +
                    "Nửa đời nặng gánh vai uằn áo cơm",
    };

    Integer[] imgid={
    R.drawable.nang-19,
            R.drawable.nang-19,
                R.drawable.nang-19,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter((ListAdapter) adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}