package com.github.rkddlsgur983.darktheme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.base.BaseAppCompatActivity
import com.github.rkddlsgur983.darktheme.databinding.ActivityMainBinding
import com.github.rkddlsgur983.darktheme.theme.ThemeUtil
import com.github.rkddlsgur983.darktheme.util.SharedPreferenceManager

class MainActivity : BaseAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appThemeList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        setAppThemeStringArray()
        initAppThemeButton()
        initOpenSecondButton()
    }

    private fun setAppThemeStringArray() {
        appThemeList = arrayOf(getString(R.string.app_theme_default), getString(R.string.app_theme_light), getString(R.string.app_theme_dark))
    }

    private fun initAppThemeButton() {
        binding.appThemeButton.text = appThemeList[SharedPreferenceManager.getAppTheme()]
        binding.appThemeButton.setOnClickListener { showAppThemeSelectDialog() }
    }

    private fun showAppThemeSelectDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.app_theme))
            .setItems(appThemeList) { dialog, which ->
                binding.appThemeButton.text = appThemeList[which]
                SharedPreferenceManager.setAppTheme(which)
                AppCompatDelegate.setDefaultNightMode(ThemeUtil.getAppTheme())
                dialog.dismiss()
            }
            .show()
    }

    private fun initOpenSecondButton() {
        binding.openSecondButton.setOnClickListener { goToSecondActivity() }
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}
