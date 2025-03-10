package mx.edu.itson.potros.practica6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView = findViewById(R.id.series_catalogo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Dune", R.drawable.dune, R.drawable.dune2, "Duna: Parte Dos\" explorará el viaje mítico de Paul Atreides mientras se une con Chani y los Fremen mientras está en un camino de venganza contra los conspiradores que destruyeron a su familia. Enfrentando una elección entre el amor de su vida y el destino del universo conocido, se esfuerza por evitar un futuro terrible que solo él pueda prever."))
        peliculas.add(Pelicula("Heroe Por Encargo", R.drawable.heroexencargo, R.drawable.heroeencargo, "Un ex agente de las fuerzas especiales acepta un trabajo para brindar seguridad a una periodista mientras entrevista a un dictador, pero estalla un golpe militar en medio de la entrevista y se ven obligados a escapar a la jungla donde deben sobrevivir."))
        peliculas.add(Pelicula("Madame Web", R.drawable.madameweb, R.drawable.madame, "“Mientras tanto, en otro universo…” En un cambio del típico género, Madame Web cuenta la historia independiente del origen de una de las heroínas más enigmáticas de la editorial Marvel. El thriller de suspenso protagonizado por Dakota Johnson como Cassandra Webb, una paramédico de Manhattan que puede tener habilidades clarividentes. Forzada a enfrentarse a revelaciones de su pasado, ella forja una relación con tres mujeres jóvenes destinadas a tener poderosos futuros… si pueden sobrevivir a un presente mortal."))
        peliculas.add(Pelicula("Vidas Pasadas", R.drawable.vidaspasadas, R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia profundamente unidos, son separados después de que la familia de Nora emigrara de Corea del Sur. Veinte años después, se reúnen durante una fatídica semana para enfrentarse al amor y al destino."))
    }

    fun cargarSeries(){
        series.add(Pelicula("Halo", R.drawable.halo, R.drawable.halos, "Una evacuación mortal cambia la guerra del Jefe Maestro con el Covenant. En Reach, un nuevo régimen toma el mando en FLEETCOM. John siente una amenaza inminente cerca. Estreno de temporada."))
        series.add(Pelicula("Leveling", R.drawable.sololeveling, R.drawable.sololeveling1, "En un mundo en el que ciertos humanos llamados “cazadores” poseen habilidades mágicas, estos deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura. Un cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de sobrevivir."))
        series.add(Pelicula("Mi adorable demonio", R.drawable.adorabledemonio, R.drawable.adorabledemonios, "Se centra en la vida de Jung Koo Won, un temerario demonio que pierde sus poderes tras conocer a Do Do-Hee, una exitosa empresaria con la que deberá de colaborar para recuperarlos."))
        series.add(Pelicula("El monstruo de la vieja Seul", R.drawable.elmonstruo, R.drawable.elmonstruovieja, "Gyeongseong, 1945. En la oscura era colonial de Seúl, un empresario y una investigadora luchan por sobrevivir y se enfrentan a un monstruo nacido de la avaricia humana."))
        series.add(Pelicula("Witcher", R.drawable.thewitcher, R.drawable.thewitchers, "Una evacuación mortal cambia la guerra del Jefe Maestro con el Covenant. En Reach, un nuevo régimen toma el mando en FLEETCOM. John siente una amenaza inminente cerca. Estreno de temporada."))
    }

    class PeliculaAdapter: BaseAdapter{
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Pelicula>) : super(){
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.peliculas, null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell) as ImageView
            var title: TextView = vista.findViewById(R.id.movie_title_cell) as TextView

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener {
                var intent = Intent(context, detalle_pelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("imagen", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                context!!.startActivity(intent)
            }
            return vista
        }
    }
}