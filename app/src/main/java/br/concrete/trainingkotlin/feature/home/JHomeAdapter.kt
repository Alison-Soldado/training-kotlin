package br.concrete.trainingkotlin.feature.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.concrete.trainingkotlin.R
import br.concrete.trainingkotlin.data.model.Item
import kotlinx.android.synthetic.main.item_home.view.*
import java.util.*

class JHomeAdapter : RecyclerView.Adapter<JHomeAdapter.ViewHolder>() {
    private val items = Api().fetchDefaultItems()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: Item) {
        items.add(item)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Item) {
            itemView.task.text = item.task
            itemView.description.text = item.description
        }
    }
}

class Api {
    fun fetchDefaultItems(): ArrayList<Item> {
        val items = ArrayList<Item>()
        items.add(Item("Estudar Kotlin", "Estudar a estrutura básica da linguagem"))
        items.add(Item("Estudar Dagger2", "Estudar o conceito de injeção de dependência e depois entender como funciona o dagger2 "))
        return items
    }
}