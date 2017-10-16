package com.service.AccountManage;

import com.model.Snacks;

public interface SnacksService {
void saveNewSnacks(Snacks snacks);
Snacks findSnacks(Snacks snacks);
}
