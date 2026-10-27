package com.example.kiemtra_laptrinhungdungdidong_2474802016500

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Nhận Email từ LoginActivity
        val email = intent.getStringExtra("email")
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng màn hình hiện tại, quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // Dữ liệu mẫu (ít nhất 05 phần tử)
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Gắn ArrayAdapter với layout mẫu simple_list_item_1
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        lvSubjects.adapter = adapter

        // Bắt sự kiện click: hiện Toast tên phần tử được chọn
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, subjects[position], Toast.LENGTH_SHORT).show()
        }
    }
}