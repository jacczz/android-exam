package com.upraxis.exam.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upraxis.exam.R
import com.upraxis.exam.model.models.Person

class PersonRecyclerViewAdapter(private val onClickListener: (Person) -> Unit) :
    ListAdapter<Person, PersonViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_person, parent, false)
        return PersonViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.item = getItem(position)
    }
}

class PersonViewHolder(private val view: View, private val onClickListener: (Person) -> Unit) :
    RecyclerView.ViewHolder(view) {

    var item: Person? = null
        set(value) {
            value?.let { newValue ->
                field = newValue
                view.setOnClickListener { onClickListener(newValue) }
                view.findViewById<TextView>(R.id.textViewName).text = "${newValue.firstName} ${newValue.lastName}"
                view.findViewById<TextView>(R.id.textViewEmailAddress).text = newValue.emailAddress
            }
        }
}

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}
