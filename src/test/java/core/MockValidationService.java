package core;

import java.util.List;

import core.validation.CoreError;
import core.validation.ValidationRule;
import core.validation.ValidationService;
import dto.AddToDoRequest;

class MockValidationService extends ValidationService {
    public MockValidationService(List<ValidationRule> validationRules) {
        super(validationRules);
    }

    @Override
    public List<CoreError> validate(AddToDoRequest request) {
        //mock
        return List.of();
    }
}
