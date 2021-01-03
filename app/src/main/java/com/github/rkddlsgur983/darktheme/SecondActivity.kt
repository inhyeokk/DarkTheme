package com.github.rkddlsgur983.darktheme

import android.os.Bundle
import com.github.rkddlsgur983.darktheme.base.BaseAppCompatActivity
import com.github.rkddlsgur983.darktheme.databinding.ActivitySecondBinding

class SecondActivity : BaseAppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initFragment()
        }
    }

    private fun initFragment() {
        val tag = SecondFragment.TAG
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = SecondFragment()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_layout, fragment, tag)
            .commit()
    }
}
