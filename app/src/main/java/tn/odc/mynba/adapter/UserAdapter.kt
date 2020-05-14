package tn.odc.mynba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tn.odc.mynba.databinding.UserItemBinding
import tn.odc.mynba.model.UserDiffCallback
import tn.odc.mynba.model.UserModel

class UserAdapter : ListAdapter<UserModel, UserViewHolder>(UserDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent, false
            )
        )


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}