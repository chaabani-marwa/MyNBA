package tn.odc.mynba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.odc.mynba.adapter.UserAdapter
import tn.odc.mynba.databinding.ActivityMainBinding
import tn.odc.mynba.model.UserModel
import tn.odc.mynba.networking.RetrofitInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitInstance.create().getAllUser().enqueue(object : Callback<List<UserModel>>{
            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ERROR "+ t.message, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val list = response.body()
                    val adapter = UserAdapter()
                    adapter.submitList(list)
                    binding.recycler.apply {
                        this.adapter = adapter
                        this.layoutManager =  LinearLayoutManager(this@MainActivity)
                    }
                }
            }
        })
    }
}

