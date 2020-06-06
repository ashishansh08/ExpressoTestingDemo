import com.example.expressotestingdemo.model.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}