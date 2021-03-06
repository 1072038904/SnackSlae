package com.service.SnacksManage;

import java.util.List;

import com.model.Snacks;
import com.service.common.BaseService;

public interface SnacksService extends BaseService<Snacks>{
void saveNewSnacks(Snacks snacks);
/**
 * 判断零食信息是否存在
 * @param snacks
 * @return
 */
int isSnacksExisted(Snacks snacks);
void saveAllSnacks(List <Snacks>list);
void mergeNewSnacks(Snacks snacks);
List <Snacks>  findAllSnacks();
Snacks findSnacks(Snacks snacks);

}
