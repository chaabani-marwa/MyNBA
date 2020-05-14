package tn.odc.mynba.adapter

import androidx.recyclerview.widget.RecyclerView
import tn.odc.mynba.databinding.UserItemBinding
import tn.odc.mynba.model.UserModel

class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userModel: UserModel){
        binding.userId.text = userModel.id.toString()
        binding.fullName.text = "${userModel.fName} ${userModel.lName}"

    }
}
