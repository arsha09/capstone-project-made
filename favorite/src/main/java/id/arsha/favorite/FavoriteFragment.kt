package id.arsha.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.arsha.core.ui.MealAdapter
import id.arsha.favorite.databinding.FragmentFavoriteBinding
import id.arsha.capstoneakhir.detail.DetailMealActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        if (activity != null) {

            val mealAdapter = MealAdapter()
            mealAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteMeal.observe(viewLifecycleOwner) { dataMeal ->
                mealAdapter.setData(dataMeal)
                binding.lottieEmpty.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
                binding.textEmptyFav.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvFavMeal) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mealAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}