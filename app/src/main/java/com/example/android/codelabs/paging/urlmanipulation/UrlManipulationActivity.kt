package com.example.android.codelabs.paging.urlmanipulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.codelabs.paging.R
import kotlinx.android.synthetic.main.activity_url_manipulation.*

class UrlManipulationActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel

    companion object{
        const val TAG = "Response"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url_manipulation)

        val repository = PostsRepository()
        val viewModelFactory = PostViewModelFactory(repository)
        postViewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)

//        postViewModel.getPosts()
//        postViewModel.myResponse.observe(this, Observer {response->
//
//            if (response.isSuccessful){
//                post_text.setText(response.toString())
//                Log.d(TAG, response.body()?.userId.toString())
//                Log.d(TAG, response.body()?.id.toString())
//                Log.d(TAG, response.body()?.body.toString())
//                Log.d(TAG, response.body()?.title.toString())
//            }else{
//                Log.d(TAG, response.errorBody().toString())
//                post_text.text = response.code().toString()
//            }
//
//        })



        get_user_post.setOnClickListener {
            val userNumber = entered_number.text.toString().trim()

//            postViewModel.getPost2(userNumber.toInt())
//            postViewModel.myResponse2.observe(this, Observer {response->
//
//                if (response.isSuccessful){
//                    post_text.setText(response.body().toString())
//                    Log.d(TAG, response.body()?.userId.toString())
//                    Log.d(TAG, response.body()?.id.toString())
//                    Log.d(TAG, response.body()?.body.toString())
//                    Log.d(TAG, response.body()?.title.toString())
//                }else{
//                    post_text.text = response.code().toString()
//                    Log.d(TAG, response.errorBody().toString())
//
//                }
//
//            })


//            postViewModel.getCustomPosts(userNumber.toInt())
//            postViewModel.myCustomPosts.observe(this, Observer {response->
////
//                if (response.isSuccessful){
//                    post_text.setText(response.body().toString())
//                    response.body()?.forEach {
//                        Log.d(TAG, it.userId.toString())
//                        Log.d(TAG, it.id.toString())
//                        Log.d(TAG, it.title)
//                        Log.d(TAG, it.body)
//                        Log.d(TAG, "..............................")
//                    }
//                }else{
//                    post_text.text = response.code().toString()
//                    Log.d(TAG, response.errorBody().toString())
//
//                }
//
//            })



//            postViewModel.getCustomPosts2(userNumber.toInt(), "id", "desc" )
//            postViewModel.myCustomPosts2.observe(this, Observer {response->
////
//                if (response.isSuccessful){
//                    post_text.setText(response.body().toString())
//                    response.body()?.forEach {
//                        Log.d(TAG, it.userId.toString())
//                        Log.d(TAG, it.id.toString())
//                        Log.d(TAG, it.title)
//                        Log.d(TAG, it.body)
//                        Log.d(TAG, "..............................")
//                    }
//                }else{
//                    post_text.text = response.code().toString()
//                    Log.d(TAG, response.errorBody().toString())
//
//                }
//
//            })


//            USING HASMAP FOR QUERY
            val options: HashMap<String, String> = HashMap()
            options.put("_sort", "id")
            options["_order"] = "desc"

            postViewModel.getCustomPosts3(userNumber.toInt(), options )
            postViewModel.myCustomPosts3.observe(this, Observer {response->
//
                if (response.isSuccessful){
                    post_text.setText(response.body().toString())
                    response.body()?.forEach {
                        Log.d(TAG, it.userId.toString())
                        Log.d(TAG, it.id.toString())
                        Log.d(TAG, it.title)
                        Log.d(TAG, it.body)
                        Log.d(TAG, "..............................")
                    }
                }else{
                    post_text.text = response.code().toString()
                    Log.d(TAG, response.errorBody().toString())

                }

            })

        }
    }
}