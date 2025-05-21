package com.example.androidform

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidform.Model.Assessment
import com.example.androidform.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val assessmentData = intent.getParcelableExtra<Assessment>("assessmentData")
        assessmentData?.let {
            binding.tvNama.text = it.nama
            binding.tvNim.text = it.nim
            binding.tvSemester.text = it.semester
            binding.tvDevice.text = it.device
            binding.tvOs.text = it.os
            binding.tvVersiOs.text = it.versiOs
            binding.tvRam.text = it.ram
            binding.tvCpu.text = it.cpu
            binding.tvDeployment.text = it.deployment
            binding.tvMerkHp.text = it.merkHp
            binding.tvOsHpDetail.text = it.osHpDetail
            binding.tvUkuranHp.text = it.ukuranHp
            binding.tvPenggunaanInternet.text = it.penggunaanInternet
            binding.tvInstalasiAs.text = it.instalasiAndroidStudio
            binding.tvVersiAs.text = it.versiAndroidStudio
        }

        binding.btnDeveloper.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.developer_profile_title))
                .setMessage(
                    getString(
                        R.string.developer_profile_message,
                        getString(R.string.developer_name),
                        getString(R.string.developer_email),
                        getString(R.string.developer_university)
                    )
                )
                .setPositiveButton(getString(R.string.close), null)
                .show()
        }
    }
}