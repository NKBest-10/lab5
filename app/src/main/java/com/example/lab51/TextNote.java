package com.example.lab51;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TextNote extends Note {
    private String textContent;

    // v--v แก้ไข Constructor
    public TextNote(String title, Date createDate, String textContent, User owner) {
        super(title, createDate, owner); // <-- ส่ง owner ให้คลาสแม่
        this.textContent = textContent;
    }

    // ... (เมธอด getter/setter เหมือนเดิม) ...

    @Override
    public String display() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        String formattedDate = sdf.format(createdDate);
        // v--v เพิ่มการแสดงชื่อเจ้าของโน้ต
        return String.format("Title: %s\nContent: %s\nOwner: %s (%s)", title, textContent, owner.getFullName(), formattedDate);
    }
}