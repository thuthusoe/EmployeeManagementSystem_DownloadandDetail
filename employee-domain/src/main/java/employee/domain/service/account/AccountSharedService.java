package employee.domain.service.account;

import employee.domain.model.Account;

public interface AccountSharedService {
    Account findOne(String username);
}
