package mx.edu.itson.potros.examenii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detalle_regalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val iv_regalo: ImageView = findViewById(R.id.iv_regalo)
        val tv_precio: TextView = findViewById(R.id.tv_precio)

        val bundle = intent.extras

        if(bundle != null){
            iv_regalo.setImageResource(bundle.getInt("image"))
            tv_precio.setText((bundle.getString("precio")))
        }
    }
}