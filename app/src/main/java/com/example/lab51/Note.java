package com.example.lab51;

import java.util.Date;

public abstract class Note {
    protected String title;
    protected Date createdDate;
    protected User owner; // <-- เพิ่มบรรทัดนี้

    // v--v แก้ไข Constructor ให้รับ User ด้วย
    public Note(String title, Date createdDate, User owner) {
        this.title = title;
        this.createdDate = createdDate;
        this.owner = owner; // <-- เพิ่มบรรทัดนี้
    }

    // ... (เมธอดอื่นๆ เหมือนเดิม) ...

    public User getOwner() {
        return owner;
    }

    public abstract String display();
}