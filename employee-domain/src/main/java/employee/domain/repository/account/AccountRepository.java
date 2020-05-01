package employee.domain.repository.account;

import employee.domain.model.Account;

public interface AccountRepository {
    Account findOne(String username);
}