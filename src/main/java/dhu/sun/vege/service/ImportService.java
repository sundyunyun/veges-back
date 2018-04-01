package dhu.sun.vege.service;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.model.view.ImpolistView;

import java.util.List;

/**
 * Created by think on 2018/3/30.
 */
public interface ImportService {
    /**
     * 添加进货单
     */
    Import addImport(Import impo);

    /**
     * 添加进货单完成
     */
    Import addImportDone(Long importId);
    /**
     * 根据采购员获取进货单列表
     */
    List<ImpolistView> getImpoBybuyerId(Long buyerId);
}
