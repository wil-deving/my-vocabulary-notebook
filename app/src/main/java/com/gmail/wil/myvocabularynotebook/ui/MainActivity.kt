package com.gmail.wil.myvocabularynotebook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.gmail.wil.myvocabularynotebook.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fab_main_opt_layout.*

class MainActivity : AppCompatActivity() {

    // Variables to animate FAB
    lateinit var show_fab_new_word: Animation
    lateinit var hide_fab_new_word: Animation
    lateinit var show_fab_training: Animation
    lateinit var hide_fab_training: Animation
    var STATUS = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(TermsToLearnFragment(this))

        bnvNavContentMain.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_to_learn -> { replaceFragment(
                    TermsToLearnFragment(this)
                ) }
                R.id.menu_learned -> { replaceFragment(
                    TermsLearnedFragment(this)
                ) }
            }
            return@setOnNavigationItemSelectedListener true
        }

        // methods to animate FAB and its fabs
        show_fab_new_word = AnimationUtils.loadAnimation(applicationContext,
            R.anim.fab_new_word_show)
        hide_fab_new_word = AnimationUtils.loadAnimation(applicationContext,
            R.anim.fab_new_word_hide)
        show_fab_training = AnimationUtils.loadAnimation(applicationContext,
            R.anim.fab_training_show)
        hide_fab_training = AnimationUtils.loadAnimation(applicationContext,
            R.anim.fab_training_hide)
        fabMainOptions.setOnClickListener {
            if (!STATUS){
                expandFAB()
                STATUS = true
            }else{
                hideFAB()
                STATUS = false
            }
        }
        // actions in sub buttons de FAB
        fab_new_word.setOnClickListener {
            val intent = Intent(this, SelectTypeActivity::class.java)
            startActivity(intent)
        }
        fab_training.setOnClickListener {
            val intent = Intent(this, MainTrainingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameContentMain, fragment)
        // if we want to save flow into fragments when press back
        // fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    // Functions to hide or show buttons of FAB
    private fun expandFAB() {
        val layoutParams = fab_new_word.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab_new_word.width * 0.25).toInt()
        layoutParams.bottomMargin += (fab_new_word.height * 1.7).toInt()
        fab_new_word.layoutParams = layoutParams
        fab_new_word.startAnimation(show_fab_new_word)
        fab_new_word.isClickable = true

        val layoutParams2 = fab_training.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin += (fab_training.width * 1.3).toInt()
        layoutParams2.bottomMargin += (fab_training.height * 1.3).toInt()
        fab_training.layoutParams = layoutParams2
        fab_training.startAnimation(show_fab_training)
        fab_training.isClickable = true
    }

    private fun hideFAB() {
        val layoutParams = fab_new_word.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab_new_word.width * 0.25).toInt()
        layoutParams.bottomMargin -= (fab_new_word.height * 1.7).toInt()
        fab_new_word.layoutParams = layoutParams
        fab_new_word.startAnimation(hide_fab_new_word)
        fab_new_word.isClickable = false

        val layoutParams2 = fab_training.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin -= (fab_training.width * 1.3).toInt()
        layoutParams2.bottomMargin -= (fab_training.height * 1.3).toInt()
        fab_training.layoutParams = layoutParams2
        fab_training.startAnimation(hide_fab_training)
        fab_training.isClickable = false
    }
}