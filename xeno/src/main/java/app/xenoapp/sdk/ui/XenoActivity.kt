package app.xenoapp.sdk.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.WindowManager
import app.xenoapp.sdk.R


class XenoActivity : FragmentActivity() {

    val fragment = XenoViewFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xeno)

        val color = intent.getStringExtra("LOADER_COLOR")
        fragment.setColor(color)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setStatusBarColor(Color.TRANSPARENT)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.xeno_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        fragment.goBack()
    }
}
