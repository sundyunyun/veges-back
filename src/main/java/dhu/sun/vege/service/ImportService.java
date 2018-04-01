package dhu.sun.vege.service;

import dhu.sun.vege.entity.Import;

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
}
