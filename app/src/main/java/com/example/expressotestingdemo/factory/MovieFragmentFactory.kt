import androidx.fragment.app.FragmentFactory
import com.example.expressotestingdemo.ui.fragments.ActorFragment
import com.example.expressotestingdemo.ui.fragments.DirectorFragment
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorFragment::class.java.name -> {
                DirectorFragment()
            }

            ActorFragment::class.java.name -> {
                ActorFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}













