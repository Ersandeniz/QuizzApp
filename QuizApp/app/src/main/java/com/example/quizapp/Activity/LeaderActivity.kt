package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.example.quizapp.Adapter.LeaderAdapter
import com.example.quizapp.Domain.UserModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLeaderBinding
import com.example.quizapp.databinding.ViewholderViewsBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding:ActivityLeaderBinding
    private val leaderAdapter by lazy{LeaderAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window: Window =this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.grey)
        binding.apply {
            scoreTop1Txt.text = loadData().get(0).score.toString()
            scoreTop2Txt.text = loadData().get(1).score.toString()
            scoreTop3Txt.text = loadData().get(2).score.toString()
            titleTop1Txy.text=loadData().get(0).name
            titleTop2Txy.text=loadData().get(1).name
            titleTop3Txy.text=loadData().get(2).name

            val drawableResourceId:Int=binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable" , binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId)
                .into(pic1)

            val drawableResourceId2:Int=binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable" , binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3:Int=binding.root.resources.getIdentifier(
                loadData().get(2).pic,"drawable" , binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if(it==R.id.home){
                    startActivity(Intent(this@LeaderActivity , MainActivity::class.java))

                }
            }
            var list:MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter =leaderAdapter
            }


        }


    }
    private  fun loadData():MutableList<UserModel>{
        val user:MutableList<UserModel> = mutableListOf()
        user.add(UserModel(1,"Ersan", "person1", 4850))
        user.add(UserModel(2,"Kemal", "person2", 4560))
        user.add(UserModel(3,"Fatih", "person3", 3873))
        user.add(UserModel(4,"Emin", "person4", 3250))
        user.add(UserModel(5,"Zanaty", "person5", 3015))
        user.add(UserModel(6,"Muhammed", "person6", 2970))
        user.add(UserModel(7,"Mustafa", "person7", 2870))
        user.add(UserModel(8,"Melih", "person8", 2670))
        user.add(UserModel(9,"AhmetOda", "person9", 2380))
        user.add(UserModel(10,"Taner", "person9", 2380))
        return user


    }
}