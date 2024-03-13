package mx.edu.itson.potros.examenii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var detalles: ArrayList<Detalles> = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var option: String? = intent.getStringExtra("selection")
        agregarProductos(option)

        var listView: GridView = findViewById(R.id.detalles) as GridView


        var adaptador: DetalleAdapter = DetalleAdapter(this, detalles)
        listView.adapter = adaptador

    }

    private fun agregarProductos(option: String?) {

        when (option) {

            "Detalles" -> {
                detalles.add(Detalles(R.drawable.cumplebotanas, "250"))
                detalles.add(Detalles(R.drawable.cumplecheve, "250"))
                detalles.add(Detalles(R.drawable.cumpleescolar, "250"))
                detalles.add(Detalles(R.drawable.cumplepaletas, "250"))
                detalles.add(Detalles(R.drawable.cumplesnack, "250"))
                detalles.add(Detalles(R.drawable.cumplevinos, "250"))
            }

            "Globos" -> {
                detalles.add(Detalles(R.drawable.globoamor, "300"))
                detalles.add(Detalles(R.drawable.globocumple, "300"))
                detalles.add(Detalles(R.drawable.globofestejo,  "300"))
                detalles.add(Detalles(R.drawable.globonum, "300"))
                detalles.add(Detalles(R.drawable.globos,  "300"))
                detalles.add(Detalles(R.drawable.globos, "300"))
            }

            "Peluches" -> {
                detalles.add(Detalles(R.drawable.peluchemario,  "200"))
                detalles.add(Detalles(R.drawable.pelucheminecraft,  "200"))
                detalles.add(Detalles(R.drawable.peluchepeppa,  "200"))
                detalles.add(Detalles(R.drawable.peluches,  "200"))
                detalles.add(Detalles(R.drawable.peluchesony,  "200"))
                detalles.add(Detalles(R.drawable.peluchevarios,  "200"))
            }

            "Regalos" -> {
                detalles.add(Detalles(R.drawable.regaloazul,  "150"))
                detalles.add(Detalles(R.drawable.regalobebe,  "150"))
                detalles.add(Detalles(R.drawable.regalocajas,  "150"))
                detalles.add(Detalles(R.drawable.regalocolores,  "150"))
                detalles.add(Detalles(R.drawable.regalos,  "150"))
                detalles.add(Detalles(R.drawable.regalovarios,  "150"))
            }

            "Tazas" -> {
                detalles.add(Detalles(R.drawable.tazaabuela,  "200"))
                detalles.add(Detalles(R.drawable.tazalove,  "200"))
                detalles.add(Detalles(R.drawable.tazaquiero,  "200"))
                detalles.add(Detalles(R.drawable.tazas,  "200"))
            }
        }
    }

    class DetalleAdapter : BaseAdapter, ListAdapter {
        var context: Context? = null
        var detalles = ArrayList<Detalles>()

        constructor(context: Context, detalles: ArrayList<Detalles>) {
            this.context = context
            this.detalles = detalles
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(p0: Int): Any {
            return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }


        override fun getView(position: Int, coverView: View?, parent: ViewGroup?): View {
            var detalles = detalles[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)

            var image: ImageView = vista.findViewById(R.id.iv_regalo)
            var precio: TextView = vista.findViewById(R.id.tv_precio)


            image.setImageResource(detalles.image)
            precio.setText("$${detalles.precio}")

            image.setOnClickListener {
                var intento = Intent(context, detalle_regalos::class.java)

                intento.putExtra("image", detalles.image)
                intento.putExtra("precio", "$${detalles.precio}")
                context!!.startActivity(intento)
            }
            return vista
        }

    }

}