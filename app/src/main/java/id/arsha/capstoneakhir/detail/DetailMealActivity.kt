package id.arsha.capstoneakhir.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import id.arsha.core.domain.model.Meal
import id.arsha.capstoneakhir.R
import id.arsha.capstoneakhir.databinding.ActivityDetailMealBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMealActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMealViewModel: DetailMealViewModel by viewModel()
    private lateinit var binding: ActivityDetailMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMeal = intent.getParcelableExtra<Meal>(EXTRA_DATA)
        showDetailMeal(detailMeal)
    }

    private fun showDetailMeal(detailMeal: Meal?) {
        detailMeal?.let {
            supportActionBar?.title = detailMeal.strMeal
            binding.detailContent.mealName.text = detailMeal.strMeal
            binding.detailContent.textArea.text = detailMeal.strArea
            binding.detailContent.textInstruction.text = detailMeal.strInstructions
            Glide.with(this@DetailMealActivity)
                .load(detailMeal.strMealThumb)
                .into(binding.detailContent.imgItem)
            binding.detailContent.btnVideo.setOnClickListener {
                val video = detailMeal.strYoutube
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(video))
                startActivity(i)
            }

            var statusFavorite = detailMeal.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMealViewModel.setFavoriteMeal(detailMeal, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
