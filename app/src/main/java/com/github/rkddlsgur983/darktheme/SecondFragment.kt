package com.github.rkddlsgur983.darktheme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.databinding.FragmentSecondBinding
import com.github.rkddlsgur983.darktheme.theme.ThemeUtil
import com.github.rkddlsgur983.darktheme.util.SharedPreferenceManager

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var appThemeList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        setAppThemeStringArray()
        initAppThemeButton()
    }

    private fun setAppThemeStringArray() {
        appThemeList = arrayOf(getString(R.string.app_theme_default), getString(R.string.app_theme_light), getString(R.string.app_theme_dark))
    }

    private fun initAppThemeButton() {
        binding.appThemeButton.text = appThemeList[SharedPreferenceManager.getAppTheme()]
        binding.appThemeButton.setOnClickListener { showAppThemeSelectDialog() }
    }

    private fun showAppThemeSelectDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.app_theme))
            .setItems(appThemeList) { dialog, which ->
                binding.appThemeButton.text = appThemeList[which]
                SharedPreferenceManager.setAppTheme(which)
                AppCompatDelegate.setDefaultNightMode(ThemeUtil.getAppTheme())
                dialog.dismiss()
            }
            .show()
    }

    companion object {
        const val TAG = "SecondFragmentTag"
    }
}
