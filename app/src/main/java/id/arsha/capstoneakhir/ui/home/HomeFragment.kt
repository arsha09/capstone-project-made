package id.arsha.capstoneakhir.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.arsha.core.data.Resource
import id.arsha.core.ui.MealAdapter
import id.arsha.capstoneakhir.R
import id.arsha.capstoneakhir.databinding.FragmentHomeBinding
import id.arsha.capstoneakhir.detail.DetailMealActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val mealAdapter = MealAdapter()
            mealAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.meal.observe(viewLifecycleOwner) { meal ->
                if (meal != null) {
                    when (meal) {
                        is Resource.Loading<*> -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success<*> -> {
                            binding.progressBar.visibility = View.GONE
                            mealAdapter.setData(meal.data)
                        }
                        is Resource.Error<*> -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                meal.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvMeal) {
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