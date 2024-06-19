package com.bookstore.validator;

import com.bookstore.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Validator;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        // Kiểm tra xem User đã được gán giá trị hay chưa
        if (user == null) { // BỎ qua validation trườn hợp user null
            return true; // Không có User nào được chọn
        }
        return user.getId() != null; // User hợp lệ (có thể là một User mới được tạo, chưa có ID)
    }
}