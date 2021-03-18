package com.ssm.leaning.anno;

public class User {

    @Autowired
    private Student student;

    public void say(){
        student.say();
    }

}
