package com.example.lab51;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CheckListNote extends Note {
    private List<String> items;

    // v--v แก้ไข Constructor
    public CheckListNote(String title, Date createdDate, List<String> items, User owner) {
        super(title, createdDate, owner); // <-- ส่ง owner ให้คลาสแม่
        this.items = items;
    }

    // ... (เมธอด getter/setter เหมือนเดิม) ...

    @Override
    public String display() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = sdf.format(createdDate);

        StringBuilder sb = new StringBuilder();
        // v--v เพิ่มการแสดงชื่อเจ้าของโน้ต
        sb.append(title).append(" (Owner: ").append(owner.getFullName()).append(", ").append(formattedDate).append(")\n");
        for (String item : items) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }
}
