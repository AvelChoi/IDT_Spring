package com.example.springform;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

    /*
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    */

    @Override
    public boolean supports(Class clazz) {
        return Member.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // not null인지 체크할 수 있는 함수
        // name에서 오류가 발생하면 validation check를 해준다
        ValidationUtils.rejectIfEmpty(errors, "name", "", "값이 없으면 안됨");

        // type cast를 해준다.
        Member member = (Member) target;
        if (member.getAge() > 100) {
            errors.rejectValue("age", "", "100보다 크면 안됨");
        }

    }
}
