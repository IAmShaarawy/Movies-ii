package dev.elshaarawy.moviesii

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val stringId: Int? = when (item.itemId) {
            R.id.navigation_movies -> R.string.title_home
            R.id.navigation_like_dislike -> R.string.title_dashboard
            R.id.navigation_info -> R.string.title_notifications
            else -> null
        }
        stringId?.let {
            message.setText(it)
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            true
        } ?: run {
            false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
