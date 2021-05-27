package id.arsha.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.arsha.core.R
import id.arsha.core.databinding.ItemListMealBinding
import id.arsha.core.domain.model.Meal
import java.util.ArrayList

class MealAdapter : RecyclerView.Adapter<MealAdapter.ListViewHolder>() {

    internal var listData = ArrayList<Meal>()
    var onItemClick: ((Meal) -> Unit)? = null

    fun setData(newListData: List<Meal>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_meal, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMealBinding.bind(itemView)
        fun bind(data: Meal) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(ivItemImage)
                tvItemTitle.text = data.strMeal
                tvItemSubtitle.text = data.strArea
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}