/*
Nama        : Dani Herawan
NIM         : 10122331
Kelas       : P.ANDRO 4
Tanggal     : 21 Mei 2025
Jam Selesai : 20:20
*/

package com.example.androidform

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidform.Model.Assessment
import com.example.androidform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinners()

        binding.btnSubmit.setOnClickListener {
            submitForm()
        }

        binding.rgInstalasi.setOnCheckedChangeListener { _, checkedId ->
            binding.etVersiAs.isEnabled = checkedId == R.id.rbSudah
            if (checkedId != R.id.rbSudah) binding.etVersiAs.text.clear()
        }
    }

    private fun setupSpinners(){
        val semesterList = resources.getStringArray(R.array.pilihan_semester)
        val semesterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, semesterList)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSemester.adapter = semesterAdapter

        val deviceList = resources.getStringArray(R.array.pilihan_device_coding)
        val deviceAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, deviceList)
        deviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDevice.adapter = deviceAdapter

        val osList = resources.getStringArray(R.array.pilihan_os)
        val osAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, osList)
        osAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOs.adapter = osAdapter

        val deploymentList = resources.getStringArray(R.array.pilihan_deployment)
        val deploymentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, deploymentList)
        deploymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDeployment.adapter = deploymentAdapter

        val internetList = resources.getStringArray(R.array.pilihan_penggunaan_internet)
        val internetAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, internetList)
        internetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerInternet.adapter = internetAdapter

    }

    private fun submitForm() {
        val nama = binding.etNama.text.toString()
        val nim = binding.etNim.text.toString()
        val semester = binding.spinnerSemester.selectedItem.toString()
        val device = binding.spinnerDevice.selectedItem.toString()
        val os = binding.spinnerOs.selectedItem.toString()
        val versiOs = binding.etVersiOs.text.toString()
        val ram = binding.etRam.text.toString()
        val cpu = binding.etCpu.text.toString()
        val deployment = binding.spinnerDeployment.selectedItem.toString()
        val merkHp = binding.etMerkHp.text.toString()
        val osHpDetail = binding.etOsHpDetail.text.toString()
        val ukuranHp = binding.etUkuranHp.text.toString()
        val penggunaanInternet = binding.spinnerInternet.selectedItem.toString()
        val instalasiAs = when (binding.rgInstalasi.checkedRadioButtonId) {
            R.id.rbSudah -> getString(R.string.sudah_install)
            R.id.rbBelum -> getString(R.string.belum_install)
            else -> ""
        }
        val versiAs = if (instalasiAs == getString(R.string.belum_install)) "" else binding.etVersiAs.text.toString().trim()

        if (nama.isEmpty() || nim.isEmpty() || versiOs.isEmpty() || ram.isEmpty() || cpu.isEmpty() ||
            merkHp.isEmpty() || osHpDetail.isEmpty() || ukuranHp.isEmpty() || instalasiAs.isEmpty()
        ) {
            Toast.makeText(this, "Harap isi semua field yang wajib!", Toast.LENGTH_SHORT).show()
            return
        }

        val assessment = Assessment(
            nama, nim, semester, device, os, versiOs, ram, cpu, deployment, merkHp,
            osHpDetail, ukuranHp, penggunaanInternet, instalasiAs, versiAs
        )

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("assessmentData", assessment)
        startActivity(intent)

    }
}