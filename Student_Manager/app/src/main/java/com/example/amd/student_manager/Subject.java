package com.example.amd.student_manager;

/**
 * Created by HP on 12/6/2017.
 */

public class Subject {
    int s_id;
    int class_id;
    String s_name;

    public Subject(int s_id, int class_id, String s_name) {
        this.s_id = s_id;
        this.class_id = class_id;
        this.s_name = s_name;
    }

    public Subject(int class_id, String s_name) {
        this.class_id = class_id;
        this.s_name = s_name;
    }

    public Subject() {
    }
}
