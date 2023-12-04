package com.ension.if9.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ension.if9.R
import com.ension.if9.view.absen.AbsenActivity
import com.ension.if9.view.history.HistoryActivity
import com.ension.if9.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var strTitle: String

    var REQ_PERMISSION = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

//        setPermission()
        setInitLayout()
    }



//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        for (grantResult in grantResults) {
//            if (grantResult == PackageManager.PERMISSION_GRANTED) {
//                val intent = intent
//                finish()
//                startActivity(intent)
//            }
//        }
//    }


    private fun setInitLayout() {

        cvAbsenMasuk.setOnClickListener {
            strTitle = "Absen Masuk"
            val intent = Intent(this@MainActivity, AbsenActivity::class.java)
            intent.putExtra(AbsenActivity.DATA_TITLE, strTitle)
            startActivity(intent)
        }

        cvAbsenKeluar.setOnClickListener {
            strTitle = "Absen Keluar"
            val intent = Intent(this@MainActivity, AbsenActivity::class.java)
            intent.putExtra(AbsenActivity.DATA_TITLE, strTitle)
            startActivity(intent)
        }

        cvPerizinan.setOnClickListener {
            strTitle = "Izin"
            val intent = Intent(this@MainActivity, AbsenActivity::class.java)
            intent.putExtra(AbsenActivity.DATA_TITLE, strTitle)
            startActivity(intent)
        }

        cvHistory.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        imageLogout.setOnClickListener {
            auth.signOut()
            Intent(this@MainActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
//                val builder = AlertDialog.Builder(this@MainActivity)
//                builder.setMessage("Yakin Anda ingin Logout?")
//                builder.setCancelable(true)
//                builder.setNegativeButton("Batal") { dialog, which -> dialog.cancel() }
//                builder.setPositiveButton("Ya") { dialog, which ->
////                session.logoutUser()
////                finishAffinity()
//                    val alertDialog = builder.create()
//                    alertDialog.show()
                }

            }
        }
//    private fun setPermission() {
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                REQ_PERMISSION
//            )
//        }
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                REQ_PERMISSION
//            )
//        }
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(Manifest.permission.CAMERA),
//                REQ_PERMISSION
//            )
//        }
//    }
}