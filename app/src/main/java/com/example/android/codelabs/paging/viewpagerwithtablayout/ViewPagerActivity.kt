package com.example.android.codelabs.paging.viewpagerwithtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.android.codelabs.paging.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val vpImages = listOf(
                R.drawable.ic_eye,
                R.drawable.thinkrlogo,
                R.drawable.ic_facebook,
                R.drawable.ic_twitter,
                R.drawable.ic_star,
                R.drawable.ic_baseline_message_24,
        )

        val adapter = ViewPagerAdapter(vpImages)
        viewPager.adapter = adapter

//        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//
//        viewPager.beginFakeDrag()
//        viewPager.fakeDragBy(-10f)
//        viewPager.endFakeDrag()

        TabLayoutMediator(tab_layout, viewPager){tab, position->

            tab.text = "Tab ${position + 1}"

        }.attach()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "ReSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "UnSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })



    }
}