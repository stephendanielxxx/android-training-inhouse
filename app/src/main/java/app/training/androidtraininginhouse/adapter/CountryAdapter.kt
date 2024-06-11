package app.training.androidtraininginhouse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.training.androidtraininginhouse.databinding.ItemCountryBinding
import app.training.androidtraininginhouse.model.CountryModel

class CountryAdapter(private val countries: List<CountryModel>,
    private val countryCallback: CountryCallback):
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCountryBinding):
        RecyclerView.ViewHolder(binding.root){
            init {
                binding.root.setOnClickListener{
                    countryCallback.onCountryClicked(countries[adapterPosition])
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(ItemCountryBinding.inflate
            (LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.tvName.text = countries[position].name
        with(holder){
            val country = countries[position]
            binding.tvName.text = country.name
            binding.ivFlag.setImageResource(country.flag)
        }
    }

    interface CountryCallback{
        fun onCountryClicked(countryModel: CountryModel)
    }
}