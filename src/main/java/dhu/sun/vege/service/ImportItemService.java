package dhu.sun.vege.service;

import dhu.sun.vege.entity.ImportItem;

import java.util.List;

/**
 * Created by think on 2018/4/1.
 */
public interface ImportItemService {
    /**
     * 添加一条进货详情记录
     */
    ImportItem addImportItem(ImportItem importItem);

    /**
     * 根据importId获取详情
     */
    List<ImportItem> getAllByImportId(Long importId);

}
