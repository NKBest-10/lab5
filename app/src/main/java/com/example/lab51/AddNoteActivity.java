package com.example.lab51;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    // --- UI Elements (ปรับปรุงใหม่) ---
    // ลบ Spinner และ List<User> ออกไป
    EditText titleText, contentText, etUsername; // เพิ่ม EditText สำหรับชื่อผู้ใช้
    RadioGroup radioGroup;
    Button addNoteButton, homeButton;
    TextView showNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // --- 1. เชื่อม UI กับตัวแปร ---
        initializeViews();

        // --- 2. ตั้งค่า Listener ให้ปุ่ม (เหมือนเดิม) ---
        addNoteButton.setOnClickListener(v -> saveNote());

        homeButton.setOnClickListener(v -> {
            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);
        });
    }

    /**
     * เมธอดสำหรับเชื่อม UI elements ทั้งหมด
     */
    private void initializeViews() {
        titleText = findViewById(R.id.editTextText);
        contentText = findViewById(R.id.editTextTextMultiLine);
        radioGroup = findViewById(R.id.RadioGroup);
        addNoteButton = findViewById(R.id.button4);
        homeButton = findViewById(R.id.button5);
        showNote = findViewById(R.id.textView4);

        // เชื่อม EditText สำหรับกรอกชื่อผู้ใช้ที่เพิ่มเข้ามาใหม่
        etUsername = findViewById(R.id.etUsername);
    }

    /**
     * เมธอดสำหรับบันทึกโน้ต
     */
    private void saveNote() {
        // --- ดึงข้อมูลจาก UI ทั้งหมด ---
        String username = etUsername.getText().toString().trim();
        String title = titleText.getText().toString().trim();
        String content = contentText.getText().toString().trim();
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        // --- ตรวจสอบว่าผู้ใช้กรอกข้อมูลครบหรือไม่ ---
        if (username.isEmpty() || title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- สร้าง Object User ใหม่จากชื่อที่ผู้ใช้กรอก ---
        // เราใช้ GeneralUser เป็นคลาสพื้นฐาน และใส่ค่า default สำหรับข้อมูลอื่นๆ
        User user = new GeneralUser(username, "Not specified", 0, "Default");

        Note newNote;

        // --- สร้าง Object Note ตามประเภทที่เลือก ---
        if (selectedRadioButtonId == R.id.radioButton4) { // TextNote
            // ส่ง Object 'user' ที่สร้างใหม่เข้าไปด้วย
            newNote = new TextNote(title, new Date(), content, user);

        } else if (selectedRadioButtonId == R.id.radioButton5) { // CheckListNote
            List<String> items = new ArrayList<>(Arrays.asList(content.split("\\s*\\n\\s*")));
            // ส่ง Object 'user' ที่สร้างใหม่เข้าไปด้วย
            newNote = new CheckListNote(title, new Date(), items, user);

        } else {
            Toast.makeText(this, "กรุณาเลือกประเภทของโน้ต", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- แสดงผลลัพธ์ที่ TextView (เหมือนเดิม) ---
        showNote.setText(newNote.display());
        Toast.makeText(this, "บันทึกโน้ตเรียบร้อย!", Toast.LENGTH_SHORT).show();
    }
}